/*-
 * ========================LICENSE_START=================================
 * MOTI BackEnd - WAR submodule
 * %%
 * Copyright (C) 2020 - 2021 CSI Piemonte
 * %%
 * SPDX-FileCopyrightText: Copyright 2020 - 2021 | CSI Piemonte
 * SPDX-License-Identifier: EUPL-1.2
 * =========================LICENSE_END==================================
 */
package it.csi.moti.motibe.ejb.business.be.dao.impl.moti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.csi.moti.motibe.ejb.business.be.dao.impl.BaseAuditedEntityDaoImpl;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTInterventoDao;
import it.csi.moti.motibe.ejb.entity.MotiTIntervento;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;
import it.csi.moti.motibe.ejb.util.jpa.Page;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * Data Access Object implementor for the entity MotiTIntervento
 */
@ApplicationScoped
public class MotiTInterventoDaoImpl extends BaseAuditedEntityDaoImpl<Integer, MotiTIntervento>
		implements MotiTInterventoDao {

	@Override
	public Optional<MotiTIntervento> getInterventoByCodIntervento(String codIntervento) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiTIntervento t ");
		jpql.append(" WHERE t.dataCancellazione IS NULL ");

		JpaQueryHelper.andFieldEquals(jpql, params, "t.codIntervento", "codIntervento", codIntervento);

		TypedQuery<MotiTIntervento> query = composeTypedQuery(jpql, params);
		List<MotiTIntervento> results = query.getResultList();

		MotiTIntervento queryResult = null;
		if (!results.isEmpty()) {
			queryResult = results.get(0);
		}

		return Optional.ofNullable(queryResult);
	}

	@Override
	public long countRicerca(FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia,
			List<Utente> referentes, List<Luogo> luogos) {

		Map<String, Object> params = new HashMap<>();

		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiTIntervento t ");
		jpql.append(" WHERE t.dataCancellazione IS NULL ");

		composeQueryRicerca(fonteDati, codIntervento, titolo, tipologia, referentes, luogos, params, jpql);

		Query qn = composeQuery(getCountQuery(jpql), params);
		long count = ((Number) qn.getSingleResult()).longValue();
		return count;
	}

	@Override
	public Page<MotiTIntervento> findPaginated(int page, int size, String sortField, String sortDirection,
			FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia, List<Utente> referentes,
			List<Luogo> luogos) {
		Map<String, Object> params = new HashMap<>();

		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiTIntervento t ");
		jpql.append(" WHERE t.dataCancellazione IS NULL ");

		composeQueryRicerca(fonteDati, codIntervento, titolo, tipologia, referentes, luogos, params, jpql);

		if (sortField != null && sortDirection != null) {
			jpql.append(" ORDER BY ").append(sortField).append(" ").append(sortDirection);
			jpql.append(", t.dataUltimaModifica DESC ");
		}

		if (sortField == null) {
			jpql.append(" ORDER BY t.dataUltimaModifica DESC ");
		}

		return getPagedResult(jpql, params, page, size);
	}

	private void composeQueryRicerca(FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia,
			List<Utente> referentes, List<Luogo> luogos, Map<String, Object> params, StringBuilder jpql) {
		if (fonteDati != null) {
			jpql.append(" AND t.motiDFonteDati.idFonteDati = :idFonteDati ");
			params.put("idFonteDati", fonteDati.getId());
		}
		if (codIntervento != null) {
			JpaQueryHelper.andStringLike(jpql, params, "t.codIntervento", "codIntervento", codIntervento);
		}
		if (titolo != null) {
			JpaQueryHelper.andStringLike(jpql, params, "t.titolo", "titolo", titolo);
		}
		if (tipologia != null) {
			jpql.append(" AND t.motiDTipologia.idTipologia = :idTipologia ");
			params.put("idTipologia", tipologia.getId());
		}
		if (referentes != null && referentes.size() > 0) {
			List<Integer> listaIdUtente = new ArrayList<>();
			for (Utente utente : referentes) {
				listaIdUtente.add(utente.getId());
			}

			jpql.append(" AND EXISTS ( ");
			jpql.append("   FROM MotiRInterventoReferente rit ");
			jpql.append("   WHERE rit.motiTIntervento = t ");
			jpql.append("   AND rit.motiTUtente.idUtente IN :listaIdUtente ");
			jpql.append(" ) ");
			params.put("listaIdUtente", listaIdUtente);
		}
		if (luogos != null && luogos.size() > 0) {
			List<Integer> listaIdLuogo = new ArrayList<>();
			for (Luogo luogo : luogos) {
				listaIdLuogo.add(luogo.getId());
			}

			jpql.append(" AND EXISTS ( ");
			jpql.append("   FROM MotiRInterventoLuogo ril ");
			jpql.append("   WHERE ril.motiTIntervento = t ");
			jpql.append("   AND ril.motiTLuogo.idLuogo IN :listaIdLuogo ");
			jpql.append(" ) ");
			params.put("listaIdLuogo", listaIdLuogo);
		}
	}

}

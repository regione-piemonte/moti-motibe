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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import it.csi.moti.motibe.ejb.business.be.dao.impl.BaseEntityDaoImpl;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDFaseDao;
import it.csi.moti.motibe.ejb.entity.MotiDFase;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;

/**
 * Data Access Object implementor for the entity MotiDFase
 */
@ApplicationScoped
public class MotiDFaseDaoImpl extends BaseEntityDaoImpl<Integer, MotiDFase> implements MotiDFaseDao {

	@Override
	public List<MotiDFase> findByTipologia(String tipologia, Integer idFonteDati) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiDFase fase ");
		jpql.append(" WHERE 1=1 ");

		JpaQueryHelper.andFieldEquals(jpql, params, "fase.tipologia", "tipologia", tipologia);
		JpaQueryHelper.andFieldEquals(jpql, params, "fase.motiDFonteDati.idFonteDati", "idFonteDati", idFonteDati);

		jpql.append(" ORDER BY fase.ordine ");

		TypedQuery<MotiDFase> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}

}

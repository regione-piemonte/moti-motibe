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
package it.csi.moti.motibe.ejb.business.be.dao.moti;

import java.util.List;
import java.util.Optional;

import it.csi.moti.motibe.ejb.business.be.dao.BaseAuditedEntityDao;
import it.csi.moti.motibe.ejb.entity.MotiTIntervento;
import it.csi.moti.motibe.ejb.util.jpa.Page;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * Data Access Object interface for the entity MotiTIntervento
 */
public interface MotiTInterventoDao extends BaseAuditedEntityDao<Integer, MotiTIntervento> {

	public Optional<MotiTIntervento> getInterventoByCodIntervento(String codIntervento);

	public long countRicerca(FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia,
			List<Utente> referentes, List<Luogo> luogos);

	public Page<MotiTIntervento> findPaginated(int page, int size, String sortField, String sortDirection,
			FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia, List<Utente> referentes,
			List<Luogo> luogos);

}

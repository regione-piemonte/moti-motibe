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

import it.csi.moti.motibe.ejb.business.be.dao.BaseEntityDao;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoSituazioneCriticita;

/**
 * Data Access Object interface for the entity
 * MotiRInterventoSituazioneCriticita
 */
public interface MotiRInterventoSituazioneCriticitaDao
		extends BaseEntityDao<Integer, MotiRInterventoSituazioneCriticita> {

	public void deleteByIdIntervento(Integer idIntervento);

}

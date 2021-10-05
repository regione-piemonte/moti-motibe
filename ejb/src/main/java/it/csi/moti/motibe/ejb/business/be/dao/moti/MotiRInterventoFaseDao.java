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
import it.csi.moti.motibe.ejb.entity.MotiRInterventoFase;

/**
 * Data Access Object interface for the entity MotiRInterventoFase
 */
public interface MotiRInterventoFaseDao extends BaseEntityDao<Integer, MotiRInterventoFase> {

	public void deleteByIdIntervento(Integer idIntervento);

}

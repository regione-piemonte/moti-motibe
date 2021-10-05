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
import it.csi.moti.motibe.ejb.entity.MotiRInterventoLuogo;

/**
 * Data Access Object interface for the entity MotiRInterventoLuogo
 */
public interface MotiRInterventoLuogoDao extends BaseEntityDao<Integer, MotiRInterventoLuogo> {

	public void deleteByIdIntervento(Integer idIntervento);

}

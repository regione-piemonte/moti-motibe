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

import it.csi.moti.motibe.ejb.business.be.dao.BaseEntityDao;
import it.csi.moti.motibe.ejb.entity.MotiDStatoAttuaz;

/**
 * Data Access Object interface for the entity MotiDStatoAttuaz
 */
public interface MotiDStatoAttuazDao extends BaseEntityDao<Integer, MotiDStatoAttuaz> {

	public List<MotiDStatoAttuaz> findOrdered();
	
}

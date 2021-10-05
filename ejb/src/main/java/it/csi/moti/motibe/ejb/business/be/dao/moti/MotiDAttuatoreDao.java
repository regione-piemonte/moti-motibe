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
import it.csi.moti.motibe.ejb.entity.MotiDAttuatore;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * Data Access Object interface for the entity MotiDAttuatore
 */
public interface MotiDAttuatoreDao extends BaseEntityDao<Integer, MotiDAttuatore> {

	List<MotiDAttuatore> find(Attuatore attuatore);
}

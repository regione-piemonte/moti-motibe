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

import javax.enterprise.context.ApplicationScoped;

import it.csi.moti.motibe.ejb.business.be.dao.impl.BaseEntityDaoImpl;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDRuoloDao;
import it.csi.moti.motibe.ejb.entity.MotiDRuolo;

/**
 * Data Access Object implementor for the entity MotiDRuolo
 */
@ApplicationScoped
public class MotiDRuoloDaoImpl extends BaseEntityDaoImpl<Integer, MotiDRuolo> implements MotiDRuoloDao {

}

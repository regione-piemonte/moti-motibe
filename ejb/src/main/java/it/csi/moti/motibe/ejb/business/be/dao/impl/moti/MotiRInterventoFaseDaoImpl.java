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
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import it.csi.moti.motibe.ejb.business.be.dao.impl.BaseAuditedEntityDaoImpl;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoFaseDao;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoFase;

/**
 * Data Access Object implementor for the entity MotiRInterventoFase
 */
@ApplicationScoped
public class MotiRInterventoFaseDaoImpl extends BaseAuditedEntityDaoImpl<Integer, MotiRInterventoFase>
		implements MotiRInterventoFaseDao {

	@Override
	public void deleteByIdIntervento(Integer idIntervento) {
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM ").append(clazz.getName());
		sb.append(" WHERE motiTIntervento.idIntervento = :idIntervento");

		Map<String, Object> params = new HashMap<>();
		params.put("idIntervento", idIntervento);

		Query query = composeQuery(sb, params);
		query.executeUpdate();
	}

}

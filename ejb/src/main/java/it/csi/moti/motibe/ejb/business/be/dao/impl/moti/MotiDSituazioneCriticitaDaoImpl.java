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
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDSituazioneCriticitaDao;
import it.csi.moti.motibe.ejb.entity.MotiDSituazioneCriticita;

/**
 * Data Access Object implementor for the entity MotiDSituazioneCriticita
 */
@ApplicationScoped
public class MotiDSituazioneCriticitaDaoImpl extends BaseEntityDaoImpl<Integer, MotiDSituazioneCriticita>
		implements MotiDSituazioneCriticitaDao {

	@Override
	public List<MotiDSituazioneCriticita> findOrdered() {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiDSituazioneCriticita d ");
		jpql.append(" WHERE 1=1 ");
		jpql.append(" ORDER BY d.ordine ");

		TypedQuery<MotiDSituazioneCriticita> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}

}

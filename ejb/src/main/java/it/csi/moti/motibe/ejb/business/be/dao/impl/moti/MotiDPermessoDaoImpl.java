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
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDPermessoDao;
import it.csi.moti.motibe.ejb.entity.MotiDPermesso;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;

/**
 * Data Access Object implementor for the entity MotiDPermesso
 */
@ApplicationScoped
public class MotiDPermessoDaoImpl extends BaseEntityDaoImpl<Integer, MotiDPermesso> implements MotiDPermessoDao {

	@Override
	public List<MotiDPermesso> findByTipologia(String tipologia) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiDPermesso fase ");
		jpql.append(" WHERE 1=1 ");

		JpaQueryHelper.andFieldEquals(jpql, params, "fase.tipologia", "tipologia", tipologia);

		jpql.append(" ORDER BY fase.ordine ");

		TypedQuery<MotiDPermesso> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}

}

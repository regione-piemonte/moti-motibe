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
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTLuogoDao;
import it.csi.moti.motibe.ejb.entity.MotiDFonteFinanziamento;
import it.csi.moti.motibe.ejb.entity.MotiTLuogo;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;

/**
 * Data Access Object implementor for the entity MotiTLuogo
 */
@ApplicationScoped
public class MotiTLuogoDaoImpl extends BaseEntityDaoImpl<Integer, MotiTLuogo> implements MotiTLuogoDao {

	@Override
	public List<MotiTLuogo> findOrdered() {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiTLuogo t ");
		jpql.append(" WHERE 1=1 ");
		jpql.append(" ORDER BY t.flagProvincia DESC, t.denomLuogo ");

		TypedQuery<MotiTLuogo> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}

}

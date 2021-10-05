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
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDFonteFinanziamentoDao;
import it.csi.moti.motibe.ejb.entity.MotiDFonteFinanziamento;

/**
 * Data Access Object implementor for the entity MotiDFonteFinanziamento
 */
@ApplicationScoped
public class MotiDFonteFinanziamentoDaoImpl extends BaseEntityDaoImpl<Integer, MotiDFonteFinanziamento> implements MotiDFonteFinanziamentoDao {

	@Override
	public List<MotiDFonteFinanziamento> findOrdered() {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiDFonteFinanziamento d ");
		jpql.append(" WHERE 1=1 ");
		jpql.append(" ORDER BY d.ordine ");

		TypedQuery<MotiDFonteFinanziamento> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}
	
}

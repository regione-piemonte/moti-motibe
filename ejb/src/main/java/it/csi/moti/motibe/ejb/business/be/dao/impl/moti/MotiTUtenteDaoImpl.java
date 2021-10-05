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
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import it.csi.moti.motibe.ejb.business.be.dao.impl.BaseEntityDaoImpl;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTUtenteDao;
import it.csi.moti.motibe.ejb.entity.MotiTUtente;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;

/**
 * Data Access Object implementor for the entity MotiTPbaIntervento
 */
@ApplicationScoped
public class MotiTUtenteDaoImpl extends BaseEntityDaoImpl<Integer, MotiTUtente> implements MotiTUtenteDao {

	@Override
	public Optional<MotiTUtente> findUtenteByCf(String codiceFiscale) {
		Map<String, Object> params = new HashMap<>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiTUtente ute ");
		jpql.append(" WHERE 1 = 1 ");
		JpaQueryHelper.andFieldEquals(jpql, params, "ute.codiceFiscale", "codiceFiscale", codiceFiscale);
		TypedQuery<MotiTUtente> query = composeTypedQuery(jpql, params);
		return query.getResultList().stream().findFirst();
	}

}

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
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDAttuatoreDao;
import it.csi.moti.motibe.ejb.entity.MotiDAttuatore;
import it.csi.moti.motibe.ejb.util.jpa.JpaQueryHelper;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * Data Access Object implementor for the entity MotiDAttuatore
 */
@ApplicationScoped
public class MotiDAttuatoreDaoImpl extends BaseEntityDaoImpl<Integer, MotiDAttuatore> implements MotiDAttuatoreDao {

	@Override
	public List<MotiDAttuatore> find(Attuatore attuatore) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder jpql = new StringBuilder();
		jpql.append(" FROM MotiDAttuatore t ");
		jpql.append(" WHERE 1=1 ");

		JpaQueryHelper.andStringLike(jpql, params, "t.codiceFiscale", "codiceFiscale", attuatore.getCodiceFiscale());
		JpaQueryHelper.andStringLike(jpql, params, "t.descrizione", "descrizione", attuatore.getDescrizione());

		jpql.append(" ORDER BY t.descrizione ");

		TypedQuery<MotiDAttuatore> query = composeTypedQuery(jpql, params);
		return query.getResultList();
	}

}

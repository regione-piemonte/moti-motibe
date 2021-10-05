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
package it.csi.moti.motibe.ejb.business.be.dad;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTLuogoDao;
import it.csi.moti.motibe.ejb.entity.MotiTLuogo;
import it.csi.moti.motibe.ejb.mapper.MotiMappers;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * Data Access Delegate for decodificas
 */
@ApplicationScoped
public class CommonDad extends BaseDad {

	@Inject
	private MotiTLuogoDao motiTLuogoDao;

	/**
	 * Returns the Luogos
	 * 
	 * @return the Luogos
	 */
	public List<Luogo> getLuogos() {
		List<MotiTLuogo> list = motiTLuogoDao.findOrdered();
		return MotiMappers.LUOGO.toModels(list);
	}

}

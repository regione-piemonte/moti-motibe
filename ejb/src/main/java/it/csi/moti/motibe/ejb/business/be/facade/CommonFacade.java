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
package it.csi.moti.motibe.ejb.business.be.facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dad.CommonDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.common.GetLuogoService;
import it.csi.moti.motibe.ejb.business.be.service.request.common.GetLuogoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.common.GetLuogoResponse;

/**
 * Fa&ccedil;ade for the /common path
 */
@Stateless
public class CommonFacade extends BaseFacade {
	// Injection point
	@Inject
	private CommonDad commonDad;

	/**
	 * Gets the luogos
	 * 
	 * @return the luogos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetLuogoResponse getLuogo() {
		return executeService(new GetLuogoRequest(), new GetLuogoService(configurationHelper, commonDad));
	}

}

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
package it.csi.moti.motibe.ejb.business.be.service.impl.decodifica;

import it.csi.moti.motibe.ejb.business.be.dad.DecodificaDad;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetTipoCriticitaRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetTipoCriticitaResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Gets the TipoCriticitas
 */
public class GetTipoCriticitaService extends BaseDecodificaService<GetTipoCriticitaRequest, GetTipoCriticitaResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param decodificaDad       the DAD for the decodifica
	 */
	public GetTipoCriticitaService(ConfigurationHelper configurationHelper, DecodificaDad decodificaDad) {
		super(configurationHelper, decodificaDad);
	}

	@Override
	protected void execute() {
		response.setTipoCriticitas(decodificaDad.getTipoCriticitas());
	}

}

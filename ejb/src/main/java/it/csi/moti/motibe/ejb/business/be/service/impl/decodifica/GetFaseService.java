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
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetFaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetFaseResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Gets the Fases
 */
public class GetFaseService extends BaseDecodificaService<GetFaseRequest, GetFaseResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param decodificaDad       the DAD for the decodifica
	 */
	public GetFaseService(ConfigurationHelper configurationHelper, DecodificaDad decodificaDad) {
		super(configurationHelper, decodificaDad);
	}

	@Override
	protected void execute() {
		response.setFases(decodificaDad.getFases(request.getTipologia(), request.getIdFonteDati()));
	}

}

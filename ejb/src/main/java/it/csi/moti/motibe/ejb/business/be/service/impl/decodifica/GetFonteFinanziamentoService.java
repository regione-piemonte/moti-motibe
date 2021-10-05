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
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetFonteFinanziamentoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetFonteFinanziamentoResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Gets the FonteFinanziamentos
 */
public class GetFonteFinanziamentoService extends BaseDecodificaService<GetFonteFinanziamentoRequest, GetFonteFinanziamentoResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param decodificaDad       the DAD for the decodifica
	 */
	public GetFonteFinanziamentoService(ConfigurationHelper configurationHelper, DecodificaDad decodificaDad) {
		super(configurationHelper, decodificaDad);
	}

	@Override
	protected void execute() {
		response.setFonteFinanziamentos(decodificaDad.getFonteFinanziamentos());
	}

}

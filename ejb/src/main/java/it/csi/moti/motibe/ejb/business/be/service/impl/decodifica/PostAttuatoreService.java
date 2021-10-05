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
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.PostAttuatoreRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.PostAttuatoreResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * PostAttuatore
 */
public class PostAttuatoreService extends BaseDecodificaService<PostAttuatoreRequest, PostAttuatoreResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param attuatoreDad       the DAD for the attuatore
	 */
	public PostAttuatoreService(ConfigurationHelper configurationHelper, DecodificaDad decodificaDad) {
		super(configurationHelper, decodificaDad);
	}

	@Override
	protected void execute() {
		response.setAttuatore(decodificaDad.insertIntervento(request.getAttuatore()));
	}

}

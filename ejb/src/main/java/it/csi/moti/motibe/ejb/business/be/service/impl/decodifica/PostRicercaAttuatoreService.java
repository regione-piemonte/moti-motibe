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
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.PostRicercaAttuatoreRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.PostRicercaAttuatoreResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * PostRicercaAttuatore
 */
public class PostRicercaAttuatoreService
		extends BaseDecodificaService<PostRicercaAttuatoreRequest, PostRicercaAttuatoreResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param attuatoreDad        the DAD for the attuatore
	 */
	public PostRicercaAttuatoreService(ConfigurationHelper configurationHelper, DecodificaDad decodificaDad) {
		super(configurationHelper, decodificaDad);
	}

	@Override
	protected void execute() {
		response.setAttuatores(decodificaDad.getAttuatores(request.getAttuatore()));
	}

}

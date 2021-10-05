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
package it.csi.moti.motibe.ejb.business.be.service.impl.utente;

import it.csi.moti.motibe.ejb.business.be.dad.UtenteDad;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetReferentiRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetReferentiResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * GetReferenti
 */
public class GetReferentiService extends BaseUtenteService<GetReferentiRequest, GetReferentiResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param utenteDad       the DAD for the utente
	 */
	public GetReferentiService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void execute() {
		response.setUtentes(utenteDad.getReferenti());
	}

}

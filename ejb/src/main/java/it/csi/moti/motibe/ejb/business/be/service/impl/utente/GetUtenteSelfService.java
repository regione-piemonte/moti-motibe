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
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtenteSelfRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtenteSelfResponse;
import it.csi.moti.motibe.ejb.util.MotiThreadLocalContainer;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Retrieves an utente by its id
 */
public class GetUtenteSelfService extends BaseUtenteService<GetUtenteSelfRequest, GetUtenteSelfResponse> {

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente DAD
	 */
	public GetUtenteSelfService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void execute() {
		Utente utente = MotiThreadLocalContainer.UTENTE_CONNESSO.get();
		// Read from DB?
		response.setUtente(utente);
	}

}

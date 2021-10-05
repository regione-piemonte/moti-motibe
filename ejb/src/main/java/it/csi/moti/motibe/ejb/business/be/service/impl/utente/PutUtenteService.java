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
import it.csi.moti.motibe.ejb.business.be.service.request.utente.PutUtenteRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.PutUtenteResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Saves an Utente
 */
public class PutUtenteService extends BaseUtenteService<PutUtenteRequest, PutUtenteResponse> {

	private Utente utente;

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente DAD
	 */
	public PutUtenteService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void checkServiceParams() {
		utente = request.getUtente();
		checkModel(request.getUtente(), "utente");
	}

	@Override
	protected void execute() {
		utenteDad.updateUtente(request.getUtente());
	}
}

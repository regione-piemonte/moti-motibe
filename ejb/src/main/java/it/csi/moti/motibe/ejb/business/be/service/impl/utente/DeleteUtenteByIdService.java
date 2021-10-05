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
import it.csi.moti.motibe.ejb.business.be.service.request.utente.DeleteUtenteByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.DeleteUtenteByIdResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Deletes an utente by its id
 */
public class DeleteUtenteByIdService extends BaseUtenteService<DeleteUtenteByIdRequest, DeleteUtenteByIdResponse> {

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente DAD
	 */
	public DeleteUtenteByIdService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void checkServiceParams() {
		checkNotNull(request.getId(), "id");
	}

	@Override
	protected void execute() {
		System.out.println("deleteUtente");
		// utenteDad.deleteUtente(request.getId());
	}

}

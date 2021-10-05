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
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtenteByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtenteByIdResponse;
import it.csi.moti.motibe.ejb.exception.NotFoundException;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Retrieves an utente by its id
 */
public class GetUtenteByIdService extends BaseUtenteService<GetUtenteByIdRequest, GetUtenteByIdResponse> {

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente DAD
	 */
	public GetUtenteByIdService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void checkServiceParams() {
		checkNotNull(request.getId(), "id");
	}

	@Override
	protected void execute() {
		Utente utente = utenteDad.getUtente(request.getId())
				.orElseThrow(() -> new NotFoundException("utente"));
		response.setUtente(utente);
	}

}

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
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtentiRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtentiResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.util.pagination.PagedList;

/**
 * Retrieves an Utentes
 */
public class GetUtentiService extends BaseUtenteService<GetUtentiRequest, GetUtentiResponse> {

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente DAD
	 */
	public GetUtentiService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper, utenteDad);
	}

	@Override
	protected void execute() {
		PagedList<Utente> utenti = utenteDad.getUtenti(request.getPage(), request.getSize());
		response.setUtenti(utenti);
	}

}

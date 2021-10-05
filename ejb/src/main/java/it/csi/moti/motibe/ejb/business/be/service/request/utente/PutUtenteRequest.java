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
package it.csi.moti.motibe.ejb.business.be.service.request.utente;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Request for putting the Utente
 */
public class PutUtenteRequest implements BaseRequest {

	private final Utente utente;

	/**
	 * Constructor
	 * @param utente the utente
	 */
	public PutUtenteRequest(Utente utente) {
		this.utente = utente;
	}

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}
}

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
package it.csi.moti.motibe.ejb.business.be.service.response.utente;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Response for reading Utente by its id.
 */
public class GetUtenteByIdResponse extends BaseGetResponse<Utente> {

	private Utente utente;

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}

	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	protected Utente getEntity() {
		return utente;
	}

}

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

import it.csi.moti.motibe.ejb.business.be.service.response.base.BasePagedResponse;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * Response for reading Utente by its id.
 */
public class GetUtentiResponse extends BasePagedResponse<Utente> {

	private PagedList<Utente> utenti = new PagedListImpl<>();

	/**
	 * @return the interventi
	 */
	public PagedList<Utente> getUtenti() {
		return utenti;
	}

	/**
	 * @param utenti the utenti to set
	 */
	public void setUtenti(PagedList<Utente> utenti) {
		this.utenti = utenti != null ? utenti : new PagedListImpl<>();
	}

	@Override
	protected PagedList<Utente> getEntity() {
		return utenti;
	}

}

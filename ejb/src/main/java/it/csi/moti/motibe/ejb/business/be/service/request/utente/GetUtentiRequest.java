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

import it.csi.moti.motibe.ejb.business.be.service.request.base.BasePagedRequest;

/**
 * Request for reading the utenti paginated
 */
public class GetUtentiRequest extends BasePagedRequest {

	/**
	 * Constructor
	 * @param size the size
	 * @param page the page
	 */
	public GetUtentiRequest(Integer page, Integer size) {
		super(size, page);
	}

}

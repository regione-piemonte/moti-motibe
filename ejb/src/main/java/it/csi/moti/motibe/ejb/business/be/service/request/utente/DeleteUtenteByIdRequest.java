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

/**
 * Request for deleting the Intervento by its id
 */
public class DeleteUtenteByIdRequest implements BaseRequest {

	private final Integer id;

	/**
	 * Constructor
	 * @param id the id
	 */
	public DeleteUtenteByIdRequest(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
}

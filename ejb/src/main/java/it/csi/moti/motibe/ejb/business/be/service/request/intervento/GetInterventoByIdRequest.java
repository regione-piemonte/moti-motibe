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
package it.csi.moti.motibe.ejb.business.be.service.request.intervento;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;

/**
 * The Class GetInterventoByIdRequest.
 */
public class GetInterventoByIdRequest implements BaseRequest {

	private final Integer id;

	/**
	 * Constructor
	 * 
	 * @param id the id
	 */
	public GetInterventoByIdRequest(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetInterventoByIdRequest []");
		return builder.toString();
	}
}
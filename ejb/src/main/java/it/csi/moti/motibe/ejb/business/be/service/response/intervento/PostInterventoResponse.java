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
package it.csi.moti.motibe.ejb.business.be.service.response.intervento;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BasePostResponse;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * The Class PostInterventoResponse.
 */
public class PostInterventoResponse extends BasePostResponse<Integer, Intervento> {

	private Intervento intervento = null;

	/**
	 * @return the intervento
	 */
	public Intervento getIntervento() {
		return intervento;
	}

	/**
	 * @param intervento the intervento to set
	 */
	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Override
	protected Intervento getEntity() {
		return intervento;
	}

	@Override
	protected String getBaseUri() {
		return "intervento";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostInterventoResponse [intervento=").append(intervento).append(", apiErrors=").append(getApiErrors())
				.append("]");
		return builder.toString();
	}
}

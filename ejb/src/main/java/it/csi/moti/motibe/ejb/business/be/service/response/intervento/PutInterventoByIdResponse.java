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

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * The Class PutInterventoByIdResponse.
 */
public class PutInterventoByIdResponse extends BaseGetResponse<Intervento> {

	/** The model. */
	private Intervento intervento = new Intervento();

	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	@Override
	protected Intervento getEntity() {
		return intervento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PutInterventoByIdResponse [intervento=").append(intervento).append(", apiErrors=")
				.append(getApiErrors()).append("]");
		return builder.toString();
	}

}

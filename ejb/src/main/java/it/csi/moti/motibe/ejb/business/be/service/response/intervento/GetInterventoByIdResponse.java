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
 * The Class GetInterventoByIdResponse.
 */
public class GetInterventoByIdResponse extends BaseGetResponse<Intervento> {

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName() + " [intervento=").append(intervento).append(", apiErrors=")
				.append(getApiErrors()).append("]");
		return builder.toString();
	}

}

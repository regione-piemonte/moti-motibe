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
 * The Class GetInterventoByCodInterventoRequest.
 */
public class GetInterventoByCodInterventoRequest implements BaseRequest {

	private String codIntervento = null;

	public GetInterventoByCodInterventoRequest(String codIntervento) {
		super();
		this.codIntervento = codIntervento;
	}

	/**
	 * @return the codIntervento
	 */
	public String getCodIntervento() {
		return codIntervento;
	}

	/**
	 * @param codIntervento the codIntervento to set
	 */
	public void setCodIntervento(String codIntervento) {
		this.codIntervento = codIntervento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetInterventoByCodInterventoRequest []");
		return builder.toString();
	}
}
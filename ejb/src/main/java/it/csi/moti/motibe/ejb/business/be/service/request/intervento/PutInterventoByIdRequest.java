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
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * The Class PutInterventoByIdRequest.
 */
public class PutInterventoByIdRequest implements BaseRequest {

	private final Intervento intervento;

	/**
	 * @return the intervento
	 */
	public Intervento getIntervento() {
		return intervento;
	}
	
	/**
	 * Constructor
	 * 
	 * @param intervento the intervento
	 */
	public PutInterventoByIdRequest(Intervento intervento) {
		this.intervento = intervento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PutInterventoByIdRequest []");
		return builder.toString();
	}
}
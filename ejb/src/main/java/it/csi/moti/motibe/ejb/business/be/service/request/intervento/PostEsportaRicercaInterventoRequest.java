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
import it.csi.moti.motibe.lib.dto.intervento.RicercaIntervento;

/**
 * The Class PostEsportaRicercaInterventoRequest.
 */
public class PostEsportaRicercaInterventoRequest implements BaseRequest {

	private RicercaIntervento ricercaIntervento;

	public PostEsportaRicercaInterventoRequest(RicercaIntervento ricercaIntervento) {
		super();
		this.ricercaIntervento = ricercaIntervento;
	}

	public RicercaIntervento getRicercaIntervento() {
		return ricercaIntervento;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostEsportaRicercaInterventoRequest []");
		return builder.toString();
	}
}
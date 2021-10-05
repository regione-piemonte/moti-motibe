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
package it.csi.moti.motibe.ejb.business.be.service.request.decodifica;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * The Class GetAttuatoreRequest.
 */
public class PostRicercaAttuatoreRequest implements BaseRequest {

	private Attuatore attuatore;

	public PostRicercaAttuatoreRequest(Attuatore attuatore) {
		super();
		this.attuatore = attuatore;
	}

	/**
	 * @return the attuatore
	 */
	public Attuatore getAttuatore() {
		return attuatore;
	}

	/**
	 * @param attuatore the attuatore to set
	 */
	public void setAttuatore(Attuatore attuatore) {
		this.attuatore = attuatore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAttuatoreRequest []");
		return builder.toString();
	}
}
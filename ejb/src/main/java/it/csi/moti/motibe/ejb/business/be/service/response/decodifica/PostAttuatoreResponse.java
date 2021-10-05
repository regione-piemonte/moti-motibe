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
package it.csi.moti.motibe.ejb.business.be.service.response.decodifica;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * The Class PostAttuatoreResponse.
 */
public class PostAttuatoreResponse extends BaseGetResponse<Attuatore> {

	/** The model. */
	private Attuatore attuatore = new Attuatore();

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
	protected Attuatore getEntity() {
		return attuatore;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostAttuatoreResponse [attuatore=").append(attuatore).append(", apiErrors=")
				.append(getApiErrors()).append("]");
		return builder.toString();
	}

}

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
 * The Class PostAttuatoreRequest.
 */
public class PostAttuatoreRequest implements BaseRequest {

	private final Attuatore attuatore;

	/**
	 * Constructor
	 * 
	 * @param attuatore the attuatore
	 */
	public PostAttuatoreRequest(Attuatore attuatore) {
		this.attuatore = attuatore;
	}

	/**
	 * @return the attuatore
	 */
	public Attuatore getAttuatore() {
		return attuatore;
	}

}
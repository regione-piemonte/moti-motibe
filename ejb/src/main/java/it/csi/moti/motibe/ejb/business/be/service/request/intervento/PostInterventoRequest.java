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
 * The Class PostInterventoRequest.
 */
public class PostInterventoRequest implements BaseRequest {

	private final Intervento intervento;

	/**
	 * Constructor
	 * 
	 * @param intervento the intervento
	 */
	public PostInterventoRequest(Intervento intervento) {
		this.intervento = intervento;
	}

	/**
	 * @return the intervento
	 */
	public Intervento getIntervento() {
		return intervento;
	}

}
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
package it.csi.moti.motibe.ejb.business.be.service.response.utente;

import java.util.ArrayList;
import java.util.List;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * The Class GetReferentiResponse.
 */
public class GetReferentiResponse extends BaseGetResponse<List<Utente>> {

	/** The model. */
	private List<Utente> utentes = new ArrayList<Utente>();

	/**
	 * @return the utentes
	 */
	public List<Utente> getUtentes() {
		return utentes;
	}

	/**
	 * @param utentes the utentes to set
	 */
	public void setUtentes(List<Utente> utentes) {
		this.utentes = utentes;
	}

	@Override
	protected List<Utente> getEntity() {
		return utentes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetReferentiResponse [utentes=").append(utentes).append(", apiErrors=").append(getApiErrors())
				.append("]");
		return builder.toString();
	}

}

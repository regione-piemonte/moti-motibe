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

import java.util.ArrayList;
import java.util.List;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;

/**
 * The Class GetTipologiaResponse.
 */
public class GetTipologiaResponse extends BaseGetResponse<List<Tipologia>> {

	/** The tipologias. */
	private List<Tipologia> tipologias = new ArrayList<>();

	/**
	 * @return the tipologias
	 */
	public List<Tipologia> getTipologias() {
		return tipologias;
	}

	/**
	 * @param prioritas the tipologias to set
	 */
	public void setTipologias(List<Tipologia> tipologias) {
		this.tipologias = tipologias;
	}

	@Override
	protected List<Tipologia> getEntity() {
		return tipologias;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetTipologiaResponse [tipologias=").append(tipologias).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

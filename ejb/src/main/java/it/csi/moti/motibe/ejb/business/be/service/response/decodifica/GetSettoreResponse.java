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
import it.csi.moti.motibe.lib.dto.decodifiche.Settore;

/**
 * The Class GetSettoreResponse.
 */
public class GetSettoreResponse extends BaseGetResponse<List<Settore>> {

	/** The settores. */
	private List<Settore> settores = new ArrayList<>();

	/**
	 * @return the settores
	 */
	public List<Settore> getSettores() {
		return settores;
	}

	/**
	 * @param prioritas the prioritas to set
	 */
	public void setSettores(List<Settore> settores) {
		this.settores = settores;
	}

	@Override
	protected List<Settore> getEntity() {
		return settores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetSettoreResponse [settores=").append(settores).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

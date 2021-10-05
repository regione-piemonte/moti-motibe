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
import it.csi.moti.motibe.lib.dto.decodifiche.StatoAttuaz;

/**
 * The Class GetStatoAttuazResponse.
 */
public class GetStatoAttuazResponse extends BaseGetResponse<List<StatoAttuaz>> {

	/** The statoAttuazs. */
	private List<StatoAttuaz> statoAttuazs = new ArrayList<>();

	/**
	 * @return the statoAttuazs
	 */
	public List<StatoAttuaz> getStatoAttuazs() {
		return statoAttuazs;
	}

	/**
	 * @param prioritas the prioritas to set
	 */
	public void setStatoAttuazs(List<StatoAttuaz> statoAttuazs) {
		this.statoAttuazs = statoAttuazs;
	}

	@Override
	protected List<StatoAttuaz> getEntity() {
		return statoAttuazs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetStatoAttuazResponse [statoAttuazs=").append(statoAttuazs).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

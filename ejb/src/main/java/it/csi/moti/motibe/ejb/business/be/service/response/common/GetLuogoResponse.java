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
package it.csi.moti.motibe.ejb.business.be.service.response.common;

import java.util.ArrayList;
import java.util.List;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * The Class GetLuogoResponse.
 */
public class GetLuogoResponse extends BaseGetResponse<List<Luogo>> {

	/** The model. */
	private List<Luogo> luogos = new ArrayList<Luogo>();

	/**
	 * @return the luogos
	 */
	public List<Luogo> getLuogos() {
		return luogos;
	}

	/**
	 * @param luogos the luogos to set
	 */
	public void setLuogos(List<Luogo> luogos) {
		this.luogos = luogos;
	}

	@Override
	protected List<Luogo> getEntity() {
		return luogos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetLuogoResponse [luogos=").append(luogos).append(", apiErrors=").append(getApiErrors())
				.append("]");
		return builder.toString();
	}

}

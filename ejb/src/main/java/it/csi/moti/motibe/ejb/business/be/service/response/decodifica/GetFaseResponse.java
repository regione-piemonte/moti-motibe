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
import it.csi.moti.motibe.lib.dto.decodifiche.Fase;

/**
 * The Class GetFaseResponse.
 */
public class GetFaseResponse extends BaseGetResponse<List<Fase>> {

	/** The fonteDatis. */
	private List<Fase> fases = new ArrayList<>();

	/**
	 * @return the prioritas
	 */
	public List<Fase> getFases() {
		return fases;
	}

	/**
	 * @param fonteDatis the fonteDatis to set
	 */
	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	@Override
	protected List<Fase> getEntity() {
		return fases;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetFaseResponse [fases=").append(fases).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

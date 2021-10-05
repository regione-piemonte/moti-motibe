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
import it.csi.moti.motibe.lib.dto.decodifiche.Ruolo;

/**
 * The Class GetRuoloResponse.
 */
public class GetRuoloResponse extends BaseGetResponse<List<Ruolo>> {

	/** The ruolos. */
	private List<Ruolo> ruolos = new ArrayList<>();

	/**
	 * @return the ruolos
	 */
	public List<Ruolo> getRuolos() {
		return ruolos;
	}

	/**
	 * @param ruolos the ruolos to set
	 */
	public void setRuolos(List<Ruolo> ruolos) {
		this.ruolos = ruolos;
	}

	@Override
	protected List<Ruolo> getEntity() {
		return ruolos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetRuoloResponse [ruolos=").append(ruolos).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

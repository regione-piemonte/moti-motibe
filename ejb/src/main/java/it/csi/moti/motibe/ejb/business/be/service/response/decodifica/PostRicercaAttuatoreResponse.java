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
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * The Class GetAttuatoreResponse.
 */
public class PostRicercaAttuatoreResponse extends BaseGetResponse<List<Attuatore>> {

	private List<Attuatore> attuatores = new ArrayList<>();

	/**
	 * @return the attuatores
	 */
	public List<Attuatore> getAttuatores() {
		return attuatores;
	}

	/**
	 * @param attuatores the attuatores to set
	 */
	public void setAttuatores(List<Attuatore> attuatores) {
		this.attuatores = attuatores;
	}

	@Override
	protected List<Attuatore> getEntity() {
		return attuatores;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAttuatoreResponse [attuatore=").append(attuatores).append(", apiErrors=")
				.append(getApiErrors()).append("]");
		return builder.toString();
	}

}

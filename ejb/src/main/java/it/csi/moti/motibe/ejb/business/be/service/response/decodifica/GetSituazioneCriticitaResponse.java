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
import it.csi.moti.motibe.lib.dto.decodifiche.SituazioneCriticita;

/**
 * The Class GetSituazioneCriticitaResponse.
 */
public class GetSituazioneCriticitaResponse extends BaseGetResponse<List<SituazioneCriticita>> {

	/** The situazioneCriticitas. */
	private List<SituazioneCriticita> situazioneCriticitas = new ArrayList<>();

	/**
	 * @return the situazioneCriticitas
	 */
	public List<SituazioneCriticita> getSituazioneCriticitas() {
		return situazioneCriticitas;
	}

	/**
	 * @param prioritas the situazioneCriticitas to set
	 */
	public void setSituazioneCriticitas(List<SituazioneCriticita> situazioneCriticitas) {
		this.situazioneCriticitas = situazioneCriticitas;
	}

	@Override
	protected List<SituazioneCriticita> getEntity() {
		return situazioneCriticitas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetSituazioneCriticitaResponse [situazioneCriticitas=").append(situazioneCriticitas).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

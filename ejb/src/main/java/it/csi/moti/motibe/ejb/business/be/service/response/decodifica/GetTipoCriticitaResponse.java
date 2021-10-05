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
import it.csi.moti.motibe.lib.dto.decodifiche.TipoCriticita;

/**
 * The Class GetTipoCriticitaResponse.
 */
public class GetTipoCriticitaResponse extends BaseGetResponse<List<TipoCriticita>> {

	/** The tipoCriticitas. */
	private List<TipoCriticita> tipoCriticitas = new ArrayList<>();

	/**
	 * @return the tipoCriticitas
	 */
	public List<TipoCriticita> getTipoCriticitas() {
		return tipoCriticitas;
	}

	/**
	 * @param prioritas the tipoCriticitas to set
	 */
	public void setTipoCriticitas(List<TipoCriticita> tipoCriticitas) {
		this.tipoCriticitas = tipoCriticitas;
	}

	@Override
	protected List<TipoCriticita> getEntity() {
		return tipoCriticitas;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetTipoCriticitaResponse [tipoCriticitas=").append(tipoCriticitas).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

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
import it.csi.moti.motibe.lib.dto.decodifiche.FonteFinanziamento;

/**
 * The Class GetFonteFinanziamentoResponse.
 */
public class GetFonteFinanziamentoResponse extends BaseGetResponse<List<FonteFinanziamento>> {

	/** The fonteFinanziamentos. */
	private List<FonteFinanziamento> fonteFinanziamentos = new ArrayList<>();

	/**
	 * @return the fonteFinanziamentos
	 */
	public List<FonteFinanziamento> getFonteFinanziamentos() {
		return fonteFinanziamentos;
	}

	/**
	 * @param finanziamentos the finanziamentos to set
	 */
	public void setFonteFinanziamentos(List<FonteFinanziamento> fonteFinanziamentos) {
		this.fonteFinanziamentos = fonteFinanziamentos;
	}

	@Override
	protected List<FonteFinanziamento> getEntity() {
		return fonteFinanziamentos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetFonteFinanziamentoResponse [fonteFinanziamentos=").append(fonteFinanziamentos).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

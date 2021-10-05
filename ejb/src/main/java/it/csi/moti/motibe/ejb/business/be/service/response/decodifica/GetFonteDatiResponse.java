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
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;

/**
 * The Class GetFonteDatiResponse.
 */
public class GetFonteDatiResponse extends BaseGetResponse<List<FonteDati>> {

	/** The lingue. */
	private List<FonteDati> fonteDatis = new ArrayList<>();

	/**
	 * @return the fonteDatis
	 */
	public List<FonteDati> getFonteDatis() {
		return fonteDatis;
	}

	/**
	 * @param prioritas the prioritas to set
	 */
	public void setFonteDatis(List<FonteDati> fonteDatis) {
		this.fonteDatis = fonteDatis;
	}

	@Override
	protected List<FonteDati> getEntity() {
		return fonteDatis;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetFonteDatiResponse [fonteDatis=").append(fonteDatis).append(", apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

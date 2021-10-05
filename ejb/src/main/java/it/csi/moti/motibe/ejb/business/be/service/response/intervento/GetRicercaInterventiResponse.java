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
package it.csi.moti.motibe.ejb.business.be.service.response.intervento;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseGetResponse;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * The Class GetRicercaInterventiResponse.
 */
public class GetRicercaInterventiResponse extends BaseGetResponse<PagedList<Intervento>> {

	/** The model. */
	private PagedList<Intervento> interventos = new PagedListImpl<>();

	public PagedList<Intervento> getInterventos() {
		return interventos;
	}

	public void setInterventos(PagedList<Intervento> interventos) {
		this.interventos = interventos;
	}

	@Override
	protected PagedList<Intervento> getEntity() {
		return interventos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetRicercaInterventiResponse [interventos=").append(interventos).append(", apiErrors=")
				.append(getApiErrors()).append("]");
		return builder.toString();
	}

}

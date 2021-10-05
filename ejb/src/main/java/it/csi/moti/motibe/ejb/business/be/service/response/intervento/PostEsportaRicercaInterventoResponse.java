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

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseExportResponse;

/**
 * The Class PostEsportaRicercaInterventoResponse.
 */
public class PostEsportaRicercaInterventoResponse extends BaseExportResponse {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostEsportaRicercaInterventoResponse [apiErrors=").append(getApiErrors()).append("]");
		return builder.toString();
	}

}

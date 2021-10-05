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
package it.csi.moti.motibe.ejb.business.be.service.request.intervento;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * The Class PostEsportaListaInterventiRequest.
 */
public class PostEsportaListaInterventiRequest implements BaseRequest {

	private final PagedListImpl<Intervento> list;

	public PostEsportaListaInterventiRequest(PagedListImpl<Intervento> list) {
		super();
		this.list = list;
	}

	public PagedListImpl<Intervento> getList() {
		return list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PostEsportaListaInterventiRequest []");
		return builder.toString();
	}
}
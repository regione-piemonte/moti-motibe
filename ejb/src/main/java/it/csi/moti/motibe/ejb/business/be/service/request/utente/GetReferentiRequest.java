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
package it.csi.moti.motibe.ejb.business.be.service.request.utente;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;

/**
 * The Class GetReferentiRequest.
 */
public class GetReferentiRequest implements BaseRequest {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetReferentiRequest []");
		return builder.toString();
	}
}
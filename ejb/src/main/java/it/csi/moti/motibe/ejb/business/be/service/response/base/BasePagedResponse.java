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
package it.csi.moti.motibe.ejb.business.be.service.response.base;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.csi.moti.motibe.lib.util.convert.StringHelper;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.serialization.JsonUtility;

/**
 * Base paged response
 * @param <E> the paged type
 */
public abstract class BasePagedResponse<E> extends BaseResponse {

	/**
	 * @return the entity
	 */
	protected abstract PagedList<E> getEntity();

	@Override
	protected Response composeOwnResponse() {
		String serialized = JsonUtility.serialize(getEntity());
		return Response
			.ok(serialized, MediaType.APPLICATION_JSON)
			.build();
	}

}

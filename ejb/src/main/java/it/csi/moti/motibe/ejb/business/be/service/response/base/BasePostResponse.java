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

import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import it.csi.moti.motibe.lib.dto.BaseDto;
import it.csi.moti.motibe.lib.util.convert.StringHelper;
import it.csi.moti.motibe.lib.util.serialization.JsonUtility;

/**
 * Base response for POST methods
 * @param <K> the key type for the DTO
 * @param <D> the DTO type
 */
public abstract class BasePostResponse<K, D extends BaseDto<K>> extends BaseResponse {

	/**
	 * The base URI to use
	 * @return the base URI as string
	 */
	protected abstract String getBaseUri();
	/**
	 * The underlying entity
	 * @return the entity
	 */
	protected abstract D getEntity();

	@Override
	protected Response composeOwnResponse() {
		final String methodName = "composeOwnResponse";
		String serialized = JsonUtility.serialize(getEntity());
		log.debug(methodName, "JSON response: " + serialized);
		return Response
				.status(Status.CREATED)
				.entity(serialized)
				.location(URI.create(getBaseUri() + "/" + getEntity().getId()))
				.build();
	}

}

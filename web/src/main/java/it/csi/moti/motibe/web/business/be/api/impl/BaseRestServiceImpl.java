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
package it.csi.moti.motibe.web.business.be.api.impl;

import javax.ejb.EJBException;
import javax.ws.rs.core.Response;

import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseResponse;
import it.csi.moti.motibe.lib.util.function.SupplierWithException;
import it.csi.moti.motibe.lib.util.log.LogUtil;

/**
 * Base REST service implementor
 */
public abstract class BaseRestServiceImpl {

	/**
	 * The logger.
	 * <p>Anti-pattern: the logger should be private static final, only one per class. We define it as such for easiness
	 */
	protected LogUtil log = new LogUtil(getClass().getSuperclass());

	/**
	 * Invokes a service
	 * @param <E> the exception type
	 * @param supplier the supplier
	 * @return the JAX-RS response
	 */
	protected <E extends EJBException, R extends BaseResponse> Response invoke(SupplierWithException<R, E> supplier) {
		// Proceed with the invocation
		R response = supplier.get();
		if(response == null) {
			// FIXME: Should otherwise send an error?
			return Response.noContent().build();
		}
		return response.composeResponse();
	}

}

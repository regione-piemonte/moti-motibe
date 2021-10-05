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
package it.csi.moti.motibe.web.util.rest.exception;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.ApiError;
import it.csi.moti.motibe.lib.dto.error.CoreError;
import it.csi.moti.motibe.lib.util.log.LogUtil;

/**
 * Exception mapper for the Throwable
 */
@Provider
public class ThrowableExceptionMapper implements ExceptionMapper<Throwable> {

	private static final LogUtil LOG = new LogUtil(ThrowableExceptionMapper.class);

	/** The configuration helper */
	@Inject private ConfigurationHelper configurationHelper;
	/** The servlet response */
	@Context private HttpServletResponse httpServletResponse;

	@Override
	public Response toResponse(Throwable exception) {
		LOG.warn("toResponse", "Received Throwable exception", exception);
		ExceptionMapperHelper emh = new ExceptionMapperHelper(configurationHelper, httpServletResponse, 500);
		ApiError error = CoreError.GENERIC_ERROR.getError("error", exception.getMessage());
		return emh.toResponse(error);
	}

}

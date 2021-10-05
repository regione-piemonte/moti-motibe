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

/**
 * Exception mapper for the Exception
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {

	/** The configuration helper */
	@Inject protected ConfigurationHelper configurationHelper;
	/** The servlet response */
	@Context protected HttpServletResponse httpServletResponse;

	@Override
	public Response toResponse(Exception exception) {
		exception.printStackTrace();
		ExceptionMapperHelper emh = new ExceptionMapperHelper(configurationHelper, httpServletResponse, 500);
		ApiError error = CoreError.GENERIC_ERROR.getError("error", exception.getMessage());
		return emh.toResponse(error);
	}

}

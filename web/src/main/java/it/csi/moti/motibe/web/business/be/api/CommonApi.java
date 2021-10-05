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
package it.csi.moti.motibe.web.business.be.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * API interface for /common path
 */
@Path("common")
@Produces({ MediaType.APPLICATION_JSON })
public interface CommonApi {

	/**
	 * Gets the luogos
	 * 
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("luogo")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getLuogo(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest);

}

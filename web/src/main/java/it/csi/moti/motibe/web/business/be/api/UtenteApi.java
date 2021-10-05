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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.moti.motibe.lib.dto.Utente;

/**
 * API interface for /utente path
 */
@Path("utente")
@Produces({ MediaType.APPLICATION_JSON })
public interface UtenteApi {

	/**
	 * Deletes an Utente by its id
	 * 
	 * @param id              the id
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@DELETE
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteUtenteById(@PathParam("id") Integer id, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Gets the Interventi by the query params
	 * 
	 * @param offset          the offset
	 * @param limit           the limit
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUtenti(@Min(0) @QueryParam("offset") Integer offset,
			@Min(1) @Max(100) @QueryParam("limit") Integer limit, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Posts an Utente
	 * 
	 * @param utente          the utente to save
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response postUtente(Utente utente, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Puts an Utente by its id
	 * 
	 * @param id              the id
	 * @param utente          the utente to update
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response putUtenteById(@PathParam("id") Integer id, Utente utente, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Gets an Utente by its id
	 * 
	 * @param id              the id
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUtenteById(@PathParam("id") Integer id, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Gets the Utente
	 * 
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("self")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUtenteSelf(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest);
	
	/**
	 * Gets all referenti
	 * 
	 * @param id              the id
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("referenti")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReferenti(@Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}

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
import javax.ws.rs.DefaultValue;
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

import it.csi.moti.motibe.ejb.util.mime.MimeTypeContainer.MimeType;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.RicercaIntervento;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * API interface for /intervento path
 */
@Path("int/intervento")
@Produces({ MediaType.APPLICATION_JSON })
public interface InterventoApi {

	/**
	 * Gets the intervento
	 * 
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getIntervento(@PathParam("id") Integer id, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Export the intervento
	 * 
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("esporta/{id}")
	@Produces({ MimeType.EXCEL_WORKBOOK, MimeType.EXCEL_SPREADSHEET, MimeType.PDF })
	public Response getEsportaIntervento(@PathParam("id") Integer id, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Export lista di interventi
	 * 
	 * @param pagedList
	 * @param securityContext
	 * @param httpHeaders
	 * @param httpRequest
	 * @return
	 */
	@POST
	@Path("esporta-lista")
	@Produces({ MimeType.EXCEL_WORKBOOK, MimeType.EXCEL_SPREADSHEET })
	public Response postEsportaListaInterventi(PagedListImpl<Intervento> list, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest);

	/**
	 * Export interventi con filtri ricerca
	 * 
	 * @param ricercaIntervento
	 * @param securityContext
	 * @param httpHeaders
	 * @param httpRequest
	 * @return
	 */
	@POST
	@Path("esporta-ricerca")
	@Produces({ MimeType.EXCEL_WORKBOOK, MimeType.EXCEL_SPREADSHEET })
	public Response postEsportaRicercaIntervento(RicercaIntervento ricercaIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest);

	/**
	 * Gets the intervento
	 * 
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@GET
	@Path("codice/{codIntervento}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getInterventoByCodIntervento(@PathParam("codIntervento") String codIntervento,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest);

	@POST
	@Path("ricerca")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getRicercaInterventi(@Min(0) @QueryParam("offset") Integer page,
			@Min(1) @Max(100) @QueryParam("limit") Integer limit, @QueryParam("sort") @DefaultValue("") String sort,
			@QueryParam("direction") @DefaultValue("asc") String direction, RicercaIntervento ricercaIntervento,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest);

	/**
	 * Posts a Intervento
	 * 
	 * @param intervento
	 * @param securityContext
	 * @param httpHeaders
	 * @param httpRequest
	 * @return
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response postIntervento(Intervento intervento, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

	/**
	 * Puts an Intervento by its id
	 * 
	 * @param id              the id
	 * @param intervento      the intervento to update
	 * @param securityContext the security context
	 * @param httpHeaders     the HTTP headers
	 * @param httpRequest     the HTTP request
	 * @return the response
	 */
	@PUT
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response putInterventoById(@PathParam("id") Integer id, Intervento intervento,
			@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders,
			@Context HttpServletRequest httpRequest);

	/**
	 * Delete a Intervento by its id
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
	public Response deleteIntervento(@PathParam("id") Integer id, @Context SecurityContext securityContext,
			@Context HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest);

}

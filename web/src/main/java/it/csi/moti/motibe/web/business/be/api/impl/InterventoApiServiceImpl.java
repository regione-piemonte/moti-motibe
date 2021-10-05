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

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.moti.motibe.ejb.business.be.facade.InterventoFacade;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.RicercaIntervento;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;
import it.csi.moti.motibe.web.business.be.api.InterventoApi;
import it.csi.moti.motibe.web.util.annotation.Logged;

@Logged
public class InterventoApiServiceImpl extends BaseRestServiceImpl implements InterventoApi {

	@EJB
	private InterventoFacade interventoFacade;

	@Override
	public Response getIntervento(Integer id, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.getInterventoById(id));
	}

	@Override
	public Response getEsportaIntervento(Integer id, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.getEsportaIntervento(id));
	}

	@Override
	public Response postEsportaListaInterventi(PagedListImpl<Intervento> list, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.postEsportaListaInterventi(list));
	}
	
	@Override
	public Response postEsportaRicercaIntervento(RicercaIntervento ricercaIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.postEsportaRicercaIntervento(ricercaIntervento));
	}

	@Override
	public Response getInterventoByCodIntervento(String codIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.getInterventoByCodIntervento(codIntervento));
	}

	@Override
	public Response getRicercaInterventi(@Min(0) Integer page, @Min(1) @Max(100) Integer limit, String sort,
			String direction, RicercaIntervento ricercaIntervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.getRicercaInterventi(page, limit, sort, direction,
				ricercaIntervento.getFonteDati(), ricercaIntervento.getCodIntervento(), ricercaIntervento.getTitolo(),
				ricercaIntervento.getTipologia(), ricercaIntervento.getReferentes(), ricercaIntervento.getLuogos()));
	}

	@Override
	public Response postIntervento(Intervento intervento, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.postIntervento(intervento));
	}

	@Override
	public Response putInterventoById(Integer id, Intervento intervento, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.putInterventoById(id, intervento));
	}

	@Override
	public Response deleteIntervento(Integer idIntervento, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> interventoFacade.deleteIntervento(idIntervento));
	}

}

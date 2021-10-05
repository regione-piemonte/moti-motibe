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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.moti.motibe.ejb.business.be.facade.DecodificaFacade;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;
import it.csi.moti.motibe.web.business.be.api.DecodificaApi;
import it.csi.moti.motibe.web.util.annotation.Logged;

/**
 * Implementation for DecodificaApi
 */
@Logged
public class DecodificaApiServiceImpl extends BaseRestServiceImpl implements DecodificaApi {

	@EJB
	private DecodificaFacade decodificaFacade;

	@Override
	public Response getFase(String tipologia, Integer idFonteDati, SecurityContext securityContext, HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest) {
		return invoke(() -> decodificaFacade.getFase(tipologia, idFonteDati));
	}

	@Override
	public Response getFonteDati(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getFonteDati);
	}

	@Override
	public Response getFonteFinanziamento(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getFonteFinanziamento);
	}

	@Override
	public Response getRuolo(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getRuolo);
	}

	@Override
	public Response getSettore(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getSettore);
	}

	@Override
	public Response getSituazioneCriticita(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getSituazioneCriticita);
	}

	@Override
	public Response getStatoAttuaz(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getStatoAttuaz);
	}

	@Override
	public Response getTipoCriticita(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getTipoCriticita);
	}
	
	@Override
	public Response getTipologia(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(decodificaFacade::getTipologia);
	}

	@Override
	public Response postRicercaAttuatore(Attuatore attuatore, SecurityContext securityContext,
			HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> decodificaFacade.postRicercaAttuatore(attuatore));
	}

	@Override
	public Response postAttuatore(Attuatore attuatore, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> decodificaFacade.postAttuatore(attuatore));
	}

}

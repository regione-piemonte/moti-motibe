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

import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import it.csi.moti.motibe.ejb.business.be.facade.UtenteFacade;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.web.business.be.api.UtenteApi;
import it.csi.moti.motibe.web.util.annotation.Logged;

/**
 * Implementation for InterventoApi
 */
@Logged
public class UtenteApiServiceImpl extends BaseRestServiceImpl implements UtenteApi {

	@EJB
	private UtenteFacade utenteFacade;

	@Override
	public Response deleteUtenteById(Integer id, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.deleteUtenteById(id));
	}

	@Override
	public Response postUtente(Utente utente, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.postUtente(utente));
	}

	@Override
	public Response putUtenteById(Integer id, Utente utente, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.putUtenteById(id, utente));
	}

	@Override
	public Response getUtenteById(Integer id, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.getUtenteById(id));
	}

	@Override
	public Response getUtenti(Integer offset, Integer limit, SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.getUtenti(offset, limit));
	}

	@Override
	public Response getUtenteSelf(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.getUtenteSelf());
	}

	@Override
	public Response getReferenti(SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest httpRequest) {
		return invoke(() -> utenteFacade.getReferenti());
	}

}

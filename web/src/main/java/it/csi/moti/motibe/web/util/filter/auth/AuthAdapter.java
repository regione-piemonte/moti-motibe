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
package it.csi.moti.motibe.web.util.filter.auth;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.UriInfo;

import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Autentication adapter
 */
public interface AuthAdapter {
	/**
	 * Processes the authentication
	 * @param devMode dev mode
	 * @param uriInfo the URI info
	 * @param containerRequest the container request
	 * @return the user associated with the context
	 */
	Utente processAuth(boolean devMode, UriInfo uriInfo, ContainerRequestContext containerRequest);
}

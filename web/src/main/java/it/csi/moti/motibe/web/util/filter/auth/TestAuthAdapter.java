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

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.UriInfo;

import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.util.log.LogUtil;

/**
 * Auth adapter for IRIDE
 */
@ApplicationScoped
public class TestAuthAdapter implements AuthAdapter {

	private static final LogUtil LOG = new LogUtil(TestAuthAdapter.class);

	@Override
	public Utente processAuth(boolean devMode, UriInfo uriInfo, ContainerRequestContext containerRequest) {
		final String methodName = "processAuth";

		Utente utente = new Utente();
		utente.setCodiceFiscale("AAAAAA00A11B000J");
		utente.setNome("pro");
		utente.setCognome("logic");
		utente.setId(new Random().nextInt());

		return utente;
	}

}

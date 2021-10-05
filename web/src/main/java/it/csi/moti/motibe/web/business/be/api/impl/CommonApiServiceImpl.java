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

import it.csi.moti.motibe.ejb.business.be.facade.CommonFacade;
import it.csi.moti.motibe.web.business.be.api.CommonApi;
import it.csi.moti.motibe.web.util.annotation.Logged;

/**
 * Implementation for CommonApi
 */
@Logged
public class CommonApiServiceImpl extends BaseRestServiceImpl implements CommonApi {

	@EJB
	private CommonFacade commonFacade;

	@Override
	public Response getLuogo(SecurityContext securityContext, HttpHeaders httpHeaders, @Context HttpServletRequest httpRequest) {
		return invoke(commonFacade::getLuogo);
	}

}

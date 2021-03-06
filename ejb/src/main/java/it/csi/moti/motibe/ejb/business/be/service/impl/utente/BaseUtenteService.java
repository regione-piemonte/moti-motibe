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
package it.csi.moti.motibe.ejb.business.be.service.impl.utente;

import it.csi.moti.motibe.ejb.business.be.dad.UtenteDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.base.BaseService;
import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Base class for services for /utente path
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class BaseUtenteService<Q extends BaseRequest, R extends BaseResponse> extends BaseService<Q, R> {

	/** Data Access Delegate for utente */
	protected final UtenteDad utenteDad;

	/**
	 * Constructor
	 * @param configurationHelper the configuration helper
	 * @param utenteDad the utente dad
	 */
	protected BaseUtenteService(ConfigurationHelper configurationHelper, UtenteDad utenteDad) {
		super(configurationHelper);
		this.utenteDad = utenteDad;
	}

}

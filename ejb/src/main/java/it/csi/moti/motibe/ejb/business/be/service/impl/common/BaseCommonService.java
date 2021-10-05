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
package it.csi.moti.motibe.ejb.business.be.service.impl.common;

import it.csi.moti.motibe.ejb.business.be.dad.CommonDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.base.BaseService;
import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Base service implementation for the common
 * 
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class BaseCommonService<Q extends BaseRequest, R extends BaseResponse> extends BaseService<Q, R> {

	/** Data Access Delegate for common */
	protected final CommonDad commonDad;

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param commonDad       the DAD for the common
	 */
	protected BaseCommonService(ConfigurationHelper configurationHelper, CommonDad commonDad) {
		super(configurationHelper);
		this.commonDad = commonDad;
	}

}

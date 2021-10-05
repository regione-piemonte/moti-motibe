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
import it.csi.moti.motibe.ejb.business.be.service.request.common.GetLuogoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.common.GetLuogoResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * GetLuogo
 */
public class GetLuogoService extends BaseCommonService<GetLuogoRequest, GetLuogoResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param commonDad       the DAD for the common
	 */
	public GetLuogoService(ConfigurationHelper configurationHelper, CommonDad commonDad) {
		super(configurationHelper, commonDad);
	}

	@Override
	protected void execute() {
		response.setLuogos(commonDad.getLuogos());
	}

}

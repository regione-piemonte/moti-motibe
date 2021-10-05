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
package it.csi.moti.motibe.ejb.business.be.service.impl.intervento;

import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetInterventoByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetInterventoByIdResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * Gets the Intervento
 */
public class GetInterventoByIdService extends BaseInterventoService<GetInterventoByIdRequest, GetInterventoByIdResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public GetInterventoByIdService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		Intervento intervento = interventoDad.getIntervento(request.getId());
		response.setIntervento(intervento);
	}

}

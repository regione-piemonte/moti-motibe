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
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PutInterventoByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PutInterventoByIdResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * PutInterventoById
 */
public class PutInterventoByIdService
		extends BaseInterventoService<PutInterventoByIdRequest, PutInterventoByIdResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public PutInterventoByIdService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		Intervento intervento = request.getIntervento();

		// controllo per la concorrenza
		Intervento interventoAttuale = interventoDad.getIntervento(intervento.getId());
		checkOptlock(interventoAttuale.getOptlock(), intervento.getOptlock());
		setAuditData(intervento, interventoAttuale);

		interventoDad.updateIntervento(intervento);
		
		response.setIntervento(intervento);
	}

}

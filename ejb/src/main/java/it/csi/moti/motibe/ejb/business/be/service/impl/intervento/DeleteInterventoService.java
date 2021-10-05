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
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.DeleteInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.DeleteInterventoResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * DeleteIntervento
 */
public class DeleteInterventoService extends BaseInterventoService<DeleteInterventoRequest, DeleteInterventoResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public DeleteInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		interventoDad.deleteIntervento(request.getIdIntervento());
	}

}

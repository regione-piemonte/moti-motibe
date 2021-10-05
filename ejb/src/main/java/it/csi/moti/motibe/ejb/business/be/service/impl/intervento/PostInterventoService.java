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

import it.csi.moti.motibe.ejb.business.be.dad.DecodificaDad;
import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostInterventoResponse;
import it.csi.moti.motibe.ejb.exception.NotFoundException;
import it.csi.moti.motibe.ejb.util.ConstantsMoti;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.error.MsgMoti;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * Post the Intervento
 */
public class PostInterventoService extends BaseInterventoService<PostInterventoRequest, PostInterventoResponse> {

	private DecodificaDad decodificaDad;

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the interventoDad
	 * @param decodificaDad       the DAD for the decodifica
	 */
	public PostInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad,
			DecodificaDad decodificaDad) {
		super(configurationHelper, interventoDad);
		this.decodificaDad = decodificaDad;
	}

	@Override
	protected void execute() {
		Intervento intervento = request.getIntervento();

		// controllo esistenza intervento
		Intervento interventoOld = null;
		try {
			interventoOld = interventoDad.getInterventoByCodIntervento(intervento.getCodIntervento());
		} catch (NotFoundException notFoundException) {
		}
		checkBusinessCondition(interventoOld == null, MsgMoti.INTINTE0000.getError());
		interventoDad.flushAndClear();

		intervento.setFonteDati(decodificaDad.getFonteDati(ConstantsMoti.FONTE_DATI_NUOVO_MOTI).get());

		intervento = interventoDad.insertIntervento(intervento);
		response.setIntervento(intervento);
	}

}

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
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetRicercaInterventiRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetRicercaInterventiResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.error.MsgMoti;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.util.pagination.PagedList;

/**
 * GetRicercaInterventi
 */
public class GetRicercaInterventiService
		extends BaseInterventoService<GetRicercaInterventiRequest, GetRicercaInterventiResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public GetRicercaInterventiService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		long count = interventoDad.countRicerca(request.getFonteDati(), request.getCodIntervento(), request.getTitolo(),
				request.getTipologia(), request.getReferentes(), request.getLuogos());

		checkBusinessCondition(count > 0, MsgMoti.INTINTE0005.getError());

		PagedList<Intervento> interventos = interventoDad.getRicerca(request.getPage(), request.getSize(),
				request.getSort(), request.getFonteDati(),request.getCodIntervento(), request.getTitolo(), request.getTipologia(),
				request.getReferentes(), request.getLuogos());

		response.setInterventos(interventos);
	}

}

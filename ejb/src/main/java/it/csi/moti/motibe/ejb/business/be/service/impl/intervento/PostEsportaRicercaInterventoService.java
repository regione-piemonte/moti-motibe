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
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostEsportaRicercaInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostEsportaRicercaInterventoResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.ejb.util.mime.MimeTypeContainer;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.pagination.Sort;

/**
 * PostEsportaRicercaIntervento
 */
public class PostEsportaRicercaInterventoService extends
		BaseEsportaInterventoService<PostEsportaRicercaInterventoRequest, PostEsportaRicercaInterventoResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public PostEsportaRicercaInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		int page = 0;
		int size = 0;
		Sort sort = null;
		PagedList<Intervento> interventos = interventoDad.getRicerca(page, size, sort,
				request.getRicercaIntervento().getFonteDati(), request.getRicercaIntervento().getCodIntervento(),
				request.getRicercaIntervento().getTitolo(), request.getRicercaIntervento().getTipologia(),
				request.getRicercaIntervento().getReferentes(), request.getRicercaIntervento().getLuogos());

		// creo report excel
		byte[] bytes = createExcel(interventos.getList());
		final String fileName = "export_ricerca_intervento";
		final String formatFile = "xlsx";

		response.setMimeTypeContainer(MimeTypeContainer.byExtension(formatFile));
		response.setBytes(bytes);
		response.setFileName(fileName);
	}

}

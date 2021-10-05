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

import java.util.List;

import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostEsportaListaInterventiRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostEsportaListaInterventiResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.ejb.util.mime.MimeTypeContainer;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;

/**
 * GetEsportaListaInterventi
 */
public class PostEsportaListaInterventiService
		extends BaseEsportaInterventoService<PostEsportaListaInterventiRequest, PostEsportaListaInterventiResponse> {

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public PostEsportaListaInterventiService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		// creo report excel
		List<Intervento> interventos = request.getList().getList();
		byte[] bytes = createExcel(interventos);
		final String fileName = "export_lista_intervento";
		final String formatFile = "xlsx";

		response.setMimeTypeContainer(MimeTypeContainer.byExtension(formatFile));
		response.setBytes(bytes);
		response.setFileName(fileName);
	}

}

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
package it.csi.moti.motibe.ejb.business.be.facade;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dad.DecodificaDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.PostRicercaAttuatoreService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetFaseService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetFonteDatiService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetFonteFinanziamentoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetRuoloService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetSettoreService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetSituazioneCriticitaService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetStatoAttuazService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetTipoCriticitaService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.GetTipologiaService;
import it.csi.moti.motibe.ejb.business.be.service.impl.decodifica.PostAttuatoreService;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.PostRicercaAttuatoreRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetFaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetFonteDatiRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetFonteFinanziamentoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetRuoloRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetSettoreRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetSituazioneCriticitaRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetStatoAttuazRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetTipoCriticitaRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.GetTipologiaRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.decodifica.PostAttuatoreRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.PostRicercaAttuatoreResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetFaseResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetFonteDatiResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetFonteFinanziamentoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetRuoloResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetSettoreResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetSituazioneCriticitaResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetStatoAttuazResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetTipoCriticitaResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.GetTipologiaResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.decodifica.PostAttuatoreResponse;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;

/**
 * Fa&ccedil;ade for the /decodifica path
 */
@Stateless
public class DecodificaFacade extends BaseFacade {
	// Injection point
	@Inject
	private DecodificaDad decodificaDad;

	/**
	 * Gets the Fases
	 * 
	 * @return the fases
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetFaseResponse getFase(String tipologia, Integer idFonteDati) {
		return executeService(new GetFaseRequest(tipologia, idFonteDati),
				new GetFaseService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the FonteDatis
	 * 
	 * @return the fonteDatis
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetFonteDatiResponse getFonteDati() {
		return executeService(new GetFonteDatiRequest(), new GetFonteDatiService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the FonteFinanziamentos
	 * 
	 * @return the FonteFinanziamentos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetFonteFinanziamentoResponse getFonteFinanziamento() {
		return executeService(new GetFonteFinanziamentoRequest(),
				new GetFonteFinanziamentoService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the Ruolos
	 * 
	 * @return the Ruolos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetRuoloResponse getRuolo() {
		return executeService(new GetRuoloRequest(), new GetRuoloService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the Settores
	 * 
	 * @return the Settores
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetSettoreResponse getSettore() {
		return executeService(new GetSettoreRequest(), new GetSettoreService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the SituazioneCriticitas
	 * 
	 * @return the SituazioneCriticitas
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetSituazioneCriticitaResponse getSituazioneCriticita() {
		return executeService(new GetSituazioneCriticitaRequest(),
				new GetSituazioneCriticitaService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the StatoAttuazs
	 * 
	 * @return the StatoAttuazs
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetStatoAttuazResponse getStatoAttuaz() {
		return executeService(new GetStatoAttuazRequest(),
				new GetStatoAttuazService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the TipoCriticitas
	 * 
	 * @return the TipoCriticitas
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetTipoCriticitaResponse getTipoCriticita() {
		return executeService(new GetTipoCriticitaRequest(),
				new GetTipoCriticitaService(configurationHelper, decodificaDad));
	}

	/**
	 * Gets the Tipologias
	 * 
	 * @return the Tipologias
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetTipologiaResponse getTipologia() {
		return executeService(new GetTipologiaRequest(), new GetTipologiaService(configurationHelper, decodificaDad));
	}

	/**
	 * Post to find the Attuatores
	 * 
	 * @return the attuatores
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PostRicercaAttuatoreResponse postRicercaAttuatore(Attuatore attuatore) {
		return executeService(new PostRicercaAttuatoreRequest(attuatore),
				new PostRicercaAttuatoreService(configurationHelper, decodificaDad));
	}
	
	/**
	 * Post the Attuatores
	 * 
	 * @return the attuatores
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PostAttuatoreResponse postAttuatore(Attuatore attuatore) {
		return executeService(new PostAttuatoreRequest(attuatore),
				new PostAttuatoreService(configurationHelper, decodificaDad));
	}

}

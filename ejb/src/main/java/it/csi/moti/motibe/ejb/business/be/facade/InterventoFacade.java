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

import java.util.List;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dad.DecodificaDad;
import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.DeleteInterventoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.GetEsportaInterventoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.GetInterventoByCodInterventoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.GetInterventoByIdService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.GetRicercaInterventiService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.PostEsportaListaInterventiService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.PostEsportaRicercaInterventoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.PostInterventoService;
import it.csi.moti.motibe.ejb.business.be.service.impl.intervento.PutInterventoByIdService;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.DeleteInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetEsportaInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetInterventoByCodInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetInterventoByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetRicercaInterventiRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostEsportaListaInterventiRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostEsportaRicercaInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PostInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.PutInterventoByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.DeleteInterventoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetEsportaInterventoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetInterventoByCodInterventoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetInterventoByIdResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetRicercaInterventiResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostEsportaListaInterventiResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostEsportaRicercaInterventoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PostInterventoResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.PutInterventoByIdResponse;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;
import it.csi.moti.motibe.lib.dto.intervento.RicercaIntervento;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * Fa&ccedil;ade for the /intervento path
 */
@Stateless
@Lock(LockType.READ)
public class InterventoFacade extends BaseFacade {

	@Inject
	private InterventoDad interventoDad;
	@Inject
	private DecodificaDad decodificaDad;

	/**
	 * Retrieves the Intervento by its id
	 * 
	 * @param id the id
	 * @return the intervento
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetInterventoByIdResponse getInterventoById(Integer id) {
		return executeService(new GetInterventoByIdRequest(id),
				new GetInterventoByIdService(configurationHelper, interventoDad));
	}
	
	/**
	 * Export the Intervento by its id
	 * 
	 * @param id the id
	 * @return the excel
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetEsportaInterventoResponse getEsportaIntervento(Integer id) {
		return executeService(new GetEsportaInterventoRequest(id),
				new GetEsportaInterventoService(configurationHelper, interventoDad));
	}
	
	/**
	 * Export the list of interventi
	 * 
	 * @param id the id
	 * @return the excel
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PostEsportaListaInterventiResponse postEsportaListaInterventi(PagedListImpl<Intervento> list) {
		return executeService(new PostEsportaListaInterventiRequest(list),
				new PostEsportaListaInterventiService(configurationHelper, interventoDad));
	}
	
	/**
	 * Export the list of interventi
	 * 
	 * @param id the id
	 * @return the excel
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public PostEsportaRicercaInterventoResponse postEsportaRicercaIntervento(RicercaIntervento ricercaIntervento) {
		return executeService(new PostEsportaRicercaInterventoRequest(ricercaIntervento),
				new PostEsportaRicercaInterventoService(configurationHelper, interventoDad));
	}

	/**
	 * Retrieves the Intervento by its id
	 * 
	 * @param id the id
	 * @return the intervento
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetInterventoByCodInterventoResponse getInterventoByCodIntervento(String codIntervento) {
		return executeService(new GetInterventoByCodInterventoRequest(codIntervento),
				new GetInterventoByCodInterventoService(configurationHelper, interventoDad));
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetRicercaInterventiResponse getRicercaInterventi(Integer page, Integer limit, String sort, String direction, FonteDati fonteDati,
			String codIntervento, String titolo, Tipologia tipologia, List<Utente> referentes, List<Luogo> luogos) {
		return executeService(new GetRicercaInterventiRequest(page, limit, sort, direction, fonteDati, codIntervento, titolo,
				tipologia, referentes, luogos), new GetRicercaInterventiService(configurationHelper, interventoDad));
	}

	/**
	 * Posts an Intervento
	 * 
	 * @param intervento
	 * @return the intervento
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public PostInterventoResponse postIntervento(Intervento intervento) {
		return executeService(new PostInterventoRequest(intervento),
				new PostInterventoService(configurationHelper, interventoDad, decodificaDad));
	}

	/**
	 * Puts an Intervento
	 * 
	 * @param id         the id
	 * @param intervento
	 * @return the intervento
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public PutInterventoByIdResponse putInterventoById(Integer id, Intervento intervento) {
		return executeService(new PutInterventoByIdRequest(setId(id, intervento)),
				new PutInterventoByIdService(configurationHelper, interventoDad));
	}

	/**
	 * Deletes an Intervento
	 * 
	 * @param idIntervento
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public DeleteInterventoResponse deleteIntervento(Integer idIntervento) {
		return executeService(new DeleteInterventoRequest(idIntervento),
				new DeleteInterventoService(configurationHelper, interventoDad));
	}

}

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

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dad.UtenteDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.utente.DeleteUtenteByIdService;
import it.csi.moti.motibe.ejb.business.be.service.impl.utente.GetReferentiService;
import it.csi.moti.motibe.ejb.business.be.service.impl.utente.GetUtenteByIdService;
import it.csi.moti.motibe.ejb.business.be.service.impl.utente.GetUtenteSelfService;
import it.csi.moti.motibe.ejb.business.be.service.impl.utente.GetUtentiService;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.DeleteUtenteByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetReferentiRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtenteByIdRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtenteSelfRequest;
import it.csi.moti.motibe.ejb.business.be.service.request.utente.GetUtentiRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.DeleteUtenteByIdResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetReferentiResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtenteByIdResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtenteSelfResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.GetUtentiResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.PostUtenteResponse;
import it.csi.moti.motibe.ejb.business.be.service.response.utente.PutUtenteResponse;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Fa&ccedil;ade for the /utente path
 */
@Stateless
@Lock(LockType.READ)
public class UtenteFacade extends BaseFacade {
	// Injection point
	@Inject
	private UtenteDad utenteDad;

	/**
	 * Deletes the Utente by its id
	 * 
	 * @param id the id
	 * @return nothing
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public DeleteUtenteByIdResponse deleteUtenteById(Integer id) {
		return executeService(new DeleteUtenteByIdRequest(id), new DeleteUtenteByIdService(configurationHelper, utenteDad));
		// return new DeleteUtenteByIdResponse();
	}

	/**
	 * Retrieves the utenti
	 * 
	 * @param page  the page
	 * @param limit the limit
	 * @return the utentes
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetUtentiResponse getUtenti(Integer page, Integer limit) {
		return executeService(new GetUtentiRequest(page, limit), new GetUtentiService(configurationHelper, utenteDad));
	}

	/**
	 * Posts an Utente
	 * 
	 * @param utente
	 * @return the utente
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public PostUtenteResponse postUtente(Utente utente) {
		// TODO
		// return executeService(new PostUtenteRequest(utente), new
		// PostUtenteService(configurationHelper, utenteDad,
		// decodificaDad,programmaDad));
		return new PostUtenteResponse();
	}

	/**
	 * Puts an Utente
	 * 
	 * @param id     the id
	 * @param utente
	 * @return the utente
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Lock(LockType.WRITE)
	public PutUtenteResponse putUtenteById(Integer id, Utente utente) {
		// TODO
		// return executeService(new PutUtenteRequest(setId(id, utente)), new
		// PutUtenteService(configurationHelper, utenteDad,
		// decodificaDad,programmaDad));
		return new PutUtenteResponse();
	}

	/**
	 * Retrieves the Utente by its id
	 * 
	 * @param id the id
	 * @return the utente
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetUtenteByIdResponse getUtenteById(Integer id) {
		return executeService(new GetUtenteByIdRequest(id), new GetUtenteByIdService(configurationHelper, utenteDad));
	}

	/**
	 * Retrieves the Utente
	 * 
	 * @return the utente
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetUtenteSelfResponse getUtenteSelf() {
		return executeService(new GetUtenteSelfRequest(), new GetUtenteSelfService(configurationHelper, utenteDad));
	}
	
	/**
	 * Retrieves the Utentes referenti
	 * 
	 * @return utentes
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public GetReferentiResponse getReferenti() {
		return executeService(new GetReferentiRequest(), new GetReferentiService(configurationHelper, utenteDad));
	}

}

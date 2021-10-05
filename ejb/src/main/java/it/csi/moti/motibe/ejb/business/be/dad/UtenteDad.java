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
package it.csi.moti.motibe.ejb.business.be.dad;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTUtenteDao;
import it.csi.moti.motibe.ejb.entity.MotiTUtente;
import it.csi.moti.motibe.ejb.mapper.MotiMappers;
import it.csi.moti.motibe.ejb.util.jpa.Page;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.util.pagination.PagedList;

/**
 * Data Access Delegate for interventos
 */
@ApplicationScoped
public class UtenteDad extends BaseDad {

	@Inject
	private MotiTUtenteDao motiTUtenteDao;
	
	/**
	 * Gets an Utente by its codice fiscale
	 * @param codiceFiscale
	 * @return the utente instance
	 */
	public Optional<Utente> getUtenteByCf(String codiceFiscale) {
		return motiTUtenteDao.findUtenteByCf(codiceFiscale).map(MotiMappers.UTENTE::toModel);
	}
	
	public Optional<Utente> getUtente(Integer id) {
		return motiTUtenteDao.findOne(id).map(MotiMappers.UTENTE::toModel);
	}

	/**
	 * Find paginated
	 * 
	 * @param page the page
	 * @param size the size
	 * @return the model instances
	 */
	public PagedList<Utente> getUtenti(int page, int size) {
		Page<MotiTUtente> motiTUtentes = motiTUtenteDao.findAll(page, size);
		return toPagedList(motiTUtentes, page, size, MotiMappers.UTENTE::toModel);
	}
	
	public List<Utente> getReferenti() {
		List<MotiTUtente> motiTUtentes = motiTUtenteDao.findAll();
		return MotiMappers.UTENTE.toModels(motiTUtentes);
	}
	
	/**
	 * Inserts the utente
	 * 
	 * @param utente the utente
	 * @return the model instance
	 */
	public Utente saveUtente(Utente utente) {
		MotiTUtente motiTutente = MotiMappers.UTENTE.toEntity(utente);
		motiTUtenteDao.insert(motiTutente);
		return utente;
	}

	/**
	 * Updates the utente
	 * 
	 * @param utente the utente
	 * @return the model instance
	 */
	public Utente updateUtente(Utente utente) {
		MotiTUtente motiTutente = MotiMappers.UTENTE.toEntity(utente);
		motiTUtenteDao.update(motiTutente);
		return utente;
	}

}

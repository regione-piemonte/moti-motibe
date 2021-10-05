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

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDAttuatoreDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDFaseDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDFonteDatiDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDFonteFinanziamentoDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDRuoloDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDSettoreDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDSituazioneCriticitaDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDStatoAttuazDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDTipoCriticitaDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiDTipologiaDao;
import it.csi.moti.motibe.ejb.entity.MotiDAttuatore;
import it.csi.moti.motibe.ejb.entity.MotiDFase;
import it.csi.moti.motibe.ejb.entity.MotiDFonteDati;
import it.csi.moti.motibe.ejb.entity.MotiDFonteFinanziamento;
import it.csi.moti.motibe.ejb.entity.MotiDRuolo;
import it.csi.moti.motibe.ejb.entity.MotiDSettore;
import it.csi.moti.motibe.ejb.entity.MotiDSituazioneCriticita;
import it.csi.moti.motibe.ejb.entity.MotiDStatoAttuaz;
import it.csi.moti.motibe.ejb.entity.MotiDTipoCriticita;
import it.csi.moti.motibe.ejb.entity.MotiDTipologia;
import it.csi.moti.motibe.ejb.mapper.MotiMappers;
import it.csi.moti.motibe.ejb.util.MotiThreadLocalContainer;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;
import it.csi.moti.motibe.lib.dto.decodifiche.Fase;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteFinanziamento;
import it.csi.moti.motibe.lib.dto.decodifiche.Ruolo;
import it.csi.moti.motibe.lib.dto.decodifiche.Settore;
import it.csi.moti.motibe.lib.dto.decodifiche.SituazioneCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.StatoAttuaz;
import it.csi.moti.motibe.lib.dto.decodifiche.TipoCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;

/**
 * Data Access Delegate for decodificas
 */
@ApplicationScoped
public class DecodificaDad extends BaseDad {

	@Inject
	private MotiDFaseDao motiDFaseDao;
	@Inject
	private MotiDFonteDatiDao motiDFonteDatiDao;
	@Inject
	private MotiDFonteFinanziamentoDao motiDFonteFinanziamentoDao;
	@Inject
	private MotiDRuoloDao motiDRuoloDao;
	@Inject
	private MotiDSettoreDao motiDSettoreDao;
	@Inject
	private MotiDSituazioneCriticitaDao motiDSituazioneCriticitaDao;
	@Inject
	private MotiDStatoAttuazDao motiDStatoAttuazDao;
	@Inject
	private MotiDTipoCriticitaDao motiDTipoCriticitaDao;
	@Inject
	private MotiDTipologiaDao motiDTipologiaDao;
	@Inject
	private MotiDAttuatoreDao motiDAttuatoreDao;

	/**
	 * Returns the Fase
	 * 
	 * @return the Fase
	 */
	public List<Fase> getFases(String tipologia, Integer idFonteDati) {
		List<MotiDFase> list = motiDFaseDao.findByTipologia(tipologia, idFonteDati);
		return MotiMappers.FASE.toModels(list);
	}

	/**
	 * Returns the FonteDati
	 * 
	 * @param id
	 * @return the FonteDati
	 */
	public Optional<FonteDati> getFonteDati(Integer id) {
		return motiDFonteDatiDao.findOne(id).map(MotiMappers.FONTE_DATI::toModel);
	}

	/**
	 * Returns the FonteDati
	 * 
	 * @return the FonteDati
	 */
	public List<FonteDati> getFonteDatis() {
		List<MotiDFonteDati> list = motiDFonteDatiDao.findOrdered();
		return MotiMappers.FONTE_DATI.toModels(list);
	}

	/**
	 * Returns the FonteFinanziamento
	 * 
	 * @return the FonteFinanziamento
	 */
	public List<FonteFinanziamento> getFonteFinanziamentos() {
		List<MotiDFonteFinanziamento> list = motiDFonteFinanziamentoDao.findOrdered();
		return MotiMappers.FONTE_FINANZIAMENTO.toModels(list);
	}

	/**
	 * Returns the Ruolo
	 * 
	 * @return the Ruolo
	 */
	public List<Ruolo> getRuolos() {
		List<MotiDRuolo> list = motiDRuoloDao.findAll();
		return MotiMappers.RUOLO.toModels(list);
	}

	/**
	 * Returns the Settore
	 * 
	 * @return the Settore
	 */
	public List<Settore> getSettores() {
		List<MotiDSettore> list = motiDSettoreDao.findOrdered();
		return MotiMappers.SETTORE.toModels(list);
	}

	/**
	 * Returns the SituazioneCriticita
	 * 
	 * @return the SituazioneCriticita
	 */
	public List<SituazioneCriticita> getSituazioneCriticitas() {
		List<MotiDSituazioneCriticita> list = motiDSituazioneCriticitaDao.findOrdered();
		return MotiMappers.SITUAZIONE_CRITICITA.toModels(list);
	}

	/**
	 * Returns the StatoAttuaz
	 * 
	 * @return the StatoAttuaz
	 */
	public List<StatoAttuaz> getStatoAttuazs() {
		List<MotiDStatoAttuaz> list = motiDStatoAttuazDao.findOrdered();
		return MotiMappers.STATO_ATTUAZIONE.toModels(list);
	}

	/**
	 * Returns the TipoCriticita
	 * 
	 * @return the TipoCriticita
	 */
	public List<TipoCriticita> getTipoCriticitas() {
		List<MotiDTipoCriticita> list = motiDTipoCriticitaDao.findAll();
		return MotiMappers.TIPO_CRITICITA.toModels(list);
	}

	/**
	 * Returns the Tipologia
	 * 
	 * @return the Tipologia
	 */
	public List<Tipologia> getTipologias() {
		List<MotiDTipologia> list = motiDTipologiaDao.findOrdered();
		return MotiMappers.TIPOLOGIA.toModels(list);
	}

	/**
	 * Returns the Attuatore
	 * 
	 * @return the Attuatore
	 */
	public List<Attuatore> getAttuatores(Attuatore attuatore) {
		List<MotiDAttuatore> list = motiDAttuatoreDao.find(attuatore);
		return MotiMappers.ATTUATORE.toModels(list);
	}

	/**
	 * Inserts the attuatore
	 * 
	 * @param intervento the attuatore
	 * @return the model instance
	 */
	public Attuatore insertIntervento(Attuatore attuatore) {
		attuatore.setDataInserimento(new Date());
		
		if (MotiThreadLocalContainer.UTENTE_CONNESSO.get() != null) {
			Utente utente = MotiThreadLocalContainer.UTENTE_CONNESSO.get();
			attuatore.setUtenteInserimento(utente);
		}

		MotiDAttuatore motiDAttuatore = MotiMappers.ATTUATORE.toEntity(attuatore);
		motiDAttuatore = motiDAttuatoreDao.insert(motiDAttuatore);

		attuatore.setId(motiDAttuatore.getId());
		return attuatore;
	}

}

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

import it.csi.moti.motibe.ejb.business.be.dad.sort.InterventoSort;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoFaseDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoFontefinDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoLuogoDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoReferenteDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiRInterventoSituazioneCriticitaDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTInterventoCostiDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTInterventoDao;
import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTInterventoDatiOtiDao;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoFase;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoFontefin;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoLuogo;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoReferente;
import it.csi.moti.motibe.ejb.entity.MotiRInterventoSituazioneCriticita;
import it.csi.moti.motibe.ejb.entity.MotiTIntervento;
import it.csi.moti.motibe.ejb.entity.MotiTInterventoCosti;
import it.csi.moti.motibe.ejb.entity.MotiTInterventoDatiOti;
import it.csi.moti.motibe.ejb.exception.DeletedException;
import it.csi.moti.motibe.ejb.exception.NotFoundException;
import it.csi.moti.motibe.ejb.mapper.MotiMappers;
import it.csi.moti.motibe.ejb.util.jpa.Page;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.pagination.Sort;

/**
 * Data Access Delegate for intervento
 */
@ApplicationScoped
public class InterventoDad extends BaseDad {

	@Inject
	private MotiTInterventoDao motiTInterventoDao;

	@Inject
	private MotiTInterventoCostiDao motiTInterventoCostiDao;
	@Inject
	private MotiTInterventoDatiOtiDao motiTInterventoDatiOtiDao;

	@Inject
	private MotiRInterventoFaseDao motiRInterventoFaseDao;
	@Inject
	private MotiRInterventoFontefinDao motiRInterventoFontefinDao;
	@Inject
	private MotiRInterventoLuogoDao motiRInterventoLuogoDao;
	@Inject
	private MotiRInterventoReferenteDao motiRInterventoReferenteDao;
	@Inject
	private MotiRInterventoSituazioneCriticitaDao motiRInterventoSituazioneCriticitaDao;

	/**
	 * Find by id
	 * 
	 * @param uuid the uuid
	 * @return the model instance
	 */
	public Intervento getIntervento(Integer id) {
		Optional<Intervento> optional = motiTInterventoDao.findOne(id).map(MotiMappers.INTERVENTO::toModel);
		if (!optional.isPresent()) {
			optional = motiTInterventoDao.findById(id).map(MotiMappers.INTERVENTO::toModel);
			if (!optional.isPresent()) {
				throw new NotFoundException("Intervento");
			} else {
				throw new DeletedException("Intervento");
			}
		}
		return optional.get();
//		return motiTInterventoDao.findOne(id).map(MotiMappers.INTERVENTO::toModel)
//				.orElseThrow(() -> new NotFoundException("Intervento"));
	}

	/**
	 * 
	 * @param codIntervento
	 * @return
	 */
	public Intervento getInterventoByCodIntervento(String codIntervento) {
		Optional<MotiTIntervento> optional = motiTInterventoDao.getInterventoByCodIntervento(codIntervento);
		Intervento intervento = optional.map(MotiMappers.INTERVENTO::toModel)
				.orElseThrow(() -> new NotFoundException("Intervento"));
		return intervento;
	}

	/**
	 * Returns the Intervento
	 * 
	 * @return the Intervento
	 */
	public List<Intervento> getInterventos() {
		List<MotiTIntervento> list = motiTInterventoDao.findAll();
		return MotiMappers.INTERVENTO.toModels(list);
	}

	public void deleteIntervento(Integer idIntervento) {
		motiTInterventoDao.deleteLogically(idIntervento);

//		if (motiTIntervento.getMotiTInterventoCostis() != null) {
//			for (MotiTInterventoCosti motiTInterventoCosti : motiTIntervento.getMotiTInterventoCostis()) {
//				motiTInterventoCosti.setMotiTIntervento(motiTIntervento);
//				motiTInterventoCosti.setDataCancellazione(new Date());
//				motiTInterventoCosti = motiTInterventoCostiDao.update(motiTInterventoCosti);
//			}
//		}
	}

	/**
	 * Inserts the intervento
	 * 
	 * @param intervento the intervento
	 * @return the model instance
	 */
	public Intervento insertIntervento(Intervento intervento) {
		intervento.setDataInserimento(new Date());

		MotiTIntervento motiTIntervento = MotiMappers.INTERVENTO.toEntity(intervento);
		motiTIntervento = motiTInterventoDao.insert(motiTIntervento);

		insertRelatedObjs(motiTIntervento);

		intervento.setId(motiTIntervento.getId());
		return intervento;
	}

	/**
	 * Updates the intervento
	 * 
	 * @param intervento the intervento
	 * @return the model instance
	 */
	public Intervento updateIntervento(Intervento intervento) {
		MotiTIntervento motiTIntervento = MotiMappers.INTERVENTO.toEntity(intervento);
		// nell'oggetto restituito da update le relazione non sono valorizzate
		// correttamente
		motiTInterventoDao.update(motiTIntervento);

		deleteRelatedObjs(intervento);
		insertRelatedObjs(motiTIntervento);

		return intervento;
	}

	private void deleteRelatedObjs(Intervento intervento) {
		// delete related objs
		// Costi
		motiTInterventoCostiDao.deleteByIdIntervento(intervento.getId());

		// DatiOti
		// motiTInterventoDatiOtiDao.deleteByIdIntervento(intervento.getId());

		// Fases
		motiRInterventoFaseDao.deleteByIdIntervento(intervento.getId());

		// Fontefins
		motiRInterventoFontefinDao.deleteByIdIntervento(intervento.getId());

		// Luogo
		motiRInterventoLuogoDao.deleteByIdIntervento(intervento.getId());

		// Referentes
		motiRInterventoReferenteDao.deleteByIdIntervento(intervento.getId());

		// SituazioneCriticitas
		motiRInterventoSituazioneCriticitaDao.deleteByIdIntervento(intervento.getId());
	}

	private void insertRelatedObjs(MotiTIntervento motiTIntervento) {
		// Costi
		if (motiTIntervento.getMotiTInterventoCostis() != null) {
			for (MotiTInterventoCosti motiTInterventoCosti : motiTIntervento.getMotiTInterventoCostis()) {
				motiTInterventoCosti.setMotiTIntervento(motiTIntervento);
				motiTInterventoCosti = motiTInterventoCostiDao.insert(motiTInterventoCosti);
			}
		}

		// DatiOti
		if (motiTIntervento.getMotiTInterventoDatiOtis() != null) {
			for (MotiTInterventoDatiOti motiTInterventoDatiOti : motiTIntervento.getMotiTInterventoDatiOtis()) {
				motiTInterventoDatiOti.setMotiTIntervento(motiTIntervento);
				motiTInterventoDatiOti = motiTInterventoDatiOtiDao.insert(motiTInterventoDatiOti);
			}
		}

		// Fases
		if (motiTIntervento.getMotiRInterventoFases() != null) {
			for (MotiRInterventoFase motiRInterventoFase : motiTIntervento.getMotiRInterventoFases()) {
				motiRInterventoFase.setMotiTIntervento(motiTIntervento);
				motiRInterventoFase = motiRInterventoFaseDao.insert(motiRInterventoFase);
			}
		}

		// Fontefins
		if (motiTIntervento.getMotiRInterventoFontefins() != null) {
			for (MotiRInterventoFontefin motiRInterventoFontefin : motiTIntervento.getMotiRInterventoFontefins()) {
				motiRInterventoFontefin.setMotiTIntervento(motiTIntervento);
				motiRInterventoFontefin = motiRInterventoFontefinDao.insert(motiRInterventoFontefin);
			}
		}

		// Luogo
		if (motiTIntervento.getMotiRInterventoLuogos() != null) {
			for (MotiRInterventoLuogo motiRInterventoLuogo : motiTIntervento.getMotiRInterventoLuogos()) {
				motiRInterventoLuogo.setMotiTIntervento(motiTIntervento);
				motiRInterventoLuogo = motiRInterventoLuogoDao.insert(motiRInterventoLuogo);
			}
		}

		// Referentes
		if (motiTIntervento.getMotiRInterventoReferentes() != null) {
			for (MotiRInterventoReferente motiRInterventoReferente : motiTIntervento.getMotiRInterventoReferentes()) {
				motiRInterventoReferente.setMotiTIntervento(motiTIntervento);
				motiRInterventoReferente = motiRInterventoReferenteDao.insert(motiRInterventoReferente);
			}
		}

		// SituazioneCriticitas
		if (motiTIntervento.getMotiRInterventoSituazioneCriticitas() != null) {
			for (MotiRInterventoSituazioneCriticita motiRInterventoSituazioneCriticita : motiTIntervento
					.getMotiRInterventoSituazioneCriticitas()) {
				motiRInterventoSituazioneCriticita.setMotiTIntervento(motiTIntervento);
				motiRInterventoSituazioneCriticita = motiRInterventoSituazioneCriticitaDao
						.insert(motiRInterventoSituazioneCriticita);
			}
		}
	}

	public long countRicerca(FonteDati fonteDati, String codIntervento, String titolo, Tipologia tipologia, List<Utente> referentes,
			List<Luogo> luogos) {
		long count = motiTInterventoDao.countRicerca(fonteDati, codIntervento, titolo, tipologia, referentes, luogos);
		return count;
	}

	public PagedList<Intervento> getRicerca(int page, int size, Sort sort, FonteDati fonteDati, String codIntervento,
			String titolo, Tipologia tipologia, List<Utente> referentes, List<Luogo> luogos) {

		String sortField = null;
		String sortDirection = null;
		if (sort != null) {
			if (InterventoSort.byModelName(sort.getField()) != null) {
				sortField = InterventoSort.byModelName(sort.getField()).getQueryName();
			}
			sortDirection = sort.getOrder().getSortDirection();
		}

		Page<MotiTIntervento> motiTInterventos = motiTInterventoDao.findPaginated(page, size, sortField, sortDirection,
				fonteDati, codIntervento, titolo, tipologia, referentes, luogos);

		PagedList<Intervento> pagedList = toPagedList(motiTInterventos, page, size, MotiMappers.INTERVENTO::toModel);
		return pagedList;
	}

}
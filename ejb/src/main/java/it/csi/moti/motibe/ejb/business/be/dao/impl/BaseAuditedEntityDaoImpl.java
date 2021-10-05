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
package it.csi.moti.motibe.ejb.business.be.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.TypedQuery;

import it.csi.moti.motibe.ejb.business.be.dao.BaseAuditedEntityDao;
import it.csi.moti.motibe.ejb.entity.MotiTUtente;
import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.OptlockEntity;
import it.csi.moti.motibe.ejb.exception.BusinessException;
import it.csi.moti.motibe.ejb.mapper.MotiMappers;
import it.csi.moti.motibe.ejb.util.MotiEnum;
import it.csi.moti.motibe.ejb.util.MotiThreadLocalContainer;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * Base Data Access Object (DAO) implementor
 * 
 * @param <K> the key type
 * @param <T> the entity type
 */
public abstract class BaseAuditedEntityDaoImpl<K, T extends BaseAuditedEntity<K>> extends BaseEntityDaoImpl<K, T>
		implements BaseAuditedEntityDao<K, T> {

	/**
	 * Restituisce l'oggetto se valido
	 */
	@Override
	public Optional<T> findOne(K key) {
		return super.findOne(key).filter(el -> el.getDataCancellazione() == null);
	}

	/**
	 * Restituisce l'oggetto per id
	 */
	public Optional<T> findById(K key) {
		return super.findOne(key);
	}

	@Override
	public void deleteLogically(K key) {
		Date now = new Date();
		MotiTUtente motiTUtente = getUtente();

		StringBuilder sb = new StringBuilder();
		sb.append("FROM ");
		sb.append(clazz.getName());
		sb.append(" WHERE ").append(idField.getName()).append(" = :id");

		Map<String, Object> params = new HashMap<>();
		params.put("id", key);

		TypedQuery<T> typedQuery = composeTypedQuery(sb, params);
		typedQuery.getResultList().stream().forEach(entity -> {
			entity.setMotiTUtenteUltimaModifica(motiTUtente);
			entity.setDataCancellazione(now);
			entity.setDataUltimaModifica(now);
		});
	}

	@Override
	public T insert(T entity) {
		Date now = new Date();
		MotiTUtente motiTUtente = getUtente();

		if (entity instanceof OptlockEntity) {
			OptlockEntity optlockEntity = (OptlockEntity) entity;
			optlockEntity.setOptlock(UUID.randomUUID());
		}

		entity.setDataInserimento(now);
		entity.setDataUltimaModifica(now);
		entity.setMotiTUtenteInserimento(motiTUtente);
		entity.setMotiTUtenteUltimaModifica(motiTUtente);
		return super.insert(entity);
	}

	@Override
	public T update(T entity) {
		Date now = new Date();
		MotiTUtente motiTUtente = getUtente();
		// entity non trovato
		T current = findOne(entity.getId()).orElseThrow(() -> new RuntimeException("Richiesta vecchia riprovare"));

		if (entity instanceof OptlockEntity) {
			OptlockEntity optlockEntity = (OptlockEntity) entity;
			OptlockEntity optlockCurrent = (OptlockEntity) current;

			if (!optlockCurrent.getOptlock().equals(optlockEntity.getOptlock())) {
				throw new BusinessException("Dati vecchi");
			}
			if (optlockEntity.getOptlock() == null) {
				throw new BusinessException("optLock non passato in richiesta dal chiamante");
			}
			optlockEntity.setOptlock(UUID.randomUUID());
		}

		entity.setMotiTUtenteInserimento(current.getMotiTUtenteInserimento());
		entity.setDataInserimento(current.getDataInserimento());
		entity.setMotiTUtenteUltimaModifica(motiTUtente);
		entity.setDataUltimaModifica(now);
		return super.update(entity);
	}

	private MotiTUtente getUtente() {
		MotiTUtente motiTUtente = null;
		if (MotiThreadLocalContainer.UTENTE_CONNESSO.get() != null) {
			Utente utente = MotiThreadLocalContainer.UTENTE_CONNESSO.get();
			motiTUtente = MotiMappers.UTENTE.toEntity(utente);
		}
		return motiTUtente;
	}

}

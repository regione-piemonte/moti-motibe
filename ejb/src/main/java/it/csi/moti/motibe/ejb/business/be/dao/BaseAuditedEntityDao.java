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
package it.csi.moti.motibe.ejb.business.be.dao;

import java.util.Optional;

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;

/**
 * Base Data Access Object (DAO) interface
 * @param <K> the id type
 * @param <T> the entity type
 */
public interface BaseAuditedEntityDao<K, T extends BaseAuditedEntity<K>> extends BaseEntityDao<K, T> {

	/**
	 * Logically deletes the entity
	 * @param key the key of the entity
	 */
	void deleteLogically(K key);
	
	
	/**
	 * Finds an entity by its key
	 * @param key the key
	 * @return the entity
	 */
	Optional<T> findById(K key);
}

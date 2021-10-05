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

/**
 * Base Data Access Object (DAO) interface
 * @param <T> the type
 */
public interface BaseDao<T> {

	/**
	 * Flushes the entity manager
	 */
	void flush();
	/**
	 * Clears the entity manager
	 */
	void clear();
	/**
	 * Flushes and clears the entity manager
	 */
	void flushAndClear();
}

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
package it.csi.moti.motibe.ejb.entity.base;

/**
 * Marker interface for a model
 * @param <K> the key type
 */
public interface BaseEntity<K> {

	/**
	 * @return the id
	 */
	K getId();
	/**
	 * @param id the id to set
	 */
	void setId(K id);
	/**
	 * Initializes the id with the instance fields, if applicable
	 */
	default void initId() {
		// May be overridden
	}
}

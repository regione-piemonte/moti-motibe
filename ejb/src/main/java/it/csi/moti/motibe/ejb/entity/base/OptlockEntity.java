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

import java.util.UUID;

/**
 * Marker interface for an entity with Optlock
 */
public interface OptlockEntity {

	/**
	 * @return the id
	 */
	UUID getOptlock();
	/**
	 * @param id the id to set
	 */
	void setOptlock(UUID id);
	/**
	 * Generates a new Optlock
	 */
	void generateNewOptlock();
}

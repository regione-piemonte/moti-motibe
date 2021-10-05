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
package it.csi.moti.motibe.ejb.business.be.dad.sort;

/**
 * Base interface for a JPA sort
 */
public interface JpaSort {

	/**
	 * @return the query name
	 */
	String getQueryName();
	/**
	 * @return the model name
	 */
	String getModelName();
}

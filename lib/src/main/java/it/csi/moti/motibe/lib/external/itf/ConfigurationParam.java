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
package it.csi.moti.motibe.lib.external.itf;

//import it.csi.moti.motibe.lib.dto.Parametro;

/**
 * Configuration parameter
 */
public interface ConfigurationParam {

	/**
	 * @return the param name
	 */
	String getParamName();
	
	/**
	 * Checks whether the given argument equals the configuration
	 * @param parametro the parametro to check
	 * @return whether the argument represents the configuration
	 */
//	default boolean isParametroEqual(Parametro parametro) {
//		return this.getParamName().equals(parametro.getChiave());
//	}
}

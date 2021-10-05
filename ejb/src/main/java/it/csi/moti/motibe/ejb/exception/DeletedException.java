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
package it.csi.moti.motibe.ejb.exception;

import javax.ejb.ApplicationException;

/**
 * Exception signaling a deleted entity
 */
@ApplicationException(rollback = true)
public class DeletedException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3669781997904869102L;

	/**
	 * @see RuntimeException#RuntimeException(String)
	 */
	public DeletedException(String message) {
		super(message);
	}

	/**
	 * @see RuntimeException#RuntimeException(String, Throwable)
	 */
	public DeletedException(String message, Throwable cause) {
		super(message, cause);
	}

}

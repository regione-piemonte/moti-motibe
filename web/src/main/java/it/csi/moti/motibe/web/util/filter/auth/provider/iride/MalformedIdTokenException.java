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
package it.csi.moti.motibe.web.util.filter.auth.provider.iride;

/**
 * Exception thrown whenever a malformed Shibboleth ID token is found
 */
public class MalformedIdTokenException extends Exception {

	/** For serialiazation */
	private static final long serialVersionUID = 2515682659224222111L;

	/**
	 * Constructor
	 * @see Exception#Exception()
	 */
	public MalformedIdTokenException() {
		// Nothing to add
	}

	/**
	 * Constructor
	 * @param message the message
	 * @param cause the cause
	 * @see Exception#Exception(String, Throwable)
	 */
	public MalformedIdTokenException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor
	 * @param message the message
	 * @see Exception#Exception(String)
	 */
	public MalformedIdTokenException(String message) {
		super(message);
	}

	/**
	 * Constructor
	 * @param cause the cause
	 * @see Exception#Exception(Throwable)
	 */
	public MalformedIdTokenException(Throwable cause) {
		super(cause);
	}

}

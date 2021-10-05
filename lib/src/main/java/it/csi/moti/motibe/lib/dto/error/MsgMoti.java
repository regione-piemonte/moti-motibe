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
package it.csi.moti.motibe.lib.dto.error;

/**
 * MOTI error types
 */
public enum MsgMoti implements ErrorCreator {

	// modulo-oggetto
	INTINTE0000 ("INT-INT-E-0000", "Esiste già un intervento con questo codice."),
	INTINTP0001 ("INT-INT-P-0001", "Intervento inserito con successo!"),
	INTINTP0002 ("INT-INT-P-0002", "Intervento aggiornato con successo!"),
	INTINTP0003 ("INT-INT-P-0003", "Intervento eliminato con successo!"),
	INTINTA0004 ("INT-INT-A-0004", "Si desidera eliminare l'intervento?"),
	INTINTE0005 ("INT-INT-E-0005", "Non sono presenti risultati per i criteri di ricerca impostati")	
	;

	private final String code;
	private final String type;
	private final String group;
	private final String message;

	/**
	 * Private constructor
	 * @param code the code
	 * @param message the message
	 */
	private MsgMoti(String code, String message) {
		this(code, null, message);
	}

	/**
	 * Private constructor
	 * @param code the code
	 * @param group the group
	 * @param message the message
	 */
	private MsgMoti(String code, String group, String message) {
		this.code = code;
		this.type = "ERROR";
		this.group = group;
		this.message = message;
	}
	
	private MsgMoti(String code, String type, String group, String message) {
		this.code = code;
		this.type = type;
		this.group = group;
		this.message = message;
	}

	@Override
	public String getCode() {
		return code;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getGroup() {
		return group;
	}

	@Override
	public String getMessage() {
		return message;
	}

}

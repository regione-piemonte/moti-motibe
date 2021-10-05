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
package it.csi.moti.motibe.ejb.util;

/**
 * Enum for Moti
 */
public enum MotiEnum {
	/** Programma */
	PROGRAMMA("PROGRAMMA"),
	/** Start */
	START("START"),
	/** End */
	END("END"),
	/** OK */
	OK("OK"),
	/** Ko */
	KO("KO"),
	/** Errro */
	ERROR("ERROR"),
	/** Caricamento da fonte esterna */
	// CARICAMENTO_FONTE_ESTERNA("CARICAMENTO_FONTE_ESTERNA"),
	/** Errore caricamento programma csv */
	ERRORE_CARICAMENTO_PROGRAMMA_CSV("ERRORE_CARICAMENTO_PROGRAMMA_CSV"),
	/** Intervento */
	INTERVENTO("INTERVENTO"),
	/** Importi traslati */
	IMPORTI_TRASLATI("IMPORTI_TRASLATI"),
	COPIA_MANTENENDO_CUI("COPIA_MANTENENDO_CUI"), 
	INTERVENTO_CUI("INTERVENTO.CUI"), 
	ORDINE_TESTATA("ORDINE.TESTATA"), 
	EVASIONE_TESTATA("EVASIONE.TESTATA"), 
	ACQ_NON_RIPROPOSTO("ACQ_NON_RIPROPOSTO"),
	UTENTE_SISTEMA_CF("SSTTNT20A01L219Q")
	;
	
	
	private final String costante;
	
	private MotiEnum(String costante) {
		this.costante = costante;
	}
	
	private MotiEnum() {
		this.costante = this.name();
	}
	/**
	 * @return the costante
	 */
	public String getCostante() {
		return costante;
	}

}

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
package it.csi.moti.motibe.lib.dto.intervento;

import java.io.Serializable;

import it.csi.moti.motibe.lib.dto.BaseDto;
import it.csi.moti.motibe.lib.dto.Utente;

/**
 * The Class InterventoReferente.
 */
public class InterventoReferente extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Intervento intervento;
	private Utente utente;

	/**
	 * @return the intervento
	 */
	public Intervento getIntervento() {
		return intervento;
	}
	
	/**
	 * @param intervento the intervento to set
	 */
	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

	/**
	 * @return the utente
	 */
	public Utente getUtente() {
		return utente;
	}
	
	/**
	 * @param utente the utente to set
	 */
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}

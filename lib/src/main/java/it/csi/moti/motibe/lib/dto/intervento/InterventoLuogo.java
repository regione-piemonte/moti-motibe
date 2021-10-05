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

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;

/**
 * The Class InterventoLuogo.
 */
public class InterventoLuogo extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Luogo luogo;
	private Intervento intervento;

	/**
	 * @return the luogo
	 */
	public Luogo getLuogo() {
		return luogo;
	}
	
	/**
	 * @param luogo the luogo to set
	 */
	public void setLuogo(Luogo luogo) {
		this.luogo = luogo;
	}

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

}

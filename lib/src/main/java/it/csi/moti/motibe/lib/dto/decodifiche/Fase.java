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
package it.csi.moti.motibe.lib.dto.decodifiche;

import java.io.Serializable;
import java.math.BigDecimal;

import it.csi.moti.motibe.lib.dto.BaseDto;

/**
 * The Class Fase.
 */
public class Fase extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private FonteDati fonteDati;
	private BigDecimal ordine;
	private String tipologia;

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the fonteDati
	 */
	public FonteDati getFonteDati() {
		return fonteDati;
	}

	/**
	 * @param fonteDati the fonteDati to set
	 */
	public void setFonteDati(FonteDati fonteDati) {
		this.fonteDati = fonteDati;
	}

	/**
	 * @return the ordine
	 */
	public BigDecimal getOrdine() {
		return ordine;
	}

	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	/**
	 * @return the tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}

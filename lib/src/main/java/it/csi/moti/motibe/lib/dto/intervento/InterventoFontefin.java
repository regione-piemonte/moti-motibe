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
import java.math.BigDecimal;

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteFinanziamento;

/**
 * The Class InterventoFontefin.
 */
public class InterventoFontefin extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private BigDecimal importoStanziato;
	private BigDecimal importoLiquidato;
	private FonteFinanziamento fonteFinanziamento;
	private Intervento intervento;
	private FonteDati fonteDati;
	private String note;

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
	 * @return the importoStanziato
	 */
	public BigDecimal getImportoStanziato() {
		return importoStanziato;
	}

	/**
	 * @param importoStanziato the importoStanziato to set
	 */
	public void setImportoStanziato(BigDecimal importoStanziato) {
		this.importoStanziato = importoStanziato;
	}

	/**
	 * @return the importoLiquidato
	 */
	public BigDecimal getImportoLiquidato() {
		return importoLiquidato;
	}

	/**
	 * @param importoLiquidato the importoLiquidato to set
	 */
	public void setImportoLiquidato(BigDecimal importoLiquidato) {
		this.importoLiquidato = importoLiquidato;
	}

	/**
	 * @return the fonteFinanziamento
	 */
	public FonteFinanziamento getFonteFinanziamento() {
		return fonteFinanziamento;
	}

	/**
	 * @param fonteFinanziamento the fonteFinanziamento to set
	 */
	public void setFonteFinanziamento(FonteFinanziamento fonteFinanziamento) {
		this.fonteFinanziamento = fonteFinanziamento;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

}

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
import java.util.Date;
import java.util.UUID;

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;

/**
 * The Class InterventoCosti.
 */
public class InterventoCosti extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private BigDecimal costoPrevisto;
	private Date dataUltimaLiquidazione;
	private String fonteDati;
	private String fonteRiferimento;
	private String note;
	private String noteEconomiche;
	private Intervento intervento;
	private UUID optlock;

	/**
	 * @return the costoPrevisto
	 */
	public BigDecimal getCostoPrevisto() {
		return costoPrevisto;
	}

	/**
	 * @param costoPrevisto the costoPrevisto to set
	 */
	public void setCostoPrevisto(BigDecimal costoPrevisto) {
		this.costoPrevisto = costoPrevisto;
	}

	/**
	 * @return the dataUltimaLiquidazione
	 */
	public Date getDataUltimaLiquidazione() {
		return dataUltimaLiquidazione;
	}

	/**
	 * @param dataUltimaLiquidazione the dataUltimaLiquidazione to set
	 */
	public void setDataUltimaLiquidazione(Date dataUltimaLiquidazione) {
		this.dataUltimaLiquidazione = dataUltimaLiquidazione;
	}

	/**
	 * @return the fonteDati
	 */
	public String getFonteDati() {
		return fonteDati;
	}

	/**
	 * @param fonteDati the fonteDati to set
	 */
	public void setFonteDati(String fonteDati) {
		this.fonteDati = fonteDati;
	}

	/**
	 * @return the fonteRiferimento
	 */
	public String getFonteRiferimento() {
		return fonteRiferimento;
	}

	/**
	 * @param fonteRiferimento the fonteRiferimento to set
	 */
	public void setFonteRiferimento(String fonteRiferimento) {
		this.fonteRiferimento = fonteRiferimento;
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

	/**
	 * @return the noteEconomiche
	 */
	public String getNoteEconomiche() {
		return noteEconomiche;
	}

	/**
	 * @param noteEconomiche the noteEconomiche to set
	 */
	public void setNoteEconomiche(String noteEconomiche) {
		this.noteEconomiche = noteEconomiche;
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
	 * @return the optlock
	 */
	public UUID getOptlock() {
		return optlock;
	}

	/**
	 * @param optlock the optlock to set
	 */
	public void setOptlock(UUID optlock) {
		this.optlock = optlock;
	}

}

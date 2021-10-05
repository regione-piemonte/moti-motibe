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

import it.csi.moti.motibe.lib.dto.BaseDto;

/**
 * The Class InterventoDatiOti.
 */
public class InterventoDatiOti extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private BigDecimal annoInizioLavori;
	private BigDecimal annoProssimaFase;
	private BigDecimal annoUltimazioneOpera;
	private Date dataUltimoAggiornamento;
	private String descrizioneProgettazione;
	private String dettagliProssimaFase;
	private String dettaglioCosti;
	private BigDecimal finanziamentiDisponibili;
	private BigDecimal finanziamentiNonDisponibili;
	private String rispettoTempi;
	private String soggettiCoinvolti;
	private String urlDaRichiamare;
	private Intervento intervento;

	/**
	 * @return the annoInizioLavori
	 */
	public BigDecimal getAnnoInizioLavori() {
		return annoInizioLavori;
	}
	
	/**
	 * @param annoInizioLavori the annoInizioLavori to set
	 */
	public void setAnnoInizioLavori(BigDecimal annoInizioLavori) {
		this.annoInizioLavori = annoInizioLavori;
	}

	/**
	 * @return the annoProssimaFase
	 */
	public BigDecimal getAnnoProssimaFase() {
		return annoProssimaFase;
	}
	
	/**
	 * @param annoProssimaFase the annoProssimaFase to set
	 */
	public void setAnnoProssimaFase(BigDecimal annoProssimaFase) {
		this.annoProssimaFase = annoProssimaFase;
	}

	/**
	 * @return the annoUltimazioneOpera
	 */
	public BigDecimal getAnnoUltimazioneOpera() {
		return annoUltimazioneOpera;
	}
	
	/**
	 * @param annoUltimazioneOpera the annoUltimazioneOpera to set
	 */
	public void setAnnoUltimazioneOpera(BigDecimal annoUltimazioneOpera) {
		this.annoUltimazioneOpera = annoUltimazioneOpera;
	}

	/**
	 * @return the dataUltimoAggiornamento
	 */
	public Date getDataUltimoAggiornamento() {
		return dataUltimoAggiornamento;
	}
	
	/**
	 * @param dataUltimoAggiornamento the dataUltimoAggiornamento to set
	 */
	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	/**
	 * @return the descrizioneProgettazione
	 */
	public String getDescrizioneProgettazione() {
		return descrizioneProgettazione;
	}
	
	/**
	 * @param descrizioneProgettazione the descrizioneProgettazione to set
	 */
	public void setDescrizioneProgettazione(String descrizioneProgettazione) {
		this.descrizioneProgettazione = descrizioneProgettazione;
	}

	/**
	 * @return the dettagliProssimaFase
	 */
	public String getDettagliProssimaFase() {
		return dettagliProssimaFase;
	}
	
	/**
	 * @param dettagliProssimaFase the dettagliProssimaFase to set
	 */
	public void setDettagliProssimaFase(String dettagliProssimaFase) {
		this.dettagliProssimaFase = dettagliProssimaFase;
	}

	/**
	 * @return the dettaglioCosti
	 */
	public String getDettaglioCosti() {
		return dettaglioCosti;
	}
	
	/**
	 * @param dettaglioCosti the dettaglioCosti to set
	 */
	public void setDettaglioCosti(String dettaglioCosti) {
		this.dettaglioCosti = dettaglioCosti;
	}

	/**
	 * @return the finanziamentiDisponibili
	 */
	public BigDecimal getFinanziamentiDisponibili() {
		return finanziamentiDisponibili;
	}
	
	/**
	 * @param finanziamentiDisponibili the finanziamentiDisponibili to set
	 */
	public void setFinanziamentiDisponibili(BigDecimal finanziamentiDisponibili) {
		this.finanziamentiDisponibili = finanziamentiDisponibili;
	}

	/**
	 * @return the finanziamentiNonDisponibili
	 */
	public BigDecimal getFinanziamentiNonDisponibili() {
		return finanziamentiNonDisponibili;
	}
	
	/**
	 * @param finanziamentiNonDisponibili the finanziamentiNonDisponibili to set
	 */
	public void setFinanziamentiNonDisponibili(BigDecimal finanziamentiNonDisponibili) {
		this.finanziamentiNonDisponibili = finanziamentiNonDisponibili;
	}

	/**
	 * @return the rispettoTempi
	 */
	public String getRispettoTempi() {
		return rispettoTempi;
	}
	
	/**
	 * @param rispettoTempi the rispettoTempi to set
	 */
	public void setRispettoTempi(String rispettoTempi) {
		this.rispettoTempi = rispettoTempi;
	}

	/**
	 * @return the soggettiCoinvolti
	 */
	public String getSoggettiCoinvolti() {
		return soggettiCoinvolti;
	}
	
	/**
	 * @param soggettiCoinvolti the soggettiCoinvolti to set
	 */
	public void setSoggettiCoinvolti(String soggettiCoinvolti) {
		this.soggettiCoinvolti = soggettiCoinvolti;
	}

	/**
	 * @return the urlDaRichiamare
	 */
	public String getUrlDaRichiamare() {
		return urlDaRichiamare;
	}
	
	/**
	 * @param urlDaRichiamare the urlDaRichiamare to set
	 */
	public void setUrlDaRichiamare(String urlDaRichiamare) {
		this.urlDaRichiamare = urlDaRichiamare;
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

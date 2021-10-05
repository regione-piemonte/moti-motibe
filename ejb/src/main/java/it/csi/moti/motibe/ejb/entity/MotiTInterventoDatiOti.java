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
package it.csi.moti.motibe.ejb.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;


/**
 * The persistent class for the moti_t_intervento_dati_oti database table.
 * 
 */
@Entity
@Table(name="moti_t_intervento_dati_oti")
@NamedQuery(name="MotiTInterventoDatiOti.findAll", query="SELECT o FROM MotiTInterventoDatiOti o")
public class MotiTInterventoDatiOti implements Serializable, BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getId() {
		return idDatiOti;
	}

	@Override
	public void setId(Integer id) {
		idDatiOti = id;
	}
	
	@Id
	@Column(name="id_dati_oti")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDatiOti;

	@Column(name="anno_inizio_lavori")
	private BigDecimal annoInizioLavori;

	@Column(name="anno_prossima_fase")
	private BigDecimal annoProssimaFase;

	@Column(name="anno_ultimazione_opera")
	private BigDecimal annoUltimazioneOpera;

	@Temporal(TemporalType.DATE)
	@Column(name="data_ultimo_aggiornamento")
	private Date dataUltimoAggiornamento;

	@Column(name="descrizione_progettazione")
	private String descrizioneProgettazione;

	@Column(name="dettagli_prossima_fase")
	private String dettagliProssimaFase;

	@Column(name="dettaglio_costi")
	private String dettaglioCosti;

	@Column(name="finanziamenti_disponibili")
	private BigDecimal finanziamentiDisponibili;

	@Column(name="finanziamenti_non_disponibili")
	private BigDecimal finanziamentiNonDisponibili;

	@Column(name="rispetto_tempi")
	private String rispettoTempi;

	@Column(name="soggetti_coinvolti")
	private String soggettiCoinvolti;

	@Column(name="url_da_richiamare")
	private String urlDaRichiamare;

	//bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name="fk_intervento")
	private MotiTIntervento motiTIntervento;

	public MotiTInterventoDatiOti() {
	}

	public Integer getIdDatiOti() {
		return this.idDatiOti;
	}

	public void setIdDatiOti(Integer idDatiOti) {
		this.idDatiOti = idDatiOti;
	}

	public BigDecimal getAnnoInizioLavori() {
		return this.annoInizioLavori;
	}

	public void setAnnoInizioLavori(BigDecimal annoInizioLavori) {
		this.annoInizioLavori = annoInizioLavori;
	}

	public BigDecimal getAnnoProssimaFase() {
		return this.annoProssimaFase;
	}

	public void setAnnoProssimaFase(BigDecimal annoProssimaFase) {
		this.annoProssimaFase = annoProssimaFase;
	}

	public BigDecimal getAnnoUltimazioneOpera() {
		return this.annoUltimazioneOpera;
	}

	public void setAnnoUltimazioneOpera(BigDecimal annoUltimazioneOpera) {
		this.annoUltimazioneOpera = annoUltimazioneOpera;
	}

	public Date getDataUltimoAggiornamento() {
		return this.dataUltimoAggiornamento;
	}

	public void setDataUltimoAggiornamento(Date dataUltimoAggiornamento) {
		this.dataUltimoAggiornamento = dataUltimoAggiornamento;
	}

	public String getDescrizioneProgettazione() {
		return this.descrizioneProgettazione;
	}

	public void setDescrizioneProgettazione(String descrizioneProgettazione) {
		this.descrizioneProgettazione = descrizioneProgettazione;
	}

	public String getDettagliProssimaFase() {
		return this.dettagliProssimaFase;
	}

	public void setDettagliProssimaFase(String dettagliProssimaFase) {
		this.dettagliProssimaFase = dettagliProssimaFase;
	}

	public String getDettaglioCosti() {
		return this.dettaglioCosti;
	}

	public void setDettaglioCosti(String dettaglioCosti) {
		this.dettaglioCosti = dettaglioCosti;
	}

	public BigDecimal getFinanziamentiDisponibili() {
		return this.finanziamentiDisponibili;
	}

	public void setFinanziamentiDisponibili(BigDecimal finanziamentiDisponibili) {
		this.finanziamentiDisponibili = finanziamentiDisponibili;
	}

	public BigDecimal getFinanziamentiNonDisponibili() {
		return this.finanziamentiNonDisponibili;
	}

	public void setFinanziamentiNonDisponibili(BigDecimal finanziamentiNonDisponibili) {
		this.finanziamentiNonDisponibili = finanziamentiNonDisponibili;
	}

	public String getRispettoTempi() {
		return this.rispettoTempi;
	}

	public void setRispettoTempi(String rispettoTempi) {
		this.rispettoTempi = rispettoTempi;
	}

	public String getSoggettiCoinvolti() {
		return this.soggettiCoinvolti;
	}

	public void setSoggettiCoinvolti(String soggettiCoinvolti) {
		this.soggettiCoinvolti = soggettiCoinvolti;
	}

	public String getUrlDaRichiamare() {
		return this.urlDaRichiamare;
	}

	public void setUrlDaRichiamare(String urlDaRichiamare) {
		this.urlDaRichiamare = urlDaRichiamare;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

}
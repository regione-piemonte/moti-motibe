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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_r_intervento_fontefin database table.
 * 
 */
@Entity
@Table(name = "moti_r_intervento_fontefin")
@NamedQuery(name = "MotiRInterventoFontefin.findAll", query = "SELECT o FROM MotiRInterventoFontefin o")
public class MotiRInterventoFontefin extends BaseAuditedEntity<Integer> implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idInterventoFontefin;
	}

	@Override
	public void setId(Integer id) {
		idInterventoFontefin = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_intervento_fontefin")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInterventoFontefin;

	private String descrizione;

	@Column(name = "importo_stanziato")
	private BigDecimal importoStanziato;
	
	@Column(name = "importo_liquidato")
	private BigDecimal importoLiquidato;
	
	@Column(name = "note")
	private String note;

	// bi-directional many-to-one association to MotiDFonteFinanziamento
	@ManyToOne
	@JoinColumn(name = "fk_tipo_fonte")
	private MotiDFonteFinanziamento motiDFonteFinanziamento;

	// bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name = "fk_intervento")
	private MotiTIntervento motiTIntervento;

	// bi-directional many-to-one association to MotiDFonteDati
	@ManyToOne
	@JoinColumn(name = "fk_fonte_dati")
	private MotiDFonteDati motiDFonteDati;

	public MotiRInterventoFontefin() {
	}

	public Integer getIdInterventoFontefin() {
		return this.idInterventoFontefin;
	}

	public void setIdInterventoFontefin(Integer idInterventoFontefin) {
		this.idInterventoFontefin = idInterventoFontefin;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigDecimal getImportoStanziato() {
		return importoStanziato;
	}

	public void setImportoStanziato(BigDecimal importoStanziato) {
		this.importoStanziato = importoStanziato;
	}

	public BigDecimal getImportoLiquidato() {
		return this.importoLiquidato;
	}

	public void setImportoLiquidato(BigDecimal importoLiquidato) {
		this.importoLiquidato = importoLiquidato;
	}

	public MotiDFonteFinanziamento getMotiDFonteFinanziamento() {
		return this.motiDFonteFinanziamento;
	}

	public void setMotiDFonteFinanziamento(MotiDFonteFinanziamento motiDFonteFinanziamento) {
		this.motiDFonteFinanziamento = motiDFonteFinanziamento;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

	public MotiDFonteDati getMotiDFonteDati() {
		return motiDFonteDati;
	}

	public void setMotiDFonteDati(MotiDFonteDati motiDFonteDati) {
		this.motiDFonteDati = motiDFonteDati;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
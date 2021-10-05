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
import java.util.UUID;

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

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.OptlockEntity;

/**
 * The persistent class for the moti_t_intervento_costi database table.
 * 
 */
@Entity
@Table(name = "moti_t_intervento_costi")
@NamedQuery(name = "MotiTInterventoCosti.findAll", query = "SELECT o FROM MotiTInterventoCosti o")
public class MotiTInterventoCosti extends BaseAuditedEntity<Integer> implements OptlockEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getId() {
		return idCostiIntervento;
	}

	@Override
	public void setId(Integer id) {
		idCostiIntervento = id;
	}

	@Id
	@Column(name = "id_costi_intervento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCostiIntervento;

	@Column(name = "costo_previsto")
	private BigDecimal costoPrevisto;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultima_liquidazione")
	private Date dataUltimaLiquidazione;

	@Column(name = "fonte_dati")
	private String fonteDati;

	@Column(name = "fonte_riferimento")
	private String fonteRiferimento;

	private String note;

	@Column(name = "note_economiche")
	private String noteEconomiche;

	@Column(nullable = false)
	private UUID optlock;

	// bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name = "fk_intervento")
	private MotiTIntervento motiTIntervento;

	public MotiTInterventoCosti() {
	}

	public Integer getIdCostiIntervento() {
		return this.idCostiIntervento;
	}

	public void setIdCostiIntervento(Integer idCostiIntervento) {
		this.idCostiIntervento = idCostiIntervento;
	}

	public BigDecimal getCostoPrevisto() {
		return this.costoPrevisto;
	}

	public void setCostoPrevisto(BigDecimal costoPrevisto) {
		this.costoPrevisto = costoPrevisto;
	}

	public Date getDataUltimaLiquidazione() {
		return this.dataUltimaLiquidazione;
	}

	public void setDataUltimaLiquidazione(Date dataUltimaLiquidazione) {
		this.dataUltimaLiquidazione = dataUltimaLiquidazione;
	}

	public String getFonteDati() {
		return this.fonteDati;
	}

	public void setFonteDati(String fonteDati) {
		this.fonteDati = fonteDati;
	}

	public String getFonteRiferimento() {
		return this.fonteRiferimento;
	}

	public void setFonteRiferimento(String fonteRiferimento) {
		this.fonteRiferimento = fonteRiferimento;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNoteEconomiche() {
		return this.noteEconomiche;
	}

	public void setNoteEconomiche(String noteEconomiche) {
		this.noteEconomiche = noteEconomiche;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

	@Override
	public UUID getOptlock() {
		return this.optlock;
	}

	@Override
	public void setOptlock(UUID id) {
		this.optlock = id;
	}

	@Override
	public void generateNewOptlock() {
		this.optlock = UUID.randomUUID();
	}

}
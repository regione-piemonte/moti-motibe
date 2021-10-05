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

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_r_intervento_situazione_criticita database
 * table.
 * 
 */
@Entity
@Table(name = "moti_r_intervento_situazione_criticita")
@NamedQuery(name = "MotiRInterventoSituazioneCriticita.findAll", query = "SELECT o FROM MotiRInterventoSituazioneCriticita o")
public class MotiRInterventoSituazioneCriticita extends BaseAuditedEntity<Integer>
		implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idCriticita;
	}

	@Override
	public void setId(Integer id) {
		idCriticita = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_criticita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCriticita;

	private String descrizione;

	// bi-directional many-to-one association to MotiDSituazioneCriticita
	@ManyToOne
	@JoinColumn(name = "fk_situazione_criticita")
	private MotiDSituazioneCriticita motiDSituazioneCriticita;

	// bi-directional many-to-one association to MotiDTipoCriticita
	@ManyToOne
	@JoinColumn(name = "fk_tipo_criticita")
	private MotiDTipoCriticita motiDTipoCriticita;

	// bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name = "fk_intervento")
	private MotiTIntervento motiTIntervento;

	// bi-directional many-to-one association to MotiDFonteDati
	@ManyToOne
	@JoinColumn(name = "fk_fonte_dati")
	private MotiDFonteDati motiDFonteDati;

	public MotiRInterventoSituazioneCriticita() {
	}

	public Integer getIdCriticita() {
		return this.idCriticita;
	}

	public void setIdCriticita(Integer idCriticita) {
		this.idCriticita = idCriticita;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public MotiDSituazioneCriticita getMotiDSituazioneCriticita() {
		return this.motiDSituazioneCriticita;
	}

	public void setMotiDSituazioneCriticita(MotiDSituazioneCriticita motiDSituazioneCriticita) {
		this.motiDSituazioneCriticita = motiDSituazioneCriticita;
	}

	public MotiDTipoCriticita getMotiDTipoCriticita() {
		return this.motiDTipoCriticita;
	}

	public void setMotiDTipoCriticita(MotiDTipoCriticita motiDTipoCriticita) {
		this.motiDTipoCriticita = motiDTipoCriticita;
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

}
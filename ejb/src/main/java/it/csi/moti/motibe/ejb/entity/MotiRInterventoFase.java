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
 * The persistent class for the moti_r_intervento_fase database table.
 * 
 */
@Entity
@Table(name = "moti_r_intervento_fase")
@NamedQuery(name = "MotiRInterventoFase.findAll", query = "SELECT o FROM MotiRInterventoFase o")
public class MotiRInterventoFase extends BaseAuditedEntity<Integer> implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idInterventoFase;
	}

	@Override
	public void setId(Integer id) {
		idInterventoFase = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_intervento_fase")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInterventoFase;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_effettiva")
	private Date dataEffettiva;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_prevista")
	private Date dataPrevista;

	// bi-directional many-to-one association to MotiDFase
	@ManyToOne
	@JoinColumn(name = "fk_fase")
	private MotiDFase motiDFase;

	// bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name = "fk_intervento")
	private MotiTIntervento motiTIntervento;

	public MotiRInterventoFase() {
	}

	public Integer getIdInterventoFase() {
		return this.idInterventoFase;
	}

	public void setIdInterventoFase(Integer idInterventoFase) {
		this.idInterventoFase = idInterventoFase;
	}

	public Date getDataEffettiva() {
		return this.dataEffettiva;
	}

	public void setDataEffettiva(Date dataEffettiva) {
		this.dataEffettiva = dataEffettiva;
	}

	public Date getDataPrevista() {
		return this.dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public MotiDFase getMotiDFase() {
		return this.motiDFase;
	}

	public void setMotiDFase(MotiDFase motiDFase) {
		this.motiDFase = motiDFase;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

}
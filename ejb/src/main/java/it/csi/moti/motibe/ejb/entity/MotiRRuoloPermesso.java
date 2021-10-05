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
import javax.persistence.*;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

import java.util.Date;


/**
 * The persistent class for the moti_r_ruolo_permesso database table.
 * 
 */
@Entity
@Table(name="moti_r_ruolo_permesso")
@NamedQuery(name="MotiRRuoloPermesso.findAll", query="SELECT m FROM MotiRRuoloPermesso m")
public class MotiRRuoloPermesso implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idRuoloPermesso;
	}

	@Override
	public void setId(Integer id) {
		idRuoloPermesso = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruolo_permesso")
	private Integer idRuoloPermesso;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fine_validita")
	private Date dtFineValidita;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inizio_validita")
	private Date dtInizioValidita;

	@Column(name="fk_id_ruolo")
	private Integer fkIdRuolo;

	//bi-directional many-to-one association to MotiDPermesso
	@ManyToOne
	@JoinColumn(name="fk_id_permesso")
	private MotiDPermesso motiDPermesso;

	public MotiRRuoloPermesso() {
	}

	public Integer getIdRuoloPermesso() {
		return this.idRuoloPermesso;
	}

	public void setIdRuoloPermesso(Integer idRuoloPermesso) {
		this.idRuoloPermesso = idRuoloPermesso;
	}

	public Date getDtFineValidita() {
		return this.dtFineValidita;
	}

	public void setDtFineValidita(Date dtFineValidita) {
		this.dtFineValidita = dtFineValidita;
	}

	public Date getDtInizioValidita() {
		return this.dtInizioValidita;
	}

	public void setDtInizioValidita(Date dtInizioValidita) {
		this.dtInizioValidita = dtInizioValidita;
	}

	public Integer getFkIdRuolo() {
		return this.fkIdRuolo;
	}

	public void setFkIdRuolo(Integer fkIdRuolo) {
		this.fkIdRuolo = fkIdRuolo;
	}

	public MotiDPermesso getMotiDPermesso() {
		return this.motiDPermesso;
	}

	public void setMotiDPermesso(MotiDPermesso motiDPermesso) {
		this.motiDPermesso = motiDPermesso;
	}

}
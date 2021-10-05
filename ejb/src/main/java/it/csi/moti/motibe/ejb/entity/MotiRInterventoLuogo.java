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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_r_intervento_luogo database table.
 * 
 */
@Entity
@Table(name = "moti_r_intervento_luogo")
@NamedQuery(name = "MotiRInterventoLuogo.findAll", query = "SELECT m FROM MotiRInterventoLuogo m")
public class MotiRInterventoLuogo extends BaseAuditedEntity<Integer> implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idInterventoLuogo;
	}

	@Override
	public void setId(Integer id) {
		idInterventoLuogo = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_intervento_luogo")
	private Integer idInterventoLuogo;

	// bi-directional many-to-one association to MotiTLuogo
	@ManyToOne
	@JoinColumn(name = "fk_luogo")
	private MotiTLuogo motiTLuogo;

	// bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name = "fk_intervento")
	private MotiTIntervento motiTIntervento;

	public MotiRInterventoLuogo() {
	}

	public Integer getIdInterventoLuogo() {
		return this.idInterventoLuogo;
	}

	public void setIdInterventoLuogo(Integer idInterventoLuogo) {
		this.idInterventoLuogo = idInterventoLuogo;
	}

	public MotiTLuogo getMotiTLuogo() {
		return this.motiTLuogo;
	}

	public void setMotiTLuogo(MotiTLuogo motiTLuogo) {
		this.motiTLuogo = motiTLuogo;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

}
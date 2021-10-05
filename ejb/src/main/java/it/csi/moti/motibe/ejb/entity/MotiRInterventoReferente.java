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

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;


/**
 * The persistent class for the moti_r_intervento_referente database table.
 * 
 */
@Entity
@Table(name="moti_r_intervento_referente")
@NamedQuery(name="MotiRInterventoReferente.findAll", query="SELECT o FROM MotiRInterventoReferente o")
public class MotiRInterventoReferente implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idReferenteIntervento;
	}

	@Override
	public void setId(Integer id) {
		 idReferenteIntervento = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_referente_intervento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReferenteIntervento;

	//bi-directional many-to-one association to MotiTIntervento
	@ManyToOne
	@JoinColumn(name="fk_intervento")
	private MotiTIntervento motiTIntervento;

	//bi-directional many-to-one association to MotiTUtente
	@ManyToOne
	@JoinColumn(name="fk_utente")
	private MotiTUtente motiTUtente;

	public MotiRInterventoReferente() {
	}

	public Integer getIdReferenteIntervento() {
		return this.idReferenteIntervento;
	}

	public void setIdReferenteIntervento(Integer idReferenteIntervento) {
		this.idReferenteIntervento = idReferenteIntervento;
	}

	public MotiTIntervento getMotiTIntervento() {
		return this.motiTIntervento;
	}

	public void setMotiTIntervento(MotiTIntervento motiTIntervento) {
		this.motiTIntervento = motiTIntervento;
	}

	public MotiTUtente getMotiTUtente() {
		return this.motiTUtente;
	}

	public void setMotiTUtente(MotiTUtente motiTUtente) {
		this.motiTUtente = motiTUtente;
	}

}
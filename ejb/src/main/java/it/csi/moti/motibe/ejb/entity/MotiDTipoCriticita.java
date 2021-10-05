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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;


/**
 * The persistent class for the moti_d_tipo_criticita database table.
 * 
 */
@Entity
@Table(name="moti_d_tipo_criticita")
@NamedQuery(name="MotiDTipoCriticita.findAll", query="SELECT o FROM MotiDTipoCriticita o")
public class MotiDTipoCriticita implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idTipoCriticita;
	}

	@Override
	public void setId(Integer id) {
		 idTipoCriticita = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_criticita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoCriticita;

	@Column(name="descrizione_tipo_criticita")
	private String descrizioneTipoCriticita;

	
	public MotiDTipoCriticita() {
	}

	public Integer getIdTipoCriticita() {
		return this.idTipoCriticita;
	}

	public void setIdTipoCriticita(Integer idTipoCriticita) {
		this.idTipoCriticita = idTipoCriticita;
	}

	public String getDescrizioneTipoCriticita() {
		return this.descrizioneTipoCriticita;
	}

	public void setDescrizioneTipoCriticita(String descrizioneTipoCriticita) {
		this.descrizioneTipoCriticita = descrizioneTipoCriticita;
	}

	

}
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
 * The persistent class for the moti_d_stato_attuaz database table.
 * 
 */
@Entity
@Table(name="moti_d_stato_attuaz")
@NamedQuery(name="MotiDStatoAttuaz.findAll", query="SELECT o FROM MotiDStatoAttuaz o")
public class MotiDStatoAttuaz implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idStatoAttuaz;
	}

	@Override
	public void setId(Integer id) {
		 idStatoAttuaz = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_stato_attuaz")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStatoAttuaz;

	private String descrizione;

	private BigDecimal ordine;

	
	public MotiDStatoAttuaz() {
	}

	public Integer getIdStatoAttuaz() {
		return this.idStatoAttuaz;
	}

	public void setIdStatoAttuaz(Integer idStatoAttuaz) {
		this.idStatoAttuaz = idStatoAttuaz;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigDecimal getOrdine() {
		return this.ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	

}
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
 * The persistent class for the moti_d_tipologia database table.
 * 
 */
@Entity
@Table(name="moti_d_tipologia")
@NamedQuery(name="MotiDTipologia.findAll", query="SELECT o FROM MotiDTipologia o")
public class MotiDTipologia implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idTipologia;
	}

	@Override
	public void setId(Integer id) {
		 idTipologia = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipologia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipologia;

	private String descrizione;

	@Column(name="elem_default")
	private BigDecimal elemDefault;

	private BigDecimal ordine;

	
	public MotiDTipologia() {
	}

	public Integer getIdTipologia() {
		return this.idTipologia;
	}

	public void setIdTipologia(Integer idTipologia) {
		this.idTipologia = idTipologia;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public BigDecimal getElemDefault() {
		return this.elemDefault;
	}

	public void setElemDefault(BigDecimal elemDefault) {
		this.elemDefault = elemDefault;
	}

	public BigDecimal getOrdine() {
		return this.ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	
}
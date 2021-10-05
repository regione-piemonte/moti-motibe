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
 * The persistent class for the moti_d_fonte_dati database table.
 * 
 */
@Entity
@Table(name="moti_d_fonte_dati")
@NamedQuery(name="MotiDFonteDati.findAll", query="SELECT o FROM MotiDFonteDati o")
public class MotiDFonteDati implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idFonteDati;
	}

	@Override
	public void setId(Integer id) {
		 idFonteDati = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_fonte_dati")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFonteDati;

	private String descrizione;

	@Column(name="elem_default")
	private BigDecimal elemDefault;

	private BigDecimal ordine;

	
	public MotiDFonteDati() {
	}

	public Integer getIdFonteDati() {
		return this.idFonteDati;
	}

	public void setIdFonteDati(Integer idFonteDati) {
		this.idFonteDati = idFonteDati;
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
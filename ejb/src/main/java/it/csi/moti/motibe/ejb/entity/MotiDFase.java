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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_d_fase database table.
 * 
 */
@Entity
@Table(name = "moti_d_fase")
@NamedQuery(name = "MotiDFase.findAll", query = "SELECT o FROM MotiDFase o")
public class MotiDFase implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idFase;
	}

	@Override
	public void setId(Integer id) {
		idFase = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_fase")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFase;

	private String descrizione;

	// bi-directional many-to-one association to MotiDFonteDati
	@ManyToOne
	@JoinColumn(name = "fk_fonte_dati")
	private MotiDFonteDati motiDFonteDati;

	private BigDecimal ordine;

	private String tipologia;

	public MotiDFase() {
	}

	public Integer getIdFase() {
		return this.idFase;
	}

	public void setIdFase(Integer idFase) {
		this.idFase = idFase;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public MotiDFonteDati getMotiDFonteDati() {
		return motiDFonteDati;
	}

	public void setMotiDFonteDati(MotiDFonteDati motiDFonteDati) {
		this.motiDFonteDati = motiDFonteDati;
	}

	public BigDecimal getOrdine() {
		return this.ordine;
	}

	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

	public String getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

}
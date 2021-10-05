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
 * The persistent class for the moti_d_ruolo database table.
 * 
 */
@Entity
@Table(name="moti_d_ruolo")
@NamedQuery(name="MotiDRuolo.findAll", query="SELECT o FROM MotiDRuolo o")
public class MotiDRuolo implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idRuolo;
	}

	@Override
	public void setId(Integer id) {
		 idRuolo = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ruolo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRuolo;

	@Column(name="accesso_sistema")
	private Boolean accessoSistema;

	@Column(name="cod_ruolo")
	private String codRuolo;

	@Column(name="descrizione_ruolo")
	private String descrizioneRuolo;

	public MotiDRuolo() {
	}

	public Integer getIdRuolo() {
		return this.idRuolo;
	}

	public void setIdRuolo(Integer idRuolo) {
		this.idRuolo = idRuolo;
	}

	public Boolean getAccessoSistema() {
		return this.accessoSistema;
	}

	public void setAccessoSistema(Boolean accessoSistema) {
		this.accessoSistema = accessoSistema;
	}

	public String getCodRuolo() {
		return this.codRuolo;
	}

	public void setCodRuolo(String codRuolo) {
		this.codRuolo = codRuolo;
	}

	public String getDescrizioneRuolo() {
		return this.descrizioneRuolo;
	}

	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}

	

}
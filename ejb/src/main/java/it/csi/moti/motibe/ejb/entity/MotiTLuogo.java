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
 * The persistent class for the moti_t_luogo database table.
 * 
 */
@Entity
@Table(name="moti_t_luogo")
@NamedQuery(name="MotiTLuogo.findAll", query="SELECT m FROM MotiTLuogo m")
public class MotiTLuogo implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idLuogo;
	}

	@Override
	public void setId(Integer id) {
		idLuogo = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="id_luogo")
	private Integer idLuogo;

	@Column(name="denom_luogo")
	private String denomLuogo;

	@Column(name="denom_regione")
	private String denomRegione;

	@Column(name="flag_provincia")
	private Boolean flagProvincia;

	@Column(name="luogo_istat")
	private String luogoIstat;

	@Column(name="regione_istat")
	private String regioneIstat;

	private String sigla;

	//bi-directional many-to-one association to MotiRInterventoLuogo
	@OneToMany(mappedBy="motiTLuogo")
	private List<MotiRInterventoLuogo> motiRInterventoLuogos;

	public MotiTLuogo() {
	}

	public Integer getIdLuogo() {
		return this.idLuogo;
	}

	public void setIdLuogo(Integer idLuogo) {
		this.idLuogo = idLuogo;
	}

	public String getDenomLuogo() {
		return this.denomLuogo;
	}

	public void setDenomLuogo(String denomLuogo) {
		this.denomLuogo = denomLuogo;
	}

	public String getDenomRegione() {
		return this.denomRegione;
	}

	public void setDenomRegione(String denomRegione) {
		this.denomRegione = denomRegione;
	}

	public Boolean getFlagProvincia() {
		return this.flagProvincia;
	}

	public void setFlagProvincia(Boolean flagProvincia) {
		this.flagProvincia = flagProvincia;
	}

	public String getLuogoIstat() {
		return this.luogoIstat;
	}

	public void setLuogoIstat(String luogoIstat) {
		this.luogoIstat = luogoIstat;
	}

	public String getRegioneIstat() {
		return this.regioneIstat;
	}

	public void setRegioneIstat(String regioneIstat) {
		this.regioneIstat = regioneIstat;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<MotiRInterventoLuogo> getMotiRInterventoLuogos() {
		return this.motiRInterventoLuogos;
	}

	public void setMotiRInterventoLuogos(List<MotiRInterventoLuogo> motiRInterventoLuogos) {
		this.motiRInterventoLuogos = motiRInterventoLuogos;
	}

	public MotiRInterventoLuogo addMotiRInterventoLuogo(MotiRInterventoLuogo motiRInterventoLuogo) {
		getMotiRInterventoLuogos().add(motiRInterventoLuogo);
		motiRInterventoLuogo.setMotiTLuogo(this);

		return motiRInterventoLuogo;
	}

	public MotiRInterventoLuogo removeMotiRInterventoLuogo(MotiRInterventoLuogo motiRInterventoLuogo) {
		getMotiRInterventoLuogos().remove(motiRInterventoLuogo);
		motiRInterventoLuogo.setMotiTLuogo(null);

		return motiRInterventoLuogo;
	}

}
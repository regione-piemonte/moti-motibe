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
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_d_attuatore database table.
 * 
 */
@Entity
@Table(name="moti_d_attuatore")
@NamedQuery(name="MotiDAttuatore.findAll", query="SELECT m FROM MotiDAttuatore m")
public class MotiDAttuatore implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return idAttuatore;
	}

	@Override
	public void setId(Integer id) {
		idAttuatore = id;
	}


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_attuatore")
	private Integer idAttuatore;

	@Column(name="codice_fiscale")
	private String codiceFiscale;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inserimento")
	private Date dataInserimento;

	private String descrizione;

	//bi-directional many-to-one association to MotiTUtente
	@ManyToOne
	@JoinColumn(name="fk_utente_inserimento")
	private MotiTUtente motiTUtenteInserimento;

	public MotiDAttuatore() {
	}

	public Integer getIdAttuatore() {
		return this.idAttuatore;
	}

	public void setIdAttuatore(Integer idAttuatore) {
		this.idAttuatore = idAttuatore;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public MotiTUtente getMotiTUtenteInserimento() {
		return this.motiTUtenteInserimento;
	}

	public void setMotiTUtenteInserimento(MotiTUtente motiTUtenteInserimento) {
		this.motiTUtenteInserimento = motiTUtenteInserimento;
	}

}
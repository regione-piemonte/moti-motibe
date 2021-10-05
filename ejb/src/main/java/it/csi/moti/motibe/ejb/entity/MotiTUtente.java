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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

/**
 * The persistent class for the moti_t_utente database table.
 * 
 */
@Entity
@Table(name = "moti_t_utente")
@NamedQuery(name = "MotiTUtente.findAll", query = "SELECT o FROM MotiTUtente o")
public class MotiTUtente implements Serializable, BaseEntity<Integer> {
	private static final long serialVersionUID = 1L;

	@Override
	public Integer getId() {
		return idUtente;
	}

	@Override
	public void setId(Integer id) {
		this.idUtente = id;
	}

	@Id
	@Column(name = "id_utente")
	private Integer idUtente;

	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	private String cognome;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cancellazione")
	private Date dataCancellazione;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inserimento")
	private Date dataInserimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultima_modifica")
	private Date dataUltimaModifica;

	private String email;

	// bi-directional many-to-one association to MotiDRuolo
	@ManyToOne
	@JoinColumn(name = "fk_id_ruolo")
	private MotiDRuolo motiDRuolo;

	@Column(name = "flag_accesso_sistema")
	private Boolean flagAccessoSistema;

	private String nome;

	private String telefono;

	public MotiTUtente() {
	}

	public Integer getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataCancellazione() {
		return this.dataCancellazione;
	}

	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

	public Date getDataInserimento() {
		return this.dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Date getDataUltimaModifica() {
		return this.dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MotiDRuolo getMotiDRuolo() {
		return motiDRuolo;
	}

	public void setMotiDRuolo(MotiDRuolo motiDRuolo) {
		this.motiDRuolo = motiDRuolo;
	}

	public Boolean getFlagAccessoSistema() {
		return this.flagAccessoSistema;
	}

	public void setFlagAccessoSistema(Boolean flagAccessoSistema) {
		this.flagAccessoSistema = flagAccessoSistema;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
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
package it.csi.moti.motibe.ejb.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.MotiTUtente;

/**
 * Audited entity base implementation
 * 
 * @param <K> the key type
 */
@MappedSuperclass
public abstract class BaseAuditedEntity<K> implements BaseEntity<K> {

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inserimento")
	private Date dataInserimento;

	// bi-directional many-to-one association to MotiTUtente
	@ManyToOne
	@JoinColumn(name = "fk_utente_inserimento")
	private MotiTUtente motiTUtenteInserimento;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_ultima_modifica")
	private Date dataUltimaModifica;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cancellazione")
	private Date dataCancellazione;

	// bi-directional many-to-one association to MotiTUtente
	@ManyToOne
	@JoinColumn(name = "fk_utente_ultima_modifica")
	private MotiTUtente motiTUtenteUltimaModifica;

	/**
	 * @return the dataInserimento
	 */
	public Date getDataInserimento() {
		return dataInserimento;
	}

	/**
	 * @param dataInserimento the dataInserimento to set
	 */
	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	/**
	 * @return the motiTUtenteInserimento
	 */
	public MotiTUtente getMotiTUtenteInserimento() {
		return motiTUtenteInserimento;
	}

	/**
	 * @param motiTUtenteInserimento the motiTUtenteInserimento to set
	 */
	public void setMotiTUtenteInserimento(MotiTUtente motiTUtenteInserimento) {
		this.motiTUtenteInserimento = motiTUtenteInserimento;
	}

	/**
	 * @return the dataUltimaModifica
	 */
	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	/**
	 * @param dataUltimaModifica the dataUltimaModifica to set
	 */
	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	/**
	 * @return the motiTUtenteUltimaModifica
	 */
	public MotiTUtente getMotiTUtenteUltimaModifica() {
		return motiTUtenteUltimaModifica;
	}

	/**
	 * @param motiTUtenteUltimaModifica the motiTUtenteUltimaModifica to set
	 */
	public void setMotiTUtenteUltimaModifica(MotiTUtente motiTUtenteUltimaModifica) {
		this.motiTUtenteUltimaModifica = motiTUtenteUltimaModifica;
	}

	/**
	 * @return the dataCancellazione
	 */
	public Date getDataCancellazione() {
		return dataCancellazione;
	}

	/**
	 * @param dataCancellazione the dataCancellazione to set
	 */
	public void setDataCancellazione(Date dataCancellazione) {
		this.dataCancellazione = dataCancellazione;
	}

}

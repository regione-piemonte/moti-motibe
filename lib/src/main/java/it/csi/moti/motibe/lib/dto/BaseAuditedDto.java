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
package it.csi.moti.motibe.lib.dto;

import java.util.Date;

/**
 * Base model class
 * 
 * @param <K> the key type
 */
public abstract class BaseAuditedDto<K> extends BaseDto<K> {

	protected Utente utenteInserimento;
	protected Utente utenteUltimaModifica;

	private Date dataCancellazione;
	private Date dataInserimento;
	private Date dataUltimaModifica;

	/** Base JavaBean contructor */
	protected BaseAuditedDto() {
		super(null);
	}

	/**
	 * Constructor
	 * 
	 * @param id the id
	 */
	protected BaseAuditedDto(K id) {
		super(id);
	}

	protected String innerToString() {
		return new StringBuilder().append(", dataCancellazione=").append(dataCancellazione).append(", id=").append(id)
				.toString();
	}

	/**
	 * @return the utenteInserimento
	 */
	public Utente getUtenteInserimento() {
		return utenteInserimento;
	}

	/**
	 * @param utenteInserimento the utenteInserimento to set
	 */
	public void setUtenteInserimento(Utente utenteInserimento) {
		this.utenteInserimento = utenteInserimento;
	}

	/**
	 * @return the utenteUltimaModifica
	 */
	public Utente getUtenteUltimaModifica() {
		return utenteUltimaModifica;
	}

	/**
	 * @param utenteUltimaModifica the utenteUltimaModifica to set
	 */
	public void setUtenteUltimaModifica(Utente utenteUltimaModifica) {
		this.utenteUltimaModifica = utenteUltimaModifica;
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

}

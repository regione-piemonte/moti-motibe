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
package it.csi.moti.motibe.lib.dto.intervento;

import java.io.Serializable;
import java.util.Date;

import it.csi.moti.motibe.lib.dto.BaseDto;
import it.csi.moti.motibe.lib.dto.decodifiche.Permesso;

/**
 * The Class RuoloPermesso.
 */
public class RuoloPermesso extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Date dtFineValidita;
	private Date dtInizioValidita;
	private Integer fkIdRuolo;
	private Permesso permesso;

	/**
	 * @return the dtFineValidita
	 */
	public Date getDtFineValidita() {
		return dtFineValidita;
	}
	
	/**
	 * @param dtFineValidita the dtFineValidita to set
	 */
	public void setDtFineValidita(Date dtFineValidita) {
		this.dtFineValidita = dtFineValidita;
	}

	/**
	 * @return the dtInizioValidita
	 */
	public Date getDtInizioValidita() {
		return dtInizioValidita;
	}
	
	/**
	 * @param dtInizioValidita the dtInizioValidita to set
	 */
	public void setDtInizioValidita(Date dtInizioValidita) {
		this.dtInizioValidita = dtInizioValidita;
	}

	/**
	 * @return the fkIdRuolo
	 */
	public Integer getFkIdRuolo() {
		return fkIdRuolo;
	}
	
	/**
	 * @param fkIdRuolo the fkIdRuolo to set
	 */
	public void setFkIdRuolo(Integer fkIdRuolo) {
		this.fkIdRuolo = fkIdRuolo;
	}

	/**
	 * @return the permesso
	 */
	public Permesso getPermesso() {
		return permesso;
	}
	
	/**
	 * @param permesso the permesso to set
	 */
	public void setPermesso(Permesso permesso) {
		this.permesso = permesso;
	}

}

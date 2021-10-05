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
package it.csi.moti.motibe.lib.dto.decodifiche;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import it.csi.moti.motibe.lib.dto.BaseDto;
import it.csi.moti.motibe.lib.dto.intervento.RuoloPermesso;

/**
 * The Class Permesso.
 */
public class Permesso extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descBrevePermesso;
	private String descPermesso;
	private Date dtFineValidita;
	private Date dtInizioValidita;
	private List<RuoloPermesso> ruoloPermessos;

	/**
	 * @return the descBrevePermesso
	 */
	public String getDescBrevePermesso() {
		return descBrevePermesso;
	}
	
	/**
	 * @param descBrevePermesso the descBrevePermesso to set
	 */
	public void setDescBrevePermesso(String descBrevePermesso) {
		this.descBrevePermesso = descBrevePermesso;
	}

	/**
	 * @return the descPermesso
	 */
	public String getDescPermesso() {
		return descPermesso;
	}
	
	/**
	 * @param descPermesso the descPermesso to set
	 */
	public void setDescPermesso(String descPermesso) {
		this.descPermesso = descPermesso;
	}

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
	 * @return the ruoloPermessos
	 */
	public List<RuoloPermesso> getRuoloPermessos() {
		return ruoloPermessos;
	}
	
	/**
	 * @param ruoloPermessos the ruoloPermessos to set
	 */
	public void setRuoloPermessos(List<RuoloPermesso> ruoloPermessos) {
		this.ruoloPermessos = ruoloPermessos;
	}

}

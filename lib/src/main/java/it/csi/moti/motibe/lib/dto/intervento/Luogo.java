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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import it.csi.moti.motibe.lib.dto.BaseDto;

/**
 * The Class Luogo.
 */
public class Luogo extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String denomLuogo;
	private String denomRegione;
	private Boolean flagProvincia;
	private String luogoIstat;
	private String regioneIstat;
	private String sigla;

	/**
	 * @return the denomLuogo
	 */
	public String getDenomLuogo() {
		return denomLuogo;
	}
	
	/**
	 * @param denomLuogo the denomLuogo to set
	 */
	public void setDenomLuogo(String denomLuogo) {
		this.denomLuogo = denomLuogo;
	}

	/**
	 * @return the denomRegione
	 */
	public String getDenomRegione() {
		return denomRegione;
	}
	
	/**
	 * @param denomRegione the denomRegione to set
	 */
	public void setDenomRegione(String denomRegione) {
		this.denomRegione = denomRegione;
	}

	/**
	 * @return the flagProvincia
	 */
	public Boolean getFlagProvincia() {
		return flagProvincia;
	}
	
	/**
	 * @param flagProvincia the flagProvincia to set
	 */
	public void setFlagProvincia(Boolean flagProvincia) {
		this.flagProvincia = flagProvincia;
	}

	/**
	 * @return the luogoIstat
	 */
	public String getLuogoIstat() {
		return luogoIstat;
	}
	
	/**
	 * @param luogoIstat the luogoIstat to set
	 */
	public void setLuogoIstat(String luogoIstat) {
		this.luogoIstat = luogoIstat;
	}

	/**
	 * @return the regioneIstat
	 */
	public String getRegioneIstat() {
		return regioneIstat;
	}
	
	/**
	 * @param regioneIstat the regioneIstat to set
	 */
	public void setRegioneIstat(String regioneIstat) {
		this.regioneIstat = regioneIstat;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}
	
	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}

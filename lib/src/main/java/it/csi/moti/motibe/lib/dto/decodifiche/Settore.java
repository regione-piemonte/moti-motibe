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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import it.csi.moti.motibe.lib.dto.BaseDto;

/**
 * The Class Settore.
 */
public class Settore extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private BigDecimal elemDefault;
	private BigDecimal ordine;

	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the elemDefault
	 */
	public BigDecimal getElemDefault() {
		return elemDefault;
	}
	
	/**
	 * @param elemDefault the elemDefault to set
	 */
	public void setElemDefault(BigDecimal elemDefault) {
		this.elemDefault = elemDefault;
	}

	/**
	 * @return the ordine
	 */
	public BigDecimal getOrdine() {
		return ordine;
	}
	
	/**
	 * @param ordine the ordine to set
	 */
	public void setOrdine(BigDecimal ordine) {
		this.ordine = ordine;
	}

}

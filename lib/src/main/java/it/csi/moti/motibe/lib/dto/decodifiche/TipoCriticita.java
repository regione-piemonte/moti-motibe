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
 * The Class TipoCriticita.
 */
public class TipoCriticita extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descrizioneTipoCriticita;

	/**
	 * @return the descrizioneTipoCriticita
	 */
	public String getDescrizioneTipoCriticita() {
		return descrizioneTipoCriticita;
	}
	
	/**
	 * @param descrizioneTipoCriticita the descrizioneTipoCriticita to set
	 */
	public void setDescrizioneTipoCriticita(String descrizioneTipoCriticita) {
		this.descrizioneTipoCriticita = descrizioneTipoCriticita;
	}

}

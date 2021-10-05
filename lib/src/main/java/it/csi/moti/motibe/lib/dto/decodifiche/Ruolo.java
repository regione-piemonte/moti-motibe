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
 * The Class Ruolo.
 */
public class Ruolo extends BaseDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Boolean accessoSistema;
	private String codRuolo;
	private String descrizioneRuolo;

	/**
	 * @return the accessoSistema
	 */
	public Boolean getAccessoSistema() {
		return accessoSistema;
	}
	
	/**
	 * @param accessoSistema the accessoSistema to set
	 */
	public void setAccessoSistema(Boolean accessoSistema) {
		this.accessoSistema = accessoSistema;
	}

	/**
	 * @return the codRuolo
	 */
	public String getCodRuolo() {
		return codRuolo;
	}
	
	/**
	 * @param codRuolo the codRuolo to set
	 */
	public void setCodRuolo(String codRuolo) {
		this.codRuolo = codRuolo;
	}

	/**
	 * @return the descrizioneRuolo
	 */
	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}
	
	/**
	 * @param descrizioneRuolo the descrizioneRuolo to set
	 */
	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}

}

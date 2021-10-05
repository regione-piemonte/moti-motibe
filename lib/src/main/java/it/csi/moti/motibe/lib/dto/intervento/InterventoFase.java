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

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;
import it.csi.moti.motibe.lib.dto.decodifiche.Fase;

/**
 * The Class InterventoFase.
 */
public class InterventoFase extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Date dataEffettiva;
	private Date dataPrevista;
	private Fase fase;
	private Intervento intervento;

	/**
	 * @return the dataEffettiva
	 */
	public Date getDataEffettiva() {
		return dataEffettiva;
	}

	/**
	 * @param dataEffettiva the dataEffettiva to set
	 */
	public void setDataEffettiva(Date dataEffettiva) {
		this.dataEffettiva = dataEffettiva;
	}

	/**
	 * @return the dataPrevista
	 */
	public Date getDataPrevista() {
		return dataPrevista;
	}

	/**
	 * @param dataPrevista the dataPrevista to set
	 */
	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	/**
	 * @return the fase
	 */
	public Fase getFase() {
		return fase;
	}

	/**
	 * @param fase the fase to set
	 */
	public void setFase(Fase fase) {
		this.fase = fase;
	}

	/**
	 * @return the intervento
	 */
	public Intervento getIntervento() {
		return intervento;
	}

	/**
	 * @param intervento the intervento to set
	 */
	public void setIntervento(Intervento intervento) {
		this.intervento = intervento;
	}

}

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

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.SituazioneCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.TipoCriticita;

/**
 * The Class InterventoSituazioneCriticita.
 */
public class InterventoSituazioneCriticita extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String descrizione;
	private SituazioneCriticita situazioneCriticita;
	private TipoCriticita tipoCriticita;
	private Intervento intervento;
	private FonteDati fonteDati;

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
	 * @return the situazioneCriticita
	 */
	public SituazioneCriticita getSituazioneCriticita() {
		return situazioneCriticita;
	}

	/**
	 * Per sort in esporta excel
	 * @return
	 */
	public String getSituazioneCriticitaDescrizione() {
		return situazioneCriticita.getDescrizione();
	}

	/**
	 * @param situazioneCriticita the situazioneCriticita to set
	 */
	public void setSituazioneCriticita(SituazioneCriticita situazioneCriticita) {
		this.situazioneCriticita = situazioneCriticita;
	}

	/**
	 * @return the tipoCriticita
	 */
	public TipoCriticita getTipoCriticita() {
		return tipoCriticita;
	}

	/**
	 * @param tipoCriticita the tipoCriticita to set
	 */
	public void setTipoCriticita(TipoCriticita tipoCriticita) {
		this.tipoCriticita = tipoCriticita;
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

	/**
	 * @return the fonteDati
	 */
	public FonteDati getFonteDati() {
		return fonteDati;
	}

	/**
	 * @param fonteDati the fonteDati to set
	 */
	public void setFonteDati(FonteDati fonteDati) {
		this.fonteDati = fonteDati;
	}

}

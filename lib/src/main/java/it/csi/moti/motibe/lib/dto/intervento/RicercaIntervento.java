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

import java.util.List;

import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

public class RicercaIntervento {

	private FonteDati fonteDati;
	private String codIntervento;
	private String titolo;
	private Tipologia tipologia;
	private List<Utente> referentes;
	private List<Luogo> luogos;

	public FonteDati getFonteDati() {
		return fonteDati;
	}

	public void setFonteDati(FonteDati fonteDati) {
		this.fonteDati = fonteDati;
	}

	public String getCodIntervento() {
		return codIntervento;
	}

	public void setCodIntervento(String codIntervento) {
		this.codIntervento = codIntervento;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public List<Utente> getReferentes() {
		return referentes;
	}

	public void setReferentes(List<Utente> referentes) {
		this.referentes = referentes;
	}

	public List<Luogo> getLuogos() {
		return luogos;
	}

	public void setLuogos(List<Luogo> luogos) {
		this.luogos = luogos;
	}

}

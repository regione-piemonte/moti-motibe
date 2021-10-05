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
package it.csi.moti.motibe.ejb.business.be.service.request.intervento;

import java.util.List;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BasePagedRequest;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * The Class GetRicercaInterventiRequest.
 */
public class GetRicercaInterventiRequest extends BasePagedRequest {

	private FonteDati fonteDati;
	private String codIntervento;
	private String titolo;
	private Tipologia tipologia;
	private List<Utente> referentes;
	private List<Luogo> luogos;

	public GetRicercaInterventiRequest(Integer page, Integer size, String sort, String direction, FonteDati fonteDati,
			String codIntervento, String titolo, Tipologia tipologia, List<Utente> referentes, List<Luogo> luogos) {
		super(size, page, sort, direction);

		this.fonteDati = fonteDati;
		this.codIntervento = codIntervento;
		this.titolo = titolo;
		this.tipologia = tipologia;
		this.referentes = referentes;
		this.luogos = luogos;
	}

	public FonteDati getFonteDati() {
		return fonteDati;
	}

	public void setFonteDati(FonteDati fonteDati) {
		this.fonteDati = fonteDati;
	}

	public String getCodIntervento() {
		return codIntervento;
	}

	public String getTitolo() {
		return titolo;
	}

	public Tipologia getTipologia() {
		return tipologia;
	}

	public List<Utente> getReferentes() {
		return referentes;
	}

	public List<Luogo> getLuogos() {
		return luogos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetRicercaInterventiRequest []");
		return builder.toString();
	}
}
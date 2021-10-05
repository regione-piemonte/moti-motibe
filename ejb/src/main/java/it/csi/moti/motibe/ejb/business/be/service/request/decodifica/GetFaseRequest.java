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
package it.csi.moti.motibe.ejb.business.be.service.request.decodifica;

import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;

/**
 * The Class GetFaseRequest.
 */
public class GetFaseRequest implements BaseRequest {
	private String tipologia;
	private Integer idFonteDati;

	public GetFaseRequest(String tipologia, Integer idFonteDati) {
		super();
		this.tipologia = tipologia;
		this.idFonteDati = idFonteDati;
	}

	/**
	 * @return the tipologia
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * @return the idFonteDati
	 */
	public Integer getIdFonteDati() {
		return idFonteDati;
	}

	/**
	 * @param idFonteDati the idFonteDati to set
	 */
	public void setIdFonteDati(Integer idFonteDati) {
		this.idFonteDati = idFonteDati;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetFaseRequest []");
		return builder.toString();
	}
}
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
package it.csi.moti.motibe.ejb.business.be.dad.sort;

/**
 * Sort mapper for Intervento.
 */
public enum InterventoSort implements JpaSort {

	ID("id", "t.idIntervento"), FONTE_DATI("fonteDati", "t.motiDFonteDati.idFonteDati"),
	CODICE_INTERVENTO("codIntervento", "t.codIntervento"),
	TITOLO("titolo", "t.titolo"),
	STATO_ATTUAZIONE("statoAttuaz", "t.motiDStatoAttuaz.idStatoAttuaz"),
	TIPOLOGIA("tipologia", "t.motiDTipologia.idTipologia"),
	COSTO_PREVISTO("costoPrevisto", "t.motiTInterventoCostis.costoPrevisto");

	/** The model name. */
	private final String modelName;

	/** The query name. */
	private final String queryName;

	/**
	 * Constructor.
	 *
	 * @param modelName the model name
	 * @param queryName the query name
	 */
	private InterventoSort(String modelName, String queryName) {
		this.modelName = modelName;
		this.queryName = queryName;
	}

	@Override
	public String getQueryName() {
		return queryName;
	}

	@Override
	public String getModelName() {
		return modelName;
	}

	/**
	 * Retrieves the Sort by its model name.
	 *
	 * @param modelName the model name
	 * @return the sort
	 */
	public static InterventoSort byModelName(String modelName) {
		for (InterventoSort is : InterventoSort.values()) {
			if (is.modelName.equalsIgnoreCase(modelName)) {
				return is;
			}
		}
		return InterventoSort.ID;
	}

}

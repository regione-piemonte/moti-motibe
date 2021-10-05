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
package it.csi.moti.motibe.ejb.business.be.service.impl.intervento;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.impl.base.BaseService;
import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;

/**
 * Base service implementation for the intervento
 * 
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class BaseInterventoService<Q extends BaseRequest, R extends BaseResponse> extends BaseService<Q, R> {

	/** Data Access Delegate for intervento */
	protected final InterventoDad interventoDad;

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	protected BaseInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper);
		this.interventoDad = interventoDad;
	}

	protected String formatBigdecimal(BigDecimal bd) {
		if (bd != null) {
			// return bd.setScale(2, RoundingMode.HALF_UP).toString();
			DecimalFormat numberFormat = new DecimalFormat("#,##0.00",
					new DecimalFormatSymbols(new Locale("it", "IT")));
			numberFormat.setMaximumFractionDigits(2);
			numberFormat.setMinimumFractionDigits(2);
			return numberFormat.format(bd.doubleValue());
		}
		return "";
	}
}

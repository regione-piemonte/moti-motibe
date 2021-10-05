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
package it.csi.moti.motibe.ejb.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.csi.moti.motibe.lib.util.log.LogUtil;

/**
 * This class uses CDI to alias Java EE resources, such as the persistence context, to CDI beans
 * <p>Example injection on a managed bean field:</p>
 * <pre>
 * &#064;Inject
 * private EntityManager em;
 * </pre>
 */
public class Resources {
	/** Producer for the entity manager */
	@Produces
	@PersistenceContext
	private EntityManager em;

	/**
	 * Producer for the logger
	 * @param injectionPoint the injection point
	 * @return the logger
	 */
	@Produces
	public LogUtil produceLogUtil(InjectionPoint injectionPoint) {
		return new LogUtil(injectionPoint.getMember().getDeclaringClass());
	}
}

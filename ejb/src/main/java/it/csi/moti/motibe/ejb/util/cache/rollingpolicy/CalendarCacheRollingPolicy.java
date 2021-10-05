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
package it.csi.moti.motibe.ejb.util.cache.rollingpolicy;

import java.util.Calendar;
import java.util.Date;

/**
 * A CacheRollingPolicy which checks staleness via a Calendar.
 */
public abstract class CalendarCacheRollingPolicy implements CacheRollingPolicy {

	/**
	 * Checks whether the date makes the cached data stale.
	 *
	 * @param data           the cached date
	 * @param calendarFields the calendar fields to check
	 * 
	 * @return true, if the date is expired
	 */
	protected boolean isExpiredDate(Date data, int... calendarFields) {
		Calendar cacheDate = Calendar.getInstance();
		cacheDate.setTime(data);
		Calendar now = Calendar.getInstance();
		
		for(int calendarField : calendarFields){
			int cf = now.get(calendarField);
			int cfCache = cacheDate.get(calendarField);

			if (cfCache < cf) {
				return true;
			}
		}

		return false;
	}
}

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
package it.csi.moti.motibe.ejb.business.be.dad;

import java.util.function.Function;

import javax.inject.Inject;

import it.csi.moti.motibe.ejb.business.be.dao.moti.MotiTUtenteDao;
import it.csi.moti.motibe.ejb.util.jpa.Page;
import it.csi.moti.motibe.lib.dto.BaseDto;
import it.csi.moti.motibe.lib.util.log.LogUtil;
import it.csi.moti.motibe.lib.util.pagination.PagedList;
import it.csi.moti.motibe.lib.util.pagination.PagedListImpl;

/**
 * Base Data Access Delegate (DAD) class: maps between Entities and Models
 */
public abstract class BaseDad {

	@Inject
	private MotiTUtenteDao motiTUtenteDao;
	
	/** Logger */
	protected final LogUtil log = new LogUtil(getClass());

	/**
	 * Flush of the entity manager
	 */
	public void flush() {
		motiTUtenteDao.flush();
	}

	/**
	 * Flush And Clear of the entity manager
	 */
	public void flushAndClear() {
		motiTUtenteDao.flushAndClear();
	}

	/**
	 * Converts a page of data from the persistence layer to a paged list for the
	 * business layer
	 * 
	 * @param <D>        the Model type
	 * @param <E>        the Entity type
	 * @param elements   the persistence layer elements
	 * @param pageNumber the page number
	 * @param pageSize   the page size
	 * @param converter  the converter function
	 * @return the paged list corresponding to the given page
	 */
	protected <D, E> PagedList<D> toPagedList(Page<E> elements, int pageNumber, int pageSize,
			Function<E, D> converter) {
		PagedList<D> pagedList = new PagedListImpl<>();
		pagedList.setTotalElements(elements.getTotalElements());
		if (pageSize > 0) {
			pagedList.setCurrentPage(pageNumber);
			pagedList.setTotalPages((long) Math.ceil((double) elements.getTotalElements() / pageSize));
		} else {
			pagedList.setCurrentPage(0);
			pagedList.setTotalPages(1);
		}

		elements.getContent().stream().map(converter::apply).forEach(pagedList::add);
		return pagedList;
	}

	/**
	 * Extracts, null-safe, the id from the model
	 * 
	 * @param model the model
	 * @return the id
	 */
	protected <K> K getId(BaseDto<K> model) {
		return model != null ? model.getId() : null;
	}
}

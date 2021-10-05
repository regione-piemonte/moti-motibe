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
package it.csi.moti.motibe.ejb.business.be.service.request.base;

import it.csi.moti.motibe.lib.util.pagination.Sort;

/**
 * Base paged request class.
 */
public abstract class BasePagedRequest implements BaseRequest {

	/** The size. */
	protected final int size;
	/** The page. */
	protected final int page;
	/** The size. */
	protected final Sort sort;

	/**
	 * Instantiates a new base paged request.
	 *
	 * @param size the size
	 * @param page the page
	 */
	protected BasePagedRequest(Integer size, Integer page) {
		this(size, page, null, null);
	}
	
	/**
	 * Instantiates a new base paged request.
	 *
	 * @param size the size
	 * @param page the page
	 * @param sort the sort
	 * @param direction the direction
	 */
	protected BasePagedRequest(Integer size, Integer page, String sort, String direction) {
		this.size = size != null ? size.intValue() : 0;
		this.page = page != null ? page.intValue() : 0;
		this.sort = new Sort(sort, direction);
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the page.
	 *
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @return the sort
	 */
	public Sort getSort() {
		return sort;
	}
}

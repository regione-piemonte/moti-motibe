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
package it.csi.moti.motibe.ejb.business.be.service.response.base;

import javax.ws.rs.core.Response;

import it.csi.moti.motibe.ejb.util.mime.MimeTypeContainer;

/**
 * Base response for printing
 */
public abstract class BaseStampaResponse extends BaseResponse {

	private byte[] bytes;
	private String fileNameTemplate;
	private MimeTypeContainer mimeTypeContainer;
	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the fileNameTemplate
	 */
	public String getFileNameTemplate() {
		return fileNameTemplate;
	}

	/**
	 * @param fileNameTemplate the fileNameTemplate to set
	 */
	public void setFileNameTemplate(String fileNameTemplate) {
		this.fileNameTemplate = fileNameTemplate;
	}

	
	/**
	 * @return the mimeTypeContainer
	 */
	public MimeTypeContainer getMimeTypeContainer() {
		return mimeTypeContainer;
	}

	/**
	 * @param mimeTypeContainer the mimeTypeContainer to set
	 */
	public void setMimeTypeContainer(MimeTypeContainer mimeTypeContainer) {
		this.mimeTypeContainer = mimeTypeContainer;
	}

	@Override
	protected Response composeOwnResponse() {
		return Response
			.ok(bytes, getMimeTypeContainer().getMimeType())
			.header("Content-Disposition", "attachment;filename=" + fileNameTemplate + "." + getMimeTypeContainer().getExtension())
			.build();
	}

}

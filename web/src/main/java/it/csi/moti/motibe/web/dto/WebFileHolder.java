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
package it.csi.moti.motibe.web.dto;

import java.util.UUID;

import javax.ws.rs.FormParam;

import it.csi.moti.motibe.lib.dto.FileHolder;

/**
 * File holder for Web
 */
public class WebFileHolder {

	@FormParam("attachment")
	private byte[] attachment;
	@FormParam("idEnte")
	private String idEnte;
	
	/**
	 * @return the attachment
	 */
	public byte[] getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the idEnte
	 */
	public String getIdEnte() {
		return idEnte;
	}

	/**
	 * @param idEnte the idEnte to set
	 */
	public void setIdEnte(String idEnte) {
		this.idEnte = idEnte;
	}

	/**
	 * To a EJB file holder
	 * @return the file holder
	 */
	public FileHolder toFileHolder() {
		FileHolder fh = new FileHolder();
		fh.setAttachment(attachment);
		fh.setIdEnte(UUID.fromString(idEnte));
		return fh;
	}

}

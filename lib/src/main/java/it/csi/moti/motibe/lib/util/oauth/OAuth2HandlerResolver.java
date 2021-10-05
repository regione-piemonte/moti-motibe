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
package it.csi.moti.motibe.lib.util.oauth;

import java.util.List;

import javax.xml.ws.handler.Handler;

import org.apache.logging.log4j.Level;

import it.csi.moti.motibe.lib.util.soap.DefaultHandlerResolver;

/**
 * JAX-WS HandlerResolver for injecting OAuth2 headers
 */
public class OAuth2HandlerResolver extends DefaultHandlerResolver {
	
	private final OAuth2Helper oAuth2Helper;
	
	/**
	 * Injection constructor
	 * @param oAuth2Helper the helper
	 * @param logLevel the log level
	 */
	public OAuth2HandlerResolver(Level logLevel, OAuth2Helper oAuth2Helper) {
		super(logLevel);
		this.oAuth2Helper = oAuth2Helper;
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void addOtherHandlers(List<Handler> chain) {
		chain.add(new OAuth2SOAPHandler(oAuth2Helper));
	}

}

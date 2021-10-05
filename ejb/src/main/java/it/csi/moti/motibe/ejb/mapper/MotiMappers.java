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
package it.csi.moti.motibe.ejb.mapper;

import org.mapstruct.factory.Mappers;

/**
 * Mappers for Moti
 */
public final class MotiMappers {
	
	/** Private constructor */
	private MotiMappers() {
		// Prevent instantiation
	}
	
	public static final UtenteMapper UTENTE = Mappers.getMapper(UtenteMapper.class);

	public static final FaseMapper FASE = Mappers.getMapper(FaseMapper.class);
	public static final FonteDatiMapper FONTE_DATI = Mappers.getMapper(FonteDatiMapper.class);
	public static final FonteFinanziamentoMapper FONTE_FINANZIAMENTO = Mappers.getMapper(FonteFinanziamentoMapper.class);
	public static final RuoloMapper RUOLO = Mappers.getMapper(RuoloMapper.class);
	public static final SettoreMapper SETTORE = Mappers.getMapper(SettoreMapper.class);
	public static final SituazioneCriticitaMapper SITUAZIONE_CRITICITA = Mappers.getMapper(SituazioneCriticitaMapper.class);
	public static final StatoAttuazMapper STATO_ATTUAZIONE = Mappers.getMapper(StatoAttuazMapper.class);
	public static final TipoCriticitaMapper TIPO_CRITICITA = Mappers.getMapper(TipoCriticitaMapper.class);
	public static final TipologiaMapper TIPOLOGIA = Mappers.getMapper(TipologiaMapper.class);

	public static final InterventoFaseMapper INTERVENTO_FASE = Mappers.getMapper(InterventoFaseMapper.class);
	public static final InterventoFontefinMapper INTERVENTO_FONTEFIN = Mappers.getMapper(InterventoFontefinMapper.class);
	public static final InterventoReferenteMapper INTERVENTO_REFERENTE = Mappers.getMapper(InterventoReferenteMapper.class);
	public static final InterventoSituazioneCriticitaMapper INTERVENTO_SITUAZIONE_CRITICITA = Mappers.getMapper(InterventoSituazioneCriticitaMapper.class);
	public static final InterventoLuogoMapper INTERVENTO_LUOGO = Mappers.getMapper(InterventoLuogoMapper.class);public static final InterventoMapper INTERVENTO = Mappers.getMapper(InterventoMapper.class);
	public static final InterventoCostiMapper INTERVENTO_COSTI = Mappers.getMapper(InterventoCostiMapper.class);
	public static final InterventoDatiOtiMapper INTERVENTO_DATI_OTI = Mappers.getMapper(InterventoDatiOtiMapper.class);

	public static final LuogoMapper LUOGO = Mappers.getMapper(LuogoMapper.class);

	public static final PermessoMapper PERMESSO = Mappers.getMapper(PermessoMapper.class);
	public static final RuoloPermessoMapper RUOLO_PERMESSO = Mappers.getMapper(RuoloPermessoMapper.class);
	
	public static final AttuatoreMapper ATTUATORE = Mappers.getMapper(AttuatoreMapper.class);
}
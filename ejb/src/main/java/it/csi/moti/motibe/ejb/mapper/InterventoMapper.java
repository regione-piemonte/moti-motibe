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

import java.util.Collection;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.csi.moti.motibe.ejb.entity.MotiTIntervento;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Intervento and MotiTIntervento
 */
@Mapper(uses = { UtenteMapper.class, InterventoCostiMapper.class, InterventoDatiOtiMapper.class, InterventoFaseMapper.class,
		InterventoFontefinMapper.class, InterventoLuogoMapper.class, InterventoReferenteMapper.class,
		InterventoSituazioneCriticitaMapper.class, TipologiaMapper.class })
public interface InterventoMapper extends BaseMapperInterface<Intervento, MotiTIntervento> {

	@Override
	@Mapping(source = "motiTInterventoCostis", target = "interventoCostis")
	@Mapping(source = "motiTInterventoDatiOtis", target = "interventoDatiOtis")
	@Mapping(source = "motiRInterventoFases", target = "interventoFases")
	@Mapping(source = "motiRInterventoFontefins", target = "interventoFontefins")
	@Mapping(source = "motiRInterventoLuogos", target = "interventoLuogos")
	@Mapping(source = "motiRInterventoReferentes", target = "interventoReferentes")
	@Mapping(source = "motiRInterventoSituazioneCriticitas", target = "interventoSituazioneCriticitas")
	@Mapping(source = "motiDFonteDati", target = "fonteDati")
	@Mapping(source = "motiDSettore", target = "settore")
	@Mapping(source = "motiDStatoAttuaz", target = "statoAttuaz")
	@Mapping(source = "motiDTipologia", target = "tipologia")
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	@Mapping(source = "motiDAttuatore", target = "attuatoreObj")
	Intervento toModel(MotiTIntervento entity);

	@Override
	@IterableMapping(elementTargetType = Intervento.class)
	List<Intervento> toModels(Collection<MotiTIntervento> entities);

	@Override
	@IterableMapping(elementTargetType = MotiTIntervento.class)
	List<MotiTIntervento> toEntities(Collection<Intervento> models);

}

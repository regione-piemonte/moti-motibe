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

import it.csi.moti.motibe.ejb.entity.MotiRInterventoSituazioneCriticita;
import it.csi.moti.motibe.lib.dto.intervento.InterventoSituazioneCriticita;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoSituazioneCriticita and MotiRInterventoSituazioneCriticita
 */
@Mapper(uses = { SituazioneCriticitaMapper.class, TipoCriticitaMapper.class })
public interface InterventoSituazioneCriticitaMapper extends BaseMapperInterface<InterventoSituazioneCriticita, MotiRInterventoSituazioneCriticita> {

	@Override
	@Mapping(source = "motiDSituazioneCriticita", target = "situazioneCriticita")
	@Mapping(source = "motiDTipoCriticita", target = "tipoCriticita")
	@Mapping(source = "motiDFonteDati", target = "fonteDati")
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	InterventoSituazioneCriticita toModel(MotiRInterventoSituazioneCriticita entity);

	@Override
	@IterableMapping(elementTargetType = InterventoSituazioneCriticita.class)
	List<InterventoSituazioneCriticita> toModels(Collection<MotiRInterventoSituazioneCriticita> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRInterventoSituazioneCriticita.class)
	List<MotiRInterventoSituazioneCriticita> toEntities(Collection<InterventoSituazioneCriticita> models);

}

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

import it.csi.moti.motibe.ejb.entity.MotiRInterventoFase;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFase;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoFase and MotiRInterventoFase
 */
@Mapper(uses = { FaseMapper.class })
public interface InterventoFaseMapper extends BaseMapperInterface<InterventoFase, MotiRInterventoFase> {

	@Override
	@Mapping(source = "motiDFase", target = "fase")
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	InterventoFase toModel(MotiRInterventoFase entity);

	@Override
	@IterableMapping(elementTargetType = InterventoFase.class)
	List<InterventoFase> toModels(Collection<MotiRInterventoFase> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRInterventoFase.class)
	List<MotiRInterventoFase> toEntities(Collection<InterventoFase> models);

}

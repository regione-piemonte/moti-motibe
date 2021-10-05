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

import it.csi.moti.motibe.ejb.entity.MotiDSituazioneCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.SituazioneCriticita;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between SituazioneCriticita and MotiDSituazioneCriticita
 */
@Mapper
public interface SituazioneCriticitaMapper extends BaseMapperInterface<SituazioneCriticita, MotiDSituazioneCriticita> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	SituazioneCriticita toModel(MotiDSituazioneCriticita entity);

	@Override
	@IterableMapping(elementTargetType = SituazioneCriticita.class)
	List<SituazioneCriticita> toModels(Collection<MotiDSituazioneCriticita> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDSituazioneCriticita.class)
	List<MotiDSituazioneCriticita> toEntities(Collection<SituazioneCriticita> models);

}

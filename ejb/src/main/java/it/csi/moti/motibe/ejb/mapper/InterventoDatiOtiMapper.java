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

import it.csi.moti.motibe.ejb.entity.MotiTInterventoDatiOti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoDatiOti;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoDatiOti and MotiTInterventoDatiOti
 */
@Mapper
public interface InterventoDatiOtiMapper extends BaseMapperInterface<InterventoDatiOti, MotiTInterventoDatiOti> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	InterventoDatiOti toModel(MotiTInterventoDatiOti entity);

	@Override
	@IterableMapping(elementTargetType = InterventoDatiOti.class)
	List<InterventoDatiOti> toModels(Collection<MotiTInterventoDatiOti> entities);

	@Override
	@IterableMapping(elementTargetType = MotiTInterventoDatiOti.class)
	List<MotiTInterventoDatiOti> toEntities(Collection<InterventoDatiOti> models);

}

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

import it.csi.moti.motibe.ejb.entity.MotiDSettore;
import it.csi.moti.motibe.lib.dto.decodifiche.Settore;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Settore and MotiDSettore
 */
@Mapper
public interface SettoreMapper extends BaseMapperInterface<Settore, MotiDSettore> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	Settore toModel(MotiDSettore entity);

	@Override
	@IterableMapping(elementTargetType = Settore.class)
	List<Settore> toModels(Collection<MotiDSettore> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDSettore.class)
	List<MotiDSettore> toEntities(Collection<Settore> models);

}

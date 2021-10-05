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

import it.csi.moti.motibe.ejb.entity.MotiDPermesso;
import it.csi.moti.motibe.lib.dto.decodifiche.Permesso;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Permesso and MotiDPermesso
 */
@Mapper
public interface PermessoMapper extends BaseMapperInterface<Permesso, MotiDPermesso> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	Permesso toModel(MotiDPermesso entity);

	@Override
	@IterableMapping(elementTargetType = Permesso.class)
	List<Permesso> toModels(Collection<MotiDPermesso> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDPermesso.class)
	List<MotiDPermesso> toEntities(Collection<Permesso> models);

}

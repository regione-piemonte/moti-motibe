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

import it.csi.moti.motibe.ejb.entity.MotiTLuogo;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Luogo and MotiTLuogo
 */
@Mapper
public interface LuogoMapper extends BaseMapperInterface<Luogo, MotiTLuogo> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	Luogo toModel(MotiTLuogo entity);

	@Override
	@IterableMapping(elementTargetType = Luogo.class)
	List<Luogo> toModels(Collection<MotiTLuogo> entities);

	@Override
	@IterableMapping(elementTargetType = MotiTLuogo.class)
	List<MotiTLuogo> toEntities(Collection<Luogo> models);

}

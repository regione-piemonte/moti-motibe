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

import it.csi.moti.motibe.ejb.entity.MotiDRuolo;
import it.csi.moti.motibe.lib.dto.decodifiche.Ruolo;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Ruolo and MotiDRuolo
 */
@Mapper
public interface RuoloMapper extends BaseMapperInterface<Ruolo, MotiDRuolo> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	Ruolo toModel(MotiDRuolo entity);

	@Override
	@IterableMapping(elementTargetType = Ruolo.class)
	List<Ruolo> toModels(Collection<MotiDRuolo> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDRuolo.class)
	List<MotiDRuolo> toEntities(Collection<Ruolo> models);

}

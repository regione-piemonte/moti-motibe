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

import it.csi.moti.motibe.ejb.entity.MotiDStatoAttuaz;
import it.csi.moti.motibe.lib.dto.decodifiche.StatoAttuaz;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between StatoAttuaz and MotiDStatoAttuaz
 */
@Mapper
public interface StatoAttuazMapper extends BaseMapperInterface<StatoAttuaz, MotiDStatoAttuaz> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	StatoAttuaz toModel(MotiDStatoAttuaz entity);

	@Override
	@IterableMapping(elementTargetType = StatoAttuaz.class)
	List<StatoAttuaz> toModels(Collection<MotiDStatoAttuaz> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDStatoAttuaz.class)
	List<MotiDStatoAttuaz> toEntities(Collection<StatoAttuaz> models);

}

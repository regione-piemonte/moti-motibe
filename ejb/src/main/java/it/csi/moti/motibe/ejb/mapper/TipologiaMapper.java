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

import it.csi.moti.motibe.ejb.entity.MotiDTipologia;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Tipologia and MotiDTipologia
 */
@Mapper
public interface TipologiaMapper extends BaseMapperInterface<Tipologia, MotiDTipologia> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	Tipologia toModel(MotiDTipologia entity);

	@Override
	@IterableMapping(elementTargetType = Tipologia.class)
	List<Tipologia> toModels(Collection<MotiDTipologia> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDTipologia.class)
	List<MotiDTipologia> toEntities(Collection<Tipologia> models);

}

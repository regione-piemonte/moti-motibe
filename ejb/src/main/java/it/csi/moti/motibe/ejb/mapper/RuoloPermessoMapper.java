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

import it.csi.moti.motibe.ejb.entity.MotiRRuoloPermesso;
import it.csi.moti.motibe.lib.dto.intervento.RuoloPermesso;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between RuoloPermesso and MotiRRuoloPermesso
 */
@Mapper
public interface RuoloPermessoMapper extends BaseMapperInterface<RuoloPermesso, MotiRRuoloPermesso> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	RuoloPermesso toModel(MotiRRuoloPermesso entity);

	@Override
	@IterableMapping(elementTargetType = RuoloPermesso.class)
	List<RuoloPermesso> toModels(Collection<MotiRRuoloPermesso> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRRuoloPermesso.class)
	List<MotiRRuoloPermesso> toEntities(Collection<RuoloPermesso> models);

}

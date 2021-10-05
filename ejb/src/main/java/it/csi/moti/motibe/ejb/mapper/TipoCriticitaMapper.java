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

import it.csi.moti.motibe.ejb.entity.MotiDTipoCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.TipoCriticita;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between TipoCriticita and MotiDTipoCriticita
 */
@Mapper
public interface TipoCriticitaMapper extends BaseMapperInterface<TipoCriticita, MotiDTipoCriticita> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	TipoCriticita toModel(MotiDTipoCriticita entity);

	@Override
	@IterableMapping(elementTargetType = TipoCriticita.class)
	List<TipoCriticita> toModels(Collection<MotiDTipoCriticita> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDTipoCriticita.class)
	List<MotiDTipoCriticita> toEntities(Collection<TipoCriticita> models);

}

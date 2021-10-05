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

import it.csi.moti.motibe.ejb.entity.MotiDFonteFinanziamento;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteFinanziamento;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between FonteFinanziamento and MotiDFonteFinanziamento
 */
@Mapper
public interface FonteFinanziamentoMapper extends BaseMapperInterface<FonteFinanziamento, MotiDFonteFinanziamento> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	FonteFinanziamento toModel(MotiDFonteFinanziamento entity);

	@Override
	@IterableMapping(elementTargetType = FonteFinanziamento.class)
	List<FonteFinanziamento> toModels(Collection<MotiDFonteFinanziamento> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDFonteFinanziamento.class)
	List<MotiDFonteFinanziamento> toEntities(Collection<FonteFinanziamento> models);

}

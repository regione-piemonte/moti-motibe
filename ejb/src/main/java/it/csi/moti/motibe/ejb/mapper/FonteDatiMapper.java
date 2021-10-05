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

import it.csi.moti.motibe.ejb.entity.MotiDFonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between FonteDati and MotiDFonteDati
 */
@Mapper
public interface FonteDatiMapper extends BaseMapperInterface<FonteDati, MotiDFonteDati> {

	@Override
	// @Mapping(source = "entityName", target = "modelName")
	FonteDati toModel(MotiDFonteDati entity);

	@Override
	@IterableMapping(elementTargetType = FonteDati.class)
	List<FonteDati> toModels(Collection<MotiDFonteDati> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDFonteDati.class)
	List<MotiDFonteDati> toEntities(Collection<FonteDati> models);

}

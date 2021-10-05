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
import org.mapstruct.Mapping;

import it.csi.moti.motibe.ejb.entity.MotiDFase;
import it.csi.moti.motibe.lib.dto.decodifiche.Fase;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Fase and MotiDFase
 */
@Mapper(uses = FonteDatiMapper.class)
public interface FaseMapper extends BaseMapperInterface<Fase, MotiDFase> {

	@Override
	@Mapping(source = "motiDFonteDati", target = "fonteDati")
	Fase toModel(MotiDFase entity);

	@Override
	@IterableMapping(elementTargetType = Fase.class)
	List<Fase> toModels(Collection<MotiDFase> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDFase.class)
	List<MotiDFase> toEntities(Collection<Fase> models);

}

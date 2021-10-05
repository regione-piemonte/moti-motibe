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

import it.csi.moti.motibe.ejb.entity.MotiDAttuatore;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Attuatore and MotiDAttuatore
 */
@Mapper
public interface AttuatoreMapper extends BaseMapperInterface<Attuatore, MotiDAttuatore> {

	@Override
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	Attuatore toModel(MotiDAttuatore entity);

	@Override
	@IterableMapping(elementTargetType = Attuatore.class)
	List<Attuatore> toModels(Collection<MotiDAttuatore> entities);

	@Override
	@IterableMapping(elementTargetType = MotiDAttuatore.class)
	List<MotiDAttuatore> toEntities(Collection<Attuatore> models);

}

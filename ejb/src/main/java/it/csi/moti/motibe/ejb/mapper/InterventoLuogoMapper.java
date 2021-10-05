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

import it.csi.moti.motibe.ejb.entity.MotiRInterventoLuogo;
import it.csi.moti.motibe.lib.dto.intervento.InterventoLuogo;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoLuogo and MotiRInterventoLuogo
 */
@Mapper
public interface InterventoLuogoMapper extends BaseMapperInterface<InterventoLuogo, MotiRInterventoLuogo> {

	@Override
	@Mapping(source = "motiTLuogo", target = "luogo")
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	InterventoLuogo toModel(MotiRInterventoLuogo entity);

	@Override
	@IterableMapping(elementTargetType = InterventoLuogo.class)
	List<InterventoLuogo> toModels(Collection<MotiRInterventoLuogo> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRInterventoLuogo.class)
	List<MotiRInterventoLuogo> toEntities(Collection<InterventoLuogo> models);

}

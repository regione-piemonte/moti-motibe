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

import it.csi.moti.motibe.ejb.entity.MotiTInterventoCosti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoCosti;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoCosti and MotiTInterventoCosti
 */
@Mapper
public interface InterventoCostiMapper extends BaseMapperInterface<InterventoCosti, MotiTInterventoCosti> {

	@Override
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	InterventoCosti toModel(MotiTInterventoCosti entity);

	@Override
	@IterableMapping(elementTargetType = InterventoCosti.class)
	List<InterventoCosti> toModels(Collection<MotiTInterventoCosti> entities);

	@Override
	@IterableMapping(elementTargetType = MotiTInterventoCosti.class)
	List<MotiTInterventoCosti> toEntities(Collection<InterventoCosti> models);

}

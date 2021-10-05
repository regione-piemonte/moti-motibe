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

import it.csi.moti.motibe.ejb.entity.MotiRInterventoReferente;
import it.csi.moti.motibe.lib.dto.intervento.InterventoReferente;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoReferente and MotiRInterventoReferente
 */
@Mapper(uses = { UtenteMapper.class })
public interface InterventoReferenteMapper extends BaseMapperInterface<InterventoReferente, MotiRInterventoReferente> {

	@Override
	@Mapping(source = "motiTUtente", target = "utente")
	InterventoReferente toModel(MotiRInterventoReferente entity);

	@Override
	@IterableMapping(elementTargetType = InterventoReferente.class)
	List<InterventoReferente> toModels(Collection<MotiRInterventoReferente> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRInterventoReferente.class)
	List<MotiRInterventoReferente> toEntities(Collection<InterventoReferente> models);

}

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

import it.csi.moti.motibe.ejb.entity.MotiTUtente;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between Utente and MotiTUtente
 */
@Mapper(uses = RuoloMapper.class)
public interface UtenteMapper extends BaseMapperInterface<Utente, MotiTUtente> {

	@Override
	@Mapping(source = "motiDRuolo", target = "ruolo")
	Utente toModel(MotiTUtente entity);

	@Override
	@IterableMapping(elementTargetType = Utente.class)
	List<Utente> toModels(Collection<MotiTUtente> entities);

	@Override
	@IterableMapping(elementTargetType = MotiTUtente.class)
	List<MotiTUtente> toEntities(Collection<Utente> models);

}

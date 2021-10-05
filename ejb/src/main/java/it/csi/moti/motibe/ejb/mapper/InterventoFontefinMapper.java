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

import it.csi.moti.motibe.ejb.entity.MotiRInterventoFontefin;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFontefin;
import it.csi.moti.motibe.lib.mapper.BaseMapperInterface;

/**
 * Mapper between InterventoFontefin and MotiRInterventoFontefin
 */
@Mapper(uses = { FonteFinanziamentoMapper.class })
public interface InterventoFontefinMapper extends BaseMapperInterface<InterventoFontefin, MotiRInterventoFontefin> {

	@Override
	@Mapping(source = "motiDFonteFinanziamento", target = "fonteFinanziamento")
	@Mapping(source = "motiDFonteDati", target = "fonteDati")
	@Mapping(source = "motiTUtenteInserimento", target = "utenteInserimento")
	@Mapping(source = "motiTUtenteUltimaModifica", target = "utenteUltimaModifica")
	InterventoFontefin toModel(MotiRInterventoFontefin entity);

	@Override
	@IterableMapping(elementTargetType = InterventoFontefin.class)
	List<InterventoFontefin> toModels(Collection<MotiRInterventoFontefin> entities);

	@Override
	@IterableMapping(elementTargetType = MotiRInterventoFontefin.class)
	List<MotiRInterventoFontefin> toEntities(Collection<InterventoFontefin> models);

}

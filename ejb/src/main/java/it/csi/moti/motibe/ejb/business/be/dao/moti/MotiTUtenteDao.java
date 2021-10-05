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
package it.csi.moti.motibe.ejb.business.be.dao.moti;

import java.util.Optional;

import it.csi.moti.motibe.ejb.business.be.dao.BaseEntityDao;
import it.csi.moti.motibe.ejb.entity.MotiTUtente;

/**
 * Data Access Object interface for the entity MotiTUtente
 */
public interface MotiTUtenteDao extends BaseEntityDao<Integer, MotiTUtente> {

	/**
	 * Finds the entity by its CF
	 * 
	 * @param utenteCodiceFiscale the utente codice fiscale
	 * @return the entity
	 */
	Optional<MotiTUtente> findUtenteByCf(String utenteCodiceFiscale);

}

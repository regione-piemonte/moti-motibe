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
package it.csi.moti.motibe.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;

import it.csi.moti.motibe.ejb.entity.base.BaseEntity;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the moti_d_permesso database table.
 * 
 */
@Entity
@Table(name="moti_d_permesso")
@NamedQuery(name="MotiDPermesso.findAll", query="SELECT m FROM MotiDPermesso m")
public class MotiDPermesso implements Serializable, BaseEntity<Integer> {

	@Override
	public Integer getId() {
		return  idPermesso;
	}

	@Override
	public void setId(Integer id) {
		idPermesso = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permesso")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPermesso;

	@Column(name="desc_breve_permesso")
	private String descBrevePermesso;

	@Column(name="desc_permesso")
	private String descPermesso;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fine_validita")
	private Date dtFineValidita;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inizio_validita")
	private Date dtInizioValidita;

	//bi-directional many-to-one association to MotiRRuoloPermesso
	@OneToMany(mappedBy="motiDPermesso")
	private List<MotiRRuoloPermesso> motiRRuoloPermessos;

	public MotiDPermesso() {
	}

	public Integer getIdPermesso() {
		return this.idPermesso;
	}

	public void setIdPermesso(Integer idPermesso) {
		this.idPermesso = idPermesso;
	}

	public String getDescBrevePermesso() {
		return this.descBrevePermesso;
	}

	public void setDescBrevePermesso(String descBrevePermesso) {
		this.descBrevePermesso = descBrevePermesso;
	}

	public String getDescPermesso() {
		return this.descPermesso;
	}

	public void setDescPermesso(String descPermesso) {
		this.descPermesso = descPermesso;
	}

	public Date getDtFineValidita() {
		return this.dtFineValidita;
	}

	public void setDtFineValidita(Date dtFineValidita) {
		this.dtFineValidita = dtFineValidita;
	}

	public Date getDtInizioValidita() {
		return this.dtInizioValidita;
	}

	public void setDtInizioValidita(Date dtInizioValidita) {
		this.dtInizioValidita = dtInizioValidita;
	}

	public List<MotiRRuoloPermesso> getMotiRRuoloPermessos() {
		return this.motiRRuoloPermessos;
	}

	public void setMotiRRuoloPermessos(List<MotiRRuoloPermesso> motiRRuoloPermessos) {
		this.motiRRuoloPermessos = motiRRuoloPermessos;
	}

	public MotiRRuoloPermesso addMotiRRuoloPermesso(MotiRRuoloPermesso motiRRuoloPermesso) {
		getMotiRRuoloPermessos().add(motiRRuoloPermesso);
		motiRRuoloPermesso.setMotiDPermesso(this);

		return motiRRuoloPermesso;
	}

	public MotiRRuoloPermesso removeMotiRRuoloPermesso(MotiRRuoloPermesso motiRRuoloPermesso) {
		getMotiRRuoloPermessos().remove(motiRRuoloPermesso);
		motiRRuoloPermesso.setMotiDPermesso(null);

		return motiRRuoloPermesso;
	}

}
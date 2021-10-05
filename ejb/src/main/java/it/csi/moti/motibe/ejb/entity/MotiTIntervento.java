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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.csi.moti.motibe.ejb.entity.base.BaseAuditedEntity;
import it.csi.moti.motibe.ejb.entity.base.OptlockEntity;

/**
 * The persistent class for the moti_t_intervento database table.
 * 
 */
@Entity
@Table(name = "moti_t_intervento")
@NamedQuery(name = "MotiTIntervento.findAll", query = "SELECT o FROM MotiTIntervento o")
public class MotiTIntervento extends BaseAuditedEntity<Integer> implements OptlockEntity, Serializable {

	@Override
	public Integer getId() {
		return idIntervento;
	}

	@Override
	public void setId(Integer id) {
		idIntervento = id;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_intervento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIntervento;

	private String attuatore;

	private String cig;

	@Column(name = "cod_intervento")
	private String codIntervento;

	private String cup;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_blocco_modifica")
	private Date dataBloccoModifica;

	@Column(name = "descr_tecnica")
	private String descrTecnica;

	@Column(name = "fonte_dati_programmazione")
	private String fonteDatiProgrammazione;

	@Column(name = "fonte_dati_realizzazione")
	private String fonteDatiRealizzazione;

	@Column(name = "id_intervento_old")
	private BigDecimal idInterventoOld;

	@Column(name = "note_programmazione")
	private String noteProgrammazione;

	@Column(name = "note_realizzazione")
	private String noteRealizzazione;

	@Column(nullable = false)
	private UUID optlock;

	private String titolo;

	// bi-directional many-to-one association to MotiTInterventoCosti
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiTInterventoCosti> motiTInterventoCostis;

	// bi-directional many-to-one association to MotiTInterventoDatiOti
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiTInterventoDatiOti> motiTInterventoDatiOtis;

	// bi-directional many-to-one association to MotiRInterventoFase
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiRInterventoFase> motiRInterventoFases;

	// bi-directional many-to-one association to MotiRInterventoFontefin
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiRInterventoFontefin> motiRInterventoFontefins;

	// bi-directional many-to-one association to MotiRInterventoLuogo
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiRInterventoLuogo> motiRInterventoLuogos;

	// bi-directional many-to-one association to MotiRInterventoReferente
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiRInterventoReferente> motiRInterventoReferentes;

	// bi-directional many-to-one association to MotiRInterventoSituazioneCriticita
	@OneToMany(mappedBy = "motiTIntervento")
	private List<MotiRInterventoSituazioneCriticita> motiRInterventoSituazioneCriticitas;

	// bi-directional many-to-one association to MotiDFonteDati
	@ManyToOne
	@JoinColumn(name = "fk_fonte_dati")
	private MotiDFonteDati motiDFonteDati;

	// bi-directional many-to-one association to MotiDSettore
	@ManyToOne
	@JoinColumn(name = "fk_settore")
	private MotiDSettore motiDSettore;

	// bi-directional many-to-one association to MotiDStatoAttuaz
	@ManyToOne
	@JoinColumn(name = "fk_stato_attuazione")
	private MotiDStatoAttuaz motiDStatoAttuaz;

	// bi-directional many-to-one association to MotiDTipologia
	@ManyToOne
	@JoinColumn(name = "fk_tipologia")
	private MotiDTipologia motiDTipologia;

	// bi-directional many-to-one association to MotiTUtente
	@ManyToOne
	@JoinColumn(name = "fk_utente_blocco_modifica")
	private MotiTUtente motiTUtenteBloccoModifica;

	// bi-directional many-to-one association to MotiDAttuatore
	@ManyToOne
	@JoinColumn(name = "fk_attuatore")
	private MotiDAttuatore motiDAttuatore;

	public MotiTIntervento() {
	}

	public Integer getIdIntervento() {
		return this.idIntervento;
	}

	public void setIdIntervento(Integer idIntervento) {
		this.idIntervento = idIntervento;
	}

	public String getAttuatore() {
		return this.attuatore;
	}

	public void setAttuatore(String attuatore) {
		this.attuatore = attuatore;
	}

	public String getCig() {
		return this.cig;
	}

	public void setCig(String cig) {
		this.cig = cig;
	}

	public String getCodIntervento() {
		return this.codIntervento;
	}

	public void setCodIntervento(String codIntervento) {
		this.codIntervento = codIntervento;
	}

	public String getCup() {
		return this.cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public Date getDataBloccoModifica() {
		return this.dataBloccoModifica;
	}

	public void setDataBloccoModifica(Date dataBloccoModifica) {
		this.dataBloccoModifica = dataBloccoModifica;
	}

	public String getDescrTecnica() {
		return this.descrTecnica;
	}

	public void setDescrTecnica(String descrTecnica) {
		this.descrTecnica = descrTecnica;
	}

	public String getFonteDatiProgrammazione() {
		return this.fonteDatiProgrammazione;
	}

	public void setFonteDatiProgrammazione(String fonteDatiProgrammazione) {
		this.fonteDatiProgrammazione = fonteDatiProgrammazione;
	}

	public String getFonteDatiRealizzazione() {
		return this.fonteDatiRealizzazione;
	}

	public void setFonteDatiRealizzazione(String fonteDatiRealizzazione) {
		this.fonteDatiRealizzazione = fonteDatiRealizzazione;
	}

	public BigDecimal getIdInterventoOld() {
		return this.idInterventoOld;
	}

	public void setIdInterventoOld(BigDecimal idInterventoOld) {
		this.idInterventoOld = idInterventoOld;
	}

	public String getNoteProgrammazione() {
		return this.noteProgrammazione;
	}

	public void setNoteProgrammazione(String noteProgrammazione) {
		this.noteProgrammazione = noteProgrammazione;
	}

	public String getNoteRealizzazione() {
		return this.noteRealizzazione;
	}

	public void setNoteRealizzazione(String noteRealizzazione) {
		this.noteRealizzazione = noteRealizzazione;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<MotiTInterventoCosti> getMotiTInterventoCostis() {
		return this.motiTInterventoCostis;
	}

	public void setMotiTInterventoCostis(List<MotiTInterventoCosti> motiTInterventoCostis) {
		this.motiTInterventoCostis = motiTInterventoCostis;
	}

	public MotiTInterventoCosti addMotiTInterventoCosti(MotiTInterventoCosti motiTInterventoCosti) {
		getMotiTInterventoCostis().add(motiTInterventoCosti);
		motiTInterventoCosti.setMotiTIntervento(this);

		return motiTInterventoCosti;
	}

	public MotiTInterventoCosti removeMotiTInterventoCosti(MotiTInterventoCosti motiTInterventoCosti) {
		getMotiTInterventoCostis().remove(motiTInterventoCosti);
		motiTInterventoCosti.setMotiTIntervento(null);

		return motiTInterventoCosti;
	}

	public List<MotiTInterventoDatiOti> getMotiTInterventoDatiOtis() {
		return this.motiTInterventoDatiOtis;
	}

	public void setMotiTInterventoDatiOtis(List<MotiTInterventoDatiOti> motiTInterventoDatiOtis) {
		this.motiTInterventoDatiOtis = motiTInterventoDatiOtis;
	}

	public MotiTInterventoDatiOti addMotiTInterventoDatiOti(MotiTInterventoDatiOti motiTInterventoDatiOti) {
		getMotiTInterventoDatiOtis().add(motiTInterventoDatiOti);
		motiTInterventoDatiOti.setMotiTIntervento(this);

		return motiTInterventoDatiOti;
	}

	public MotiTInterventoDatiOti removeMotiTInterventoDatiOti(MotiTInterventoDatiOti motiTInterventoDatiOti) {
		getMotiTInterventoDatiOtis().remove(motiTInterventoDatiOti);
		motiTInterventoDatiOti.setMotiTIntervento(null);

		return motiTInterventoDatiOti;
	}

	public List<MotiRInterventoFase> getMotiRInterventoFases() {
		return this.motiRInterventoFases;
	}

	public void setMotiRInterventoFases(List<MotiRInterventoFase> motiRInterventoFases) {
		this.motiRInterventoFases = motiRInterventoFases;
	}

	public MotiRInterventoFase addMotiRInterventoFas(MotiRInterventoFase motiRInterventoFas) {
		getMotiRInterventoFases().add(motiRInterventoFas);
		motiRInterventoFas.setMotiTIntervento(this);

		return motiRInterventoFas;
	}

	public MotiRInterventoFase removeMotiRInterventoFas(MotiRInterventoFase motiRInterventoFas) {
		getMotiRInterventoFases().remove(motiRInterventoFas);
		motiRInterventoFas.setMotiTIntervento(null);

		return motiRInterventoFas;
	}

	public List<MotiRInterventoFontefin> getMotiRInterventoFontefins() {
		return this.motiRInterventoFontefins;
	}

	public void setMotiRInterventoFontefins(List<MotiRInterventoFontefin> motiRInterventoFontefins) {
		this.motiRInterventoFontefins = motiRInterventoFontefins;
	}

	public MotiRInterventoFontefin addMotiRInterventoFontefin(MotiRInterventoFontefin motiRInterventoFontefin) {
		getMotiRInterventoFontefins().add(motiRInterventoFontefin);
		motiRInterventoFontefin.setMotiTIntervento(this);

		return motiRInterventoFontefin;
	}

	public MotiRInterventoFontefin removeMotiRInterventoFontefin(MotiRInterventoFontefin motiRInterventoFontefin) {
		getMotiRInterventoFontefins().remove(motiRInterventoFontefin);
		motiRInterventoFontefin.setMotiTIntervento(null);

		return motiRInterventoFontefin;
	}

	public List<MotiRInterventoLuogo> getMotiRInterventoLuogos() {
		return this.motiRInterventoLuogos;
	}

	public void setMotiRInterventoLuogos(List<MotiRInterventoLuogo> motiRInterventoLuogos) {
		this.motiRInterventoLuogos = motiRInterventoLuogos;
	}

	public MotiRInterventoLuogo addMotiRInterventoLuogo(MotiRInterventoLuogo motiRInterventoLuogo) {
		getMotiRInterventoLuogos().add(motiRInterventoLuogo);
		motiRInterventoLuogo.setMotiTIntervento(this);

		return motiRInterventoLuogo;
	}

	public MotiRInterventoLuogo removeMotiRInterventoLuogo(MotiRInterventoLuogo motiRInterventoLuogo) {
		getMotiRInterventoLuogos().remove(motiRInterventoLuogo);
		motiRInterventoLuogo.setMotiTIntervento(null);

		return motiRInterventoLuogo;
	}

	public List<MotiRInterventoReferente> getMotiRInterventoReferentes() {
		return this.motiRInterventoReferentes;
	}

	public void setMotiRInterventoReferentes(List<MotiRInterventoReferente> motiRInterventoReferentes) {
		this.motiRInterventoReferentes = motiRInterventoReferentes;
	}

	public MotiRInterventoReferente addMotiRInterventoReferente(MotiRInterventoReferente motiRInterventoReferente) {
		getMotiRInterventoReferentes().add(motiRInterventoReferente);
		motiRInterventoReferente.setMotiTIntervento(this);

		return motiRInterventoReferente;
	}

	public MotiRInterventoReferente removeMotiRInterventoReferente(MotiRInterventoReferente motiRInterventoReferente) {
		getMotiRInterventoReferentes().remove(motiRInterventoReferente);
		motiRInterventoReferente.setMotiTIntervento(null);

		return motiRInterventoReferente;
	}

	public List<MotiRInterventoSituazioneCriticita> getMotiRInterventoSituazioneCriticitas() {
		return this.motiRInterventoSituazioneCriticitas;
	}

	public void setMotiRInterventoSituazioneCriticitas(
			List<MotiRInterventoSituazioneCriticita> motiRInterventoSituazioneCriticitas) {
		this.motiRInterventoSituazioneCriticitas = motiRInterventoSituazioneCriticitas;
	}

	public MotiRInterventoSituazioneCriticita addMotiRInterventoSituazioneCriticita(
			MotiRInterventoSituazioneCriticita motiRInterventoSituazioneCriticita) {
		getMotiRInterventoSituazioneCriticitas().add(motiRInterventoSituazioneCriticita);
		motiRInterventoSituazioneCriticita.setMotiTIntervento(this);

		return motiRInterventoSituazioneCriticita;
	}

	public MotiRInterventoSituazioneCriticita removeMotiRInterventoSituazioneCriticita(
			MotiRInterventoSituazioneCriticita motiRInterventoSituazioneCriticita) {
		getMotiRInterventoSituazioneCriticitas().remove(motiRInterventoSituazioneCriticita);
		motiRInterventoSituazioneCriticita.setMotiTIntervento(null);

		return motiRInterventoSituazioneCriticita;
	}

	public MotiDFonteDati getMotiDFonteDati() {
		return this.motiDFonteDati;
	}

	public void setMotiDFonteDati(MotiDFonteDati motiDFonteDati) {
		this.motiDFonteDati = motiDFonteDati;
	}

	public MotiDSettore getMotiDSettore() {
		return this.motiDSettore;
	}

	public void setMotiDSettore(MotiDSettore motiDSettore) {
		this.motiDSettore = motiDSettore;
	}

	public MotiDStatoAttuaz getMotiDStatoAttuaz() {
		return this.motiDStatoAttuaz;
	}

	public void setMotiDStatoAttuaz(MotiDStatoAttuaz motiDStatoAttuaz) {
		this.motiDStatoAttuaz = motiDStatoAttuaz;
	}

	public MotiDTipologia getMotiDTipologia() {
		return this.motiDTipologia;
	}

	public void setMotiDTipologia(MotiDTipologia motiDTipologia) {
		this.motiDTipologia = motiDTipologia;
	}

	public MotiTUtente getMotiTUtenteBloccoModifica() {
		return this.motiTUtenteBloccoModifica;
	}

	public void setMotiTUtenteBloccoModifica(MotiTUtente motiTUtenteBloccoModifica) {
		this.motiTUtenteBloccoModifica = motiTUtenteBloccoModifica;
	}

	/**
	 * @return the motiDAttuatore
	 */
	public MotiDAttuatore getMotiDAttuatore() {
		return motiDAttuatore;
	}

	/**
	 * @param motiDAttuatore the motiDAttuatore to set
	 */
	public void setMotiDAttuatore(MotiDAttuatore motiDAttuatore) {
		this.motiDAttuatore = motiDAttuatore;
	}

	@Override
	public UUID getOptlock() {
		return this.optlock;
	}

	@Override
	public void setOptlock(UUID id) {
		this.optlock = id;
	}

	@Override
	public void generateNewOptlock() {
		this.optlock = UUID.randomUUID();
	}

}
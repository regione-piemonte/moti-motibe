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
package it.csi.moti.motibe.lib.dto.intervento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import it.csi.moti.motibe.lib.dto.BaseAuditedDto;
import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.Settore;
import it.csi.moti.motibe.lib.dto.decodifiche.StatoAttuaz;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;

/**
 * The Class Intervento.
 */
public class Intervento extends BaseAuditedDto<Integer> implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String attuatore;
	private String cig;
	private String codIntervento;
	private String cup;
	private Date dataBloccoModifica;
	private String descrTecnica;
	private String fonteDatiProgrammazione;
	private String fonteDatiRealizzazione;
	private BigDecimal idInterventoOld;
	private String noteProgrammazione;
	private String noteRealizzazione;
	private String titolo;
	private List<InterventoCosti> interventoCostis;
	private List<InterventoDatiOti> interventoDatiOtis;
	private List<InterventoFase> interventoFases;
	private List<InterventoFontefin> interventoFontefins;
	private List<InterventoLuogo> interventoLuogos;
	private List<InterventoReferente> interventoReferentes;
	private List<InterventoSituazioneCriticita> interventoSituazioneCriticitas;
	private FonteDati fonteDati;
	private Settore settore;
	private StatoAttuaz statoAttuaz;
	private Tipologia tipologia;
	private Utente utenteBloccoModifica;
	private UUID optlock;
	private Attuatore attuatoreObj;

	/**
	 * @return the attuatore
	 */
	public String getAttuatore() {
		return attuatore;
	}

	/**
	 * @param attuatore the attuatore to set
	 */
	public void setAttuatore(String attuatore) {
		this.attuatore = attuatore;
	}

	/**
	 * @return the cig
	 */
	public String getCig() {
		return cig;
	}

	/**
	 * @param cig the cig to set
	 */
	public void setCig(String cig) {
		this.cig = cig;
	}

	/**
	 * @return the codIntervento
	 */
	public String getCodIntervento() {
		return codIntervento;
	}

	/**
	 * @param codIntervento the codIntervento to set
	 */
	public void setCodIntervento(String codIntervento) {
		this.codIntervento = codIntervento;
	}

	/**
	 * @return the cup
	 */
	public String getCup() {
		return cup;
	}

	/**
	 * @param cup the cup to set
	 */
	public void setCup(String cup) {
		this.cup = cup;
	}

	/**
	 * @return the dataBloccoModifica
	 */
	public Date getDataBloccoModifica() {
		return dataBloccoModifica;
	}

	/**
	 * @param dataBloccoModifica the dataBloccoModifica to set
	 */
	public void setDataBloccoModifica(Date dataBloccoModifica) {
		this.dataBloccoModifica = dataBloccoModifica;
	}

	/**
	 * @return the descrTecnica
	 */
	public String getDescrTecnica() {
		return descrTecnica;
	}

	/**
	 * @param descrTecnica the descrTecnica to set
	 */
	public void setDescrTecnica(String descrTecnica) {
		this.descrTecnica = descrTecnica;
	}

	/**
	 * @return the fonteDatiProgrammazione
	 */
	public String getFonteDatiProgrammazione() {
		return fonteDatiProgrammazione;
	}

	/**
	 * @param fonteDatiProgrammazione the fonteDatiProgrammazione to set
	 */
	public void setFonteDatiProgrammazione(String fonteDatiProgrammazione) {
		this.fonteDatiProgrammazione = fonteDatiProgrammazione;
	}

	/**
	 * @return the fonteDatiRealizzazione
	 */
	public String getFonteDatiRealizzazione() {
		return fonteDatiRealizzazione;
	}

	/**
	 * @param fonteDatiRealizzazione the fonteDatiRealizzazione to set
	 */
	public void setFonteDatiRealizzazione(String fonteDatiRealizzazione) {
		this.fonteDatiRealizzazione = fonteDatiRealizzazione;
	}

	/**
	 * @return the idInterventoOld
	 */
	public BigDecimal getIdInterventoOld() {
		return idInterventoOld;
	}

	/**
	 * @param idInterventoOld the idInterventoOld to set
	 */
	public void setIdInterventoOld(BigDecimal idInterventoOld) {
		this.idInterventoOld = idInterventoOld;
	}

	/**
	 * @return the noteProgrammazione
	 */
	public String getNoteProgrammazione() {
		return noteProgrammazione;
	}

	/**
	 * @param noteProgrammazione the noteProgrammazione to set
	 */
	public void setNoteProgrammazione(String noteProgrammazione) {
		this.noteProgrammazione = noteProgrammazione;
	}

	/**
	 * @return the noteRealizzazione
	 */
	public String getNoteRealizzazione() {
		return noteRealizzazione;
	}

	/**
	 * @param noteRealizzazione the noteRealizzazione to set
	 */
	public void setNoteRealizzazione(String noteRealizzazione) {
		this.noteRealizzazione = noteRealizzazione;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the interventoCostis
	 */
	public List<InterventoCosti> getInterventoCostis() {
		return interventoCostis;
	}

	/**
	 * @param interventoCostis the interventoCostis to set
	 */
	public void setInterventoCostis(List<InterventoCosti> interventoCostis) {
		this.interventoCostis = interventoCostis;
	}

	/**
	 * @return the interventoDatiOtis
	 */
	public List<InterventoDatiOti> getInterventoDatiOtis() {
		return interventoDatiOtis;
	}

	/**
	 * @param interventoDatiOtis the interventoDatiOtis to set
	 */
	public void setInterventoDatiOtis(List<InterventoDatiOti> interventoDatiOtis) {
		this.interventoDatiOtis = interventoDatiOtis;
	}

	/**
	 * @return the interventoFases
	 */
	public List<InterventoFase> getInterventoFases() {
		return interventoFases;
	}

	/**
	 * @param interventoFases the interventoFases to set
	 */
	public void setInterventoFases(List<InterventoFase> interventoFases) {
		this.interventoFases = interventoFases;
	}

	/**
	 * @return the interventoFontefins
	 */
	public List<InterventoFontefin> getInterventoFontefins() {
		return interventoFontefins;
	}

	/**
	 * @param interventoFontefins the interventoFontefins to set
	 */
	public void setInterventoFontefins(List<InterventoFontefin> interventoFontefins) {
		this.interventoFontefins = interventoFontefins;
	}

	/**
	 * @return the interventoLuogos
	 */
	public List<InterventoLuogo> getInterventoLuogos() {
		return interventoLuogos;
	}

	/**
	 * @param interventoLuogos the interventoLuogos to set
	 */
	public void setInterventoLuogos(List<InterventoLuogo> interventoLuogos) {
		this.interventoLuogos = interventoLuogos;
	}

	/**
	 * @return the interventoReferentes
	 */
	public List<InterventoReferente> getInterventoReferentes() {
		return interventoReferentes;
	}

	/**
	 * @param interventoReferentes the interventoReferentes to set
	 */
	public void setInterventoReferentes(List<InterventoReferente> interventoReferentes) {
		this.interventoReferentes = interventoReferentes;
	}

	/**
	 * @return the interventoSituazioneCriticitas
	 */
	public List<InterventoSituazioneCriticita> getInterventoSituazioneCriticitas() {
		return interventoSituazioneCriticitas;
	}

	/**
	 * @param interventoSituazioneCriticitas the interventoSituazioneCriticitas to
	 *                                       set
	 */
	public void setInterventoSituazioneCriticitas(List<InterventoSituazioneCriticita> interventoSituazioneCriticitas) {
		this.interventoSituazioneCriticitas = interventoSituazioneCriticitas;
	}

	/**
	 * @return the fonteDati
	 */
	public FonteDati getFonteDati() {
		return fonteDati;
	}

	/**
	 * @param fonteDati the fonteDati to set
	 */
	public void setFonteDati(FonteDati fonteDati) {
		this.fonteDati = fonteDati;
	}

	/**
	 * @return the settore
	 */
	public Settore getSettore() {
		return settore;
	}

	/**
	 * @param settore the settore to set
	 */
	public void setSettore(Settore settore) {
		this.settore = settore;
	}

	/**
	 * @return the statoAttuaz
	 */
	public StatoAttuaz getStatoAttuaz() {
		return statoAttuaz;
	}

	/**
	 * @param statoAttuaz the statoAttuaz to set
	 */
	public void setStatoAttuaz(StatoAttuaz statoAttuaz) {
		this.statoAttuaz = statoAttuaz;
	}

	/**
	 * @return the tipologia
	 */
	public Tipologia getTipologia() {
		return tipologia;
	}

	/**
	 * @param tipologia the tipologia to set
	 */
	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	/**
	 * @return the utenteBloccoModifica
	 */
	public Utente getUtenteBloccoModifica() {
		return utenteBloccoModifica;
	}

	/**
	 * @param utenteBloccoModifica the utenteBloccoModifica to set
	 */
	public void setUtenteBloccoModifica(Utente utenteBloccoModifica) {
		this.utenteBloccoModifica = utenteBloccoModifica;
	}

	/**
	 * @return the attuatoreObj
	 */
	public Attuatore getAttuatoreObj() {
		return attuatoreObj;
	}

	/**
	 * @param attuatoreObj the attuatoreObj to set
	 */
	public void setAttuatoreObj(Attuatore attuatoreObj) {
		this.attuatoreObj = attuatoreObj;
	}

	/**
	 * @return the optlock
	 */
	public UUID getOptlock() {
		return optlock;
	}

	/**
	 * @param optlock the optlock to set
	 */
	public void setOptlock(UUID optlock) {
		this.optlock = optlock;
	}

}

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
package it.csi.moti.motibe.ejb.business.be.service.impl.intervento;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.request.intervento.GetEsportaInterventoRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.intervento.GetEsportaInterventoResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.ejb.util.mime.MimeTypeContainer;
import it.csi.moti.motibe.lib.dto.error.CoreError;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.InterventoCosti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoDatiOti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFase;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFontefin;
import it.csi.moti.motibe.lib.dto.intervento.InterventoLuogo;
import it.csi.moti.motibe.lib.dto.intervento.InterventoReferente;
import it.csi.moti.motibe.lib.dto.intervento.InterventoSituazioneCriticita;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * GetEsportaIntervento
 */
public class GetEsportaInterventoService
		extends BaseInterventoService<GetEsportaInterventoRequest, GetEsportaInterventoResponse> {

	final static private int NUMERO_CELLE_SEZIONI = 5;

	private int rowNumber = 0;
	private final SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
	private Integer iFinanziamento = 0;

	private Font fontBold = null;
	private Font fontNormal = null;

	private CellStyle styleSection = null;
	private CellStyle styleSubSection = null;
	private CellStyle styleSubSectionHeaders = null;
	private CellStyle styleFieldName = null;
	private CellStyle styleFieldValue = null;
	private CellStyle styleFieldValueGray = null;

	/**
	 * Constructor
	 * 
	 * @param configurationHelper the helper for the configuration
	 * @param interventoDad       the DAD for the intervento
	 */
	public GetEsportaInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	@Override
	protected void execute() {
		Intervento intervento = interventoDad.getIntervento(request.getId());

		// creo report excel
		byte[] bytes = createExcel(intervento);
		final String fileName = "export_intervento_" + intervento.getCodIntervento();
		final String formatFile = "xlsx";

		response.setMimeTypeContainer(MimeTypeContainer.byExtension(formatFile));
		response.setBytes(bytes);
		response.setFileName(fileName);
	}

	public byte[] createExcel(Intervento intervento) {
		final String methodName = "createExcel";
		try (Workbook wb = new XSSFWorkbook()) {
			Sheet sheet = wb.createSheet("Foglio1");

			// print setup
			sheet.getPrintSetup().setLandscape(true);
			sheet.setFitToPage(true);
			sheet.setAutobreaks(true); // a capo

			PrintSetup ps = sheet.getPrintSetup();
			ps.setFitWidth((short) 1);
			ps.setFitHeight((short) 0);

			// larghezza colonne
			sheet.setColumnWidth(0, 10 * 256); // numero caratteri * 256
			for (int i = 1; i < NUMERO_CELLE_SEZIONI; i++) {
				sheet.setColumnWidth(i, 43 * 256);
				// sheet.autoSizeColumn(0); // non funziona bene
			}

			initStyles(wb);

			// Create a row and put some cells in it. Rows are 0 based.
			addRowSection("Scheda intervento", sheet, styleSection);
			addRowNameValue("Titolo", intervento.getTitolo(), sheet, styleFieldName, styleFieldValue, true);
			addRowNameValue("Codice", intervento.getCodIntervento(), sheet, styleFieldName, styleFieldValue);
			addRowNameValue("Fonte dati", intervento.getFonteDati().getDescrizione(), sheet, styleFieldName,
					styleFieldValue);

			addSectionDatiGenerali(intervento, sheet);
			addSectionStatiAttuazione(intervento, sheet);
			addSectionCriticitàCostiFinanziamenti(intervento, sheet);
			addSectionDatiOti(intervento, sheet);

			// Write the output to a file
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			byte[] bs = os.toByteArray();
			return bs;

		} catch (IOException e) {
			log.error(methodName, "Error: " + e.getMessage(), e);
			checkBusinessCondition(false, CoreError.SYSTEM_ERROR.getError("error", e.getMessage()));
		}
		return null;
	}

	/**
	 * Attenzione a non usare classe del package java.awt (es.
	 * java.lang.NoClassDefFoundError: Could not initialize class java.awt.Color)
	 * 
	 * @param codeColor
	 * @return
	 */
	private XSSFColor getRGB(String codeColor) {
		Integer intval = Integer.decode(codeColor);
		int i = intval.intValue();
		// return new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF);

		int red = (i >> 16) & 0xFF; // red
		int green = (i >> 8) & 0xFF; // green
		int blue = (i) & 0xFF; // blue

		byte[] rgb = new byte[3];
		rgb[0] = (byte) red; // red
		rgb[1] = (byte) green; // green
		rgb[2] = (byte) blue; // blue
		XSSFColor myColor = new XSSFColor(rgb, new DefaultIndexedColorMap()); // #f2dcdb
		return myColor;
	}

	private void initStyles(Workbook wb) {
		XSSFColor xssfColorSection = getRGB("#006CB4");
		XSSFColor xssfColorSubSection = getRGB("#178CD6");
		XSSFColor xssfColorSubSectionHeaders = getRGB("#03A9F4");
		XSSFColor xssfColorValueLista = getRGB("#E5F1FC");

		// Create a new font and alter it.
		Font fontBoldWhite = wb.createFont();
		fontBoldWhite.setFontHeightInPoints((short) 12);
		fontBoldWhite.setFontName("Courier New");
		fontBoldWhite.setBold(true);
		fontBoldWhite.setColor(IndexedColors.WHITE.getIndex());

		fontBold = wb.createFont();
		fontBold.setFontHeightInPoints((short) 12);
		fontBold.setFontName("Courier New");
		fontBold.setBold(true);

		fontNormal = wb.createFont();
		fontNormal.setFontHeightInPoints((short) 12);
		fontNormal.setFontName("Courier New");
		fontNormal.setBold(false);

		styleSection = wb.createCellStyle();
		styleSection.setFont(fontBoldWhite);
		((XSSFCellStyle) styleSection).setFillBackgroundColor(xssfColorSection);
		((XSSFCellStyle) styleSection).setFillForegroundColor(xssfColorSection);
		styleSection.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		styleSubSection = wb.createCellStyle();
		styleSubSection.setFont(fontBoldWhite);
		((XSSFCellStyle) styleSubSection).setFillBackgroundColor(xssfColorSubSection);
		((XSSFCellStyle) styleSubSection).setFillForegroundColor(xssfColorSubSection);
		styleSubSection.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleSubSection.setAlignment(HorizontalAlignment.CENTER);

		styleSubSectionHeaders = wb.createCellStyle();
		styleSubSectionHeaders.setFont(fontBold);
		((XSSFCellStyle) styleSubSectionHeaders).setFillBackgroundColor(xssfColorSubSectionHeaders);
		((XSSFCellStyle) styleSubSectionHeaders).setFillForegroundColor(xssfColorSubSectionHeaders);
		styleSubSectionHeaders.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleSubSectionHeaders.setAlignment(HorizontalAlignment.CENTER);

		styleFieldName = wb.createCellStyle();
		styleFieldName.setFont(fontBold);
		styleFieldName.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		styleFieldName.setVerticalAlignment(VerticalAlignment.TOP);
		// styleFieldName.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldName.setFillPattern(FillPatternType.BIG_SPOTS);

		styleFieldValue = wb.createCellStyle();
		styleFieldValue.setFont(fontNormal);
		styleFieldValue.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		styleFieldValue.setShrinkToFit(true);
		styleFieldValue.setWrapText(true);
		styleFieldValue.setVerticalAlignment(VerticalAlignment.TOP);
		// styleFieldValue.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldValue.setFillPattern(FillPatternType.BIG_SPOTS);

		styleFieldValueGray = wb.createCellStyle();
		styleFieldValueGray.setFont(fontNormal);
		((XSSFCellStyle) styleFieldValueGray).setFillBackgroundColor(xssfColorValueLista);
		((XSSFCellStyle) styleFieldValueGray).setFillForegroundColor(xssfColorValueLista);
		styleFieldValueGray.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleFieldValueGray.setShrinkToFit(true);
		styleFieldValueGray.setWrapText(true);
		styleFieldValueGray.setVerticalAlignment(VerticalAlignment.TOP);
		// styleFieldValue.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldValue.setFillPattern(FillPatternType.BIG_SPOTS);

	}

	private void addSectionDatiGenerali(Intervento intervento, Sheet sheet) {
		addRowEmpty(sheet);
		addRowSection("Dati generali", sheet, styleSection);

		String referente = intervento.getInterventoReferentes().stream().map(InterventoReferente::getUtente)
				.map(u -> u.getCognome().concat(" ").concat(u.getNome())).collect(Collectors.joining(","));
		addRowNameValue("Referente", referente, sheet, styleFieldName, styleFieldValue);

		addRowNameValue("Settore", intervento.getSettore().getDescrizione(), sheet, styleFieldName, styleFieldValue);

		// addRowNameValue("Attuatore", intervento.getAttuatore(), sheet,
		// styleFieldName, styleFieldValue);
		String attuatore = "";
		if (intervento.getAttuatoreObj() != null) {
			attuatore += intervento.getAttuatoreObj().getDescrizione();
			if (!StringUtils.isBlank(intervento.getAttuatoreObj().getCodiceFiscale())) {
				attuatore += " - " + intervento.getAttuatoreObj().getCodiceFiscale();
			}
		}
		addRowNameValue("Attuatore", attuatore, sheet, styleFieldName, styleFieldValue);

		addRowNameValue("Tipologia", intervento.getTipologia().getDescrizione(), sheet, styleFieldName,
				styleFieldValue);

		String luogo = intervento.getInterventoLuogos().stream().map(InterventoLuogo::getLuogo)
				.map(Luogo::getDenomLuogo).collect(Collectors.joining(","));
		addRowNameValue("Luogo", luogo, sheet, styleFieldName, styleFieldValue);

		addRowNameValue("CUP", intervento.getCup(), sheet, styleFieldName, styleFieldValue);
		addRowNameValue("CIG", intervento.getCig(), sheet, styleFieldName, styleFieldValue);
		Row row = addRowNameValue("Descrizione tecnica", intervento.getDescrTecnica(), sheet, styleFieldName,
				styleFieldValue, true);
	}

	private void addSectionStatiAttuazione(Intervento intervento, Sheet sheet) {
		addRowEmpty(sheet);
		addRowSection("Stato di attuazione", sheet, styleSection);
		addRowNameValue("Stato", intervento.getStatoAttuaz().getDescrizione(), sheet, styleFieldName, styleFieldValue);

		// programmazione
		addRowSubSection("Fasi programmazione", sheet, styleSubSection);
		addRowSubSectionHeaders(new String[] { "Fase", "Data fine prevista", "Data fine effettiva" }, sheet,
				styleSubSectionHeaders);
		List<InterventoFase> listFaseProgrammazione = intervento.getInterventoFases().stream()
				.filter(f -> f.getFase().getTipologia().equals("Programmazione")).collect(Collectors.toList());
		listFaseProgrammazione.stream().forEach(f -> {
			addRowSubSectionValues(new String[] { f.getFase().getDescrizione(), formatData(f.getDataPrevista()),
					formatData(f.getDataEffettiva()) }, sheet, styleFieldValue);
		});

		addRowEmpty(sheet);
		addRowNameValue("Fonte dati programmazione", intervento.getFonteDatiProgrammazione(), sheet, styleFieldName,
				styleFieldValue);
		addRowNameValue("Note programmazione", intervento.getNoteProgrammazione(), sheet, styleFieldName,
				styleFieldValue, true);
		addRowEmpty(sheet);

		// realizzazione
		addRowSubSection("Fasi realizzazione", sheet, styleSubSection);
		addRowSubSectionHeaders(new String[] { "Fase", "Data fine prevista", "Data fine effettiva" }, sheet,
				styleSubSectionHeaders);
		List<InterventoFase> listFaseRealizzazione = intervento.getInterventoFases().stream()
				.filter(f -> f.getFase().getTipologia().equals("Realizzazione")).collect(Collectors.toList());
		listFaseRealizzazione.stream().forEach(f -> {
			addRowSubSectionValues(new String[] { f.getFase().getDescrizione(), formatData(f.getDataPrevista()),
					formatData(f.getDataEffettiva()) }, sheet, styleFieldValue);
		});

		addRowEmpty(sheet);
		addRowNameValue("Fonte dati realizzazione", intervento.getFonteDatiRealizzazione(), sheet, styleFieldName,
				styleFieldValue);
		addRowNameValue("Note realizzazione", intervento.getNoteRealizzazione(), sheet, styleFieldName, styleFieldValue,
				true);
	}

	private void addSectionCriticitàCostiFinanziamenti(Intervento intervento, Sheet sheet) {
		addRowEmpty(sheet);
		addRowSection("Criticità / Costi / Finanziamenti", sheet, styleSection);

		addRowSubSection("Criticità", sheet, styleSubSection);
		addRowSubSectionHeaders(new String[] { "Situazione", "Tipo", "Descrizione" }, sheet, styleSubSectionHeaders);

		List<InterventoSituazioneCriticita> listInterventoSituazioneCriticita = intervento
				.getInterventoSituazioneCriticitas().stream().collect(Collectors.toList());
		listInterventoSituazioneCriticita.stream()
				.sorted(Comparator.comparing(InterventoSituazioneCriticita::getSituazioneCriticitaDescrizione))
				.forEach(f -> {
					addRowSubSectionValues(new String[] { f.getSituazioneCriticita().getDescrizione(),
							f.getTipoCriticita() != null ? f.getTipoCriticita().getDescrizioneTipoCriticita() : "",
							f.getDescrizione() }, sheet, styleFieldValue);
				});

		addRowEmpty(sheet);
		addRowSubSection("Costi", sheet, styleSubSection);
		if (intervento.getInterventoCostis().size() > 0) {
			InterventoCosti interventoCosti = intervento.getInterventoCostis().get(0);
			addRowNameValue("Costo previsto", formatBigdecimal(interventoCosti.getCostoPrevisto()), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Fonte di riferimento", interventoCosti.getFonteRiferimento(), sheet, styleFieldName,
					styleFieldValue);
			addRowNameValue("Fonte dati", interventoCosti.getFonteDati(), sheet, styleFieldName, styleFieldValue);
			addRowNameValue("Data ultima liquidazione", formatData(interventoCosti.getDataUltimaLiquidazione()), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Note economiche", interventoCosti.getNoteEconomiche(), sheet, styleFieldName,
					styleFieldValue, true);
		}

		addRowEmpty(sheet);
		addRowSubSection("Finanziamenti", sheet, styleSubSection);
		addRowSubSectionHeaders(
				new String[] { "Fonte finanziamento", "Descrizione", "Importo stanziato", "Importo liquidato" }, sheet,
				styleSubSectionHeaders);

		List<InterventoFontefin> listInterventoFontefins = intervento.getInterventoFontefins().stream()
				.collect(Collectors.toList());

		listInterventoFontefins.stream().forEach(f -> {
			iFinanziamento++;
			CellStyle cellStyle = null;
			if (iFinanziamento % 2 == 1) {
				cellStyle = styleFieldValue;
			} else {
				cellStyle = styleFieldValueGray;
			}

			addRowSubSectionValues(
					new String[] { f.getFonteFinanziamento().getDescrizione(), f.getDescrizione(),
							formatBigdecimal(f.getImportoStanziato()), formatBigdecimal(f.getImportoLiquidato()) },
					sheet, cellStyle);
			if (!StringUtils.isBlank(f.getNote())) {

				XSSFRichTextString richString = new XSSFRichTextString("Note: " + f.getNote());
				richString.applyFont(0, 5, fontBold);
				richString.applyFont(5, richString.getString().length(), fontNormal);

				addRowNameValue("", richString, sheet, cellStyle, cellStyle, true);
			}
		});
	}

	private void addSectionDatiOti(Intervento intervento, Sheet sheet) {
		if (intervento.getInterventoDatiOtis().size() > 0) {
			InterventoDatiOti interventoDatiOti = intervento.getInterventoDatiOtis().get(0);

			addRowEmpty(sheet);
			addRowSection("Dati OTI", sheet, styleSection);

			addRowNameValue("Data ultimo aggiornamento", formatData(interventoDatiOti.getDataUltimoAggiornamento()),
					sheet, styleFieldName, styleFieldValue);
			addRowNameValue("Soggetti coinvolti", interventoDatiOti.getSoggettiCoinvolti(), sheet, styleFieldName,
					styleFieldValue);

			addRowEmpty(sheet);
			addRowSubSection("Dettaglio progetto", sheet, styleSubSection);

			addRowNameValue("Descrizione progettazione", interventoDatiOti.getDescrizioneProgettazione(), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Dettagli prossima fase", interventoDatiOti.getDettagliProssimaFase(), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Dettaglio costi", interventoDatiOti.getDettaglioCosti(), sheet, styleFieldName,
					styleFieldValue);

			addRowEmpty(sheet);
			addRowSubSection("Cronoprogramma", sheet, styleSubSection);

			addRowNameValue("Anno inizio lavori", interventoDatiOti.getAnnoInizioLavori().toString(), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Anno prossima fase", interventoDatiOti.getAnnoProssimaFase().toString(), sheet,
					styleFieldName, styleFieldValue);
			addRowNameValue("Anno ultimazione opera", interventoDatiOti.getAnnoUltimazioneOpera().toString(), sheet,
					styleFieldName, styleFieldValue);

			addRowEmpty(sheet);
			addRowSubSection("Finanziamenti", sheet, styleSubSection);

			addRowNameValue("Finanziamenti disponibili",
					formatBigdecimal(interventoDatiOti.getFinanziamentiDisponibili()), sheet, styleFieldName,
					styleFieldValue);
			addRowNameValue("Finanziamenti non disponibili",
					formatBigdecimal(interventoDatiOti.getFinanziamentiNonDisponibili()), sheet, styleFieldName,
					styleFieldValue);
		}
	}

	private String formatData(Date date) {
		if (date != null) {
			return sdfData.format(date);
		}
		return "";
	}

	private void addRowEmpty(Sheet sheet) {
		Row row = sheet.createRow(rowNumber);
		rowNumber++;
	}

	private void addRowSection(String value, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);
		Cell cell0 = row.createCell(0);
		cell0.setCellValue(value);
		cell0.setCellStyle(style);

		for (int i = 1; i < NUMERO_CELLE_SEZIONI; i++) {
			Cell cell1 = row.createCell(i);
			cell1.setCellValue("");
			cell1.setCellStyle(style);
		}

		sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber, 0, NUMERO_CELLE_SEZIONI - 1));
		rowNumber++;
	}

	private void addRowSubSection(String value, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);
		Cell cell1 = row.createCell(1);
		cell1.setCellValue(value);
		cell1.setCellStyle(style);

		for (int i = 2; i < NUMERO_CELLE_SEZIONI; i++) {
			Cell cell2 = row.createCell(i);
			cell2.setCellValue("");
			cell2.setCellStyle(style);
		}

		sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber, 1, NUMERO_CELLE_SEZIONI - 1));
		rowNumber++;
	}

	private void addRowSubSectionHeaders(String[] values, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);
		final int columnStart = 1;

		for (int i = 0; i < values.length; i++) {
			String value = values[i];

			Cell cell1 = row.createCell(columnStart + i);
			cell1.setCellValue(value);
			cell1.setCellStyle(style);
		}

		rowNumber++;
	}

	private void addRowSubSectionValues(String[] values, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);
		final int columnStart = 1;

		for (int i = 0; i < values.length; i++) {
			String value = values[i];

			Cell cell1 = row.createCell(columnStart + i);
			cell1.setCellValue(value);
			cell1.setCellStyle(style);
		}

		rowNumber++;
	}

	private Row addRowNameValue(String name, String value, Sheet sheet, CellStyle styleFieldName,
			CellStyle styleFieldValue) {
		return addRowNameValue(name, value, sheet, styleFieldName, styleFieldValue, false);
	}

	private Row addRowNameValue(String name, String value, Sheet sheet, CellStyle styleFieldName,
			CellStyle styleFieldValue, boolean adjustHeight) {
		return addRowNameValue(name, new XSSFRichTextString(value), sheet, styleFieldName, styleFieldValue,
				adjustHeight);
	}

	private Row addRowNameValue(String name, RichTextString value, Sheet sheet, CellStyle styleFieldName,
			CellStyle styleFieldValue, boolean adjustHeight) {
		Row rowField = sheet.createRow(rowNumber);
		if (adjustHeight && value != null && value.getString() != null) {

			// stime delle righe per valorizzare l'altezza della cella
			int numRighe = 0;
			String[] righe = value.getString().split("\n"); // a volte la stringa ha degli "a capo"
			for (int i = 0; i < righe.length; i++) {
				if (righe[i].length() > 88) {
					numRighe += (righe[i].length() / 82) + 1; // caratteri per riga
				} else {
					numRighe++;
				}
			}

			rowField.setHeight((short) (numRighe * 320));
		}

		Cell cellName = rowField.createCell(1);
		cellName.setCellValue(name);
		cellName.setCellStyle(styleFieldName);

		Cell cellValue2 = rowField.createCell(2);
		cellValue2.setCellValue(value);
		cellValue2.setCellStyle(styleFieldValue);

		Cell cellValue3 = rowField.createCell(3);
		cellValue3.setCellValue(value);
		cellValue3.setCellStyle(styleFieldValue);

		sheet.addMergedRegion(new CellRangeAddress(rowNumber, rowNumber, 2, NUMERO_CELLE_SEZIONI - 1));

		rowNumber++;

		return rowField;
	}

}

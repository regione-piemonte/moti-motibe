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
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import it.csi.moti.motibe.ejb.business.be.dad.InterventoDad;
import it.csi.moti.motibe.ejb.business.be.service.request.base.BaseRequest;
import it.csi.moti.motibe.ejb.business.be.service.response.base.BaseResponse;
import it.csi.moti.motibe.ejb.util.conf.ConfigurationHelper;
import it.csi.moti.motibe.lib.dto.error.CoreError;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.InterventoLuogo;
import it.csi.moti.motibe.lib.dto.intervento.InterventoReferente;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;

/**
 * Base service implementation for the intervento
 * 
 * @param <Q> the request type
 * @param <R> the response type
 */
public abstract class BaseEsportaInterventoService<Q extends BaseRequest, R extends BaseResponse>
		extends BaseInterventoService<Q, R> {

	private int rowNumber = 0;
	final int columnStart = 0;

	private CellStyle styleSubSectionHeaders = null;
	private CellStyle styleFieldName = null;
	private CellStyle styleFieldValue = null;
	private CellStyle styleFieldValueRight = null;

	protected BaseEsportaInterventoService(ConfigurationHelper configurationHelper, InterventoDad interventoDad) {
		super(configurationHelper, interventoDad);
	}

	public byte[] createExcel(List<Intervento> interventos) {
		final String methodName = "createExcel";

		try (Workbook wb = new XSSFWorkbook()) {
			initStyles(wb);
			Sheet sheet = wb.createSheet("Foglio1");

			// print setup
			sheet.getPrintSetup().setLandscape(true);
			sheet.setFitToPage(true);
			sheet.setAutobreaks(true); // a capo

			PrintSetup ps = sheet.getPrintSetup();
			ps.setFitWidth((short) 1);
			ps.setFitHeight((short) 0);

			final String[] headers = new String[] { "Fonte", "Codice", "Titolo", "Stato", "Tipologia", "Costo", "Luogo",
					"Referente", "Criticità" };
			final int[] headersCharLength = new int[] { 20, 15, 55, 30, 30, 25, 35, 41, 15 };

			for (int i = 0; i < headers.length; i++) {
				// numero caratteri * 256
				sheet.setColumnWidth(i, headersCharLength[i] * 256);
			}

			addRowSubSectionHeaders(headers, sheet, styleSubSectionHeaders);

			for (Intervento intervento : interventos) {

				final StringBuilder sbCosto = new StringBuilder();
				intervento.getInterventoCostis().stream().forEach(f -> {
					sbCosto.append(formatBigdecimal(f.getCostoPrevisto()));
				});

				String luogo = intervento.getInterventoLuogos().stream().map(InterventoLuogo::getLuogo)
						.map(Luogo::getDenomLuogo).collect(Collectors.joining(","));

				String referente = intervento.getInterventoReferentes().stream().map(InterventoReferente::getUtente)
						.map(u -> u.getCognome().concat(" ").concat(u.getNome())).collect(Collectors.joining(","));

				addRowSubSectionValues(
						new Object[] { intervento.getFonteDati().getDescrizione(), intervento.getCodIntervento(),
								intervento.getTitolo(), intervento.getStatoAttuaz().getDescrizione(),
								intervento.getTipologia().getDescrizione(),
								new CellValueStyle(sbCosto.toString(), styleFieldValueRight), luogo, referente,
								intervento.getInterventoSituazioneCriticitas().size() > 0 ? "Si" : "No" },
						sheet, styleFieldValue);
			}

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

		// Create a new font and alter it.
		Font fontBold = wb.createFont();
		fontBold.setFontHeightInPoints((short) 12);
		fontBold.setFontName("Courier New");
		fontBold.setBold(true);

		// Create a new font and alter it.
		Font fontBoldWhite = wb.createFont();
		fontBoldWhite.setFontHeightInPoints((short) 12);
		fontBoldWhite.setFontName("Courier New");
		fontBoldWhite.setBold(true);
		fontBoldWhite.setColor(IndexedColors.WHITE.getIndex());

		Font fontNormal = wb.createFont();
		fontNormal.setFontHeightInPoints((short) 12);
		fontNormal.setFontName("Courier New");
		fontNormal.setBold(false);

		styleSubSectionHeaders = wb.createCellStyle();
		styleSubSectionHeaders.setFont(fontBoldWhite);
		((XSSFCellStyle) styleSubSectionHeaders).setFillBackgroundColor(xssfColorSection);
		((XSSFCellStyle) styleSubSectionHeaders).setFillForegroundColor(xssfColorSection);
		styleSubSectionHeaders.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		styleSubSectionHeaders.setAlignment(HorizontalAlignment.CENTER);

		styleFieldName = wb.createCellStyle();
		styleFieldName.setFont(fontBold);
		styleFieldName.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		// styleFieldName.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldName.setFillPattern(FillPatternType.BIG_SPOTS);

		styleFieldValue = wb.createCellStyle();
		styleFieldValue.setFont(fontNormal);
		styleFieldValue.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		// styleFieldValue.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldValue.setFillPattern(FillPatternType.BIG_SPOTS);
		styleFieldValue.setShrinkToFit(true);
		styleFieldValue.setWrapText(true);
		styleFieldValue.setVerticalAlignment(VerticalAlignment.TOP);

		styleFieldValueRight = wb.createCellStyle();
		styleFieldValueRight.setFont(fontNormal);
		styleFieldValueRight.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
		styleFieldValueRight.setAlignment(HorizontalAlignment.RIGHT);
		// styleFieldValue.setFillForegroundColor(IndexedColors.BLACK.getIndex());
		// styleFieldValue.setFillPattern(FillPatternType.BIG_SPOTS);
		styleFieldValueRight.setShrinkToFit(true);
		styleFieldValueRight.setWrapText(true);
		styleFieldValueRight.setVerticalAlignment(VerticalAlignment.TOP);
	}

	private void addRowSubSectionHeaders(String[] values, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);

		for (int i = 0; i < values.length; i++) {
			String value = values[i];

			Cell cell1 = row.createCell(columnStart + i);
			cell1.setCellValue(value);
			cell1.setCellStyle(style);
		}

		rowNumber++;
	}

	private void addRowSubSectionValues(Object[] values, Sheet sheet, CellStyle style) {
		Row row = sheet.createRow(rowNumber);

		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof CellValueStyle) {
				CellValueStyle cellValueStyle = (CellValueStyle) values[i];

				Cell cell1 = row.createCell(columnStart + i);
				cell1.setCellValue(cellValueStyle.getValue());
				cell1.setCellStyle(cellValueStyle.getCellStyle());

			} else {
				String value = (String) values[i];

				Cell cell1 = row.createCell(columnStart + i);
				cell1.setCellValue(value);
				cell1.setCellStyle(style);
			}
		}

		rowNumber++;
	}

}

class CellValueStyle {
	private String value;
	private CellStyle cellStyle;

	public CellValueStyle(String value, CellStyle cellStyle) {
		super();
		this.value = value;
		this.cellStyle = cellStyle;
	}

	public String getValue() {
		return value;
	}

	public CellStyle getCellStyle() {
		return cellStyle;
	}

}

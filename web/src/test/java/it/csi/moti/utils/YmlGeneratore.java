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
package it.csi.moti.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Set;
import java.util.UUID;

import it.csi.moti.motibe.lib.dto.Utente;
import it.csi.moti.motibe.lib.dto.decodifiche.Attuatore;
import it.csi.moti.motibe.lib.dto.decodifiche.Fase;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteDati;
import it.csi.moti.motibe.lib.dto.decodifiche.FonteFinanziamento;
import it.csi.moti.motibe.lib.dto.decodifiche.Ruolo;
import it.csi.moti.motibe.lib.dto.decodifiche.Settore;
import it.csi.moti.motibe.lib.dto.decodifiche.SituazioneCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.StatoAttuaz;
import it.csi.moti.motibe.lib.dto.decodifiche.TipoCriticita;
import it.csi.moti.motibe.lib.dto.decodifiche.Tipologia;
import it.csi.moti.motibe.lib.dto.intervento.Intervento;
import it.csi.moti.motibe.lib.dto.intervento.InterventoCosti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoDatiOti;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFase;
import it.csi.moti.motibe.lib.dto.intervento.InterventoFontefin;
import it.csi.moti.motibe.lib.dto.intervento.InterventoLuogo;
import it.csi.moti.motibe.lib.dto.intervento.InterventoReferente;
import it.csi.moti.motibe.lib.dto.intervento.InterventoSituazioneCriticita;
import it.csi.moti.motibe.lib.dto.intervento.Luogo;
import it.csi.moti.motibe.lib.dto.intervento.RicercaIntervento;

public class YmlGeneratore {
	// final static String PATH_ROOT = "D:\\workspace-moti\\motibe\\docs\\definitions";
	final static String PATH_ROOT = "..\\docs\\definitions";

	final static String PATH_SYSTEM = PATH_ROOT + "\\system";
	final static String PATH_DECODIFICA = PATH_ROOT + "\\decodifica";
	final static String PATH_INTERVENTO = PATH_ROOT + "\\intervento";
	final static String PATH_COMMON = PATH_ROOT + "\\common";

	final static Class pkClassDefault = Integer.class;
	final static String ACAPO = "\n";

	public static void main(String[] args) {
		try {
			// oggetti system
			go(Utente.class, PATH_SYSTEM);
			
			// oggetti decodifica
			go(Fase.class, PATH_DECODIFICA);
			go(FonteDati.class, PATH_DECODIFICA);
			go(FonteFinanziamento.class, PATH_DECODIFICA);
			go(Ruolo.class, PATH_DECODIFICA);
			go(Settore.class, PATH_DECODIFICA);
			go(SituazioneCriticita.class, PATH_DECODIFICA);
			go(StatoAttuaz.class, PATH_DECODIFICA);
			go(TipoCriticita.class, PATH_DECODIFICA);
			go(Tipologia.class, PATH_DECODIFICA);
			go(Attuatore.class, PATH_DECODIFICA);

			// oggetti intervento
			go(Intervento.class, PATH_INTERVENTO);
			go(InterventoCosti.class, PATH_INTERVENTO);
			go(InterventoDatiOti.class, PATH_INTERVENTO);
			go(InterventoFase.class, PATH_INTERVENTO);
			go(InterventoFontefin.class, PATH_INTERVENTO);
			go(InterventoLuogo.class, PATH_INTERVENTO);
			go(InterventoReferente.class, PATH_INTERVENTO);
			go(InterventoSituazioneCriticita.class, PATH_INTERVENTO);

			go(RicercaIntervento.class, PATH_INTERVENTO);
			
			// oggetti common
			go(Luogo.class, PATH_COMMON);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void go(Class objClass, String path) throws FileNotFoundException, IOException {
		go(objClass, path, pkClassDefault);
	}

	private static void go(Class objClass, String path, Class pkClass) throws FileNotFoundException, IOException {
		StringBuilder sbOut = new StringBuilder();
		sbOut.append(objClass.getSimpleName() + ":" + ACAPO);
		sbOut.append("  type: object" + ACAPO);
		sbOut.append("  properties:" + ACAPO);

		Hashtable<String, String> hstProperies = new Hashtable<String, String>();

		// Get the public methods associated with this class.
		Method[] methods = objClass.getMethods();
		for (Method method : methods) {
			// System.out.println("Public method found: " + method.toString());
			if (method.getName().startsWith("get")) {
				System.out.println(method.getReturnType() + " - " + method.getName());
				String property = method.getName().substring(3, method.getName().length());
				property = property.substring(0, 1).toLowerCase() + property.substring(1);

				StringBuilder sb = new StringBuilder();
				if (method.getReturnType().getCanonicalName().equals("java.util.UUID")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: string" + ACAPO);
					sb.append("      format: uuid" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.lang.Object")) {
					sb.append("    " + property + ":" + ACAPO);
					if (pkClass != null && pkClass.equals(UUID.class)) {
						sb.append("      type: string" + ACAPO);
						sb.append("      format: uuid" + ACAPO);
					} else {
						sb.append("      type: integer" + ACAPO);
					}

				} else if (method.getReturnType().getCanonicalName().equals("java.lang.String")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: string" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.util.Date")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: string" + ACAPO);
					sb.append("      format: date-time" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.math.BigDecimal")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: number" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.lang.Boolean")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: integer" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.lang.Integer")) {
					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: integer" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().equals("java.util.List")) {
					String objName = method.getGenericReturnType().getTypeName();
					int iDot = objName.lastIndexOf(".");
					objName = objName.substring(iDot + 1, objName.length());

					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: array" + ACAPO);
					sb.append("      items:  " + ACAPO);
					sb.append("        $ref: '#/definitions/" + objName + "'" + ACAPO);

				} else if (method.getReturnType().getCanonicalName().startsWith("it.csi.moti.motibe.lib.dto.")) {
					int iDot = method.getReturnType().getCanonicalName().lastIndexOf(".");
					String objName = method.getReturnType().getCanonicalName().substring(iDot + 1);
					// objName = objName.substring(0, 1).toLowerCase() + objName.substring(1);

					sb.append("    " + property + ":" + ACAPO);
					sb.append("      type: object" + ACAPO);
					sb.append("      $ref: '#/definitions/" + objName + "'" + ACAPO);

				} else {
					if (!property.equals("class")) {
						System.out.println("DA GESTIRE");
					}
				}

				if (!sb.toString().trim().equals("")) {
					hstProperies.put(property, sb.toString());
				}
			}
		}

		System.out.println("-----------------");
		// ordinamento properties
		Set<String> setProperties = hstProperies.keySet();
		ArrayList<String> listProperties = new ArrayList<String>();
		listProperties.addAll(setProperties);
		Collections.sort(listProperties, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		for (String property : listProperties) {
			sbOut.append(hstProperies.get(property));
		}

		System.out.println(sbOut);

		String filename = "";
		String name = objClass.getSimpleName().substring(0, 1).toLowerCase() + objClass.getSimpleName().substring(1);
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			String sc = "" + c;
			if (c >= 'A' && c <= 'Z') {
				filename += "-" + sc.toLowerCase();
			} else {
				filename += c;
			}
		}

		if (path.startsWith(".")) {
			String current = new java.io.File(".").getCanonicalPath();
			path = current + "\\" + path;
		}

		File file = new File(path + "\\" + filename + ".yml");
		System.out.println("output: " + file.getAbsolutePath());
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(sbOut.toString().getBytes());
		fos.close();
	}

}

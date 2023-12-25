package br.com.luismatos.mapa24.shared.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversaoDatas {

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

	public static Date convertendoData(String dataString) {

		Date date = null;
		try {
			date = df.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static String convertendoDataString(Date data) {
		return (df.format(data)).toString();
	}
}

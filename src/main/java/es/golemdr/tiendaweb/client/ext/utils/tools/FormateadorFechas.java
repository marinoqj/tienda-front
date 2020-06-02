package es.golemdr.tiendaweb.client.ext.utils.tools;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FormateadorFechas {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(FormateadorFechas.class);

	public static String numeroAFecha(long number, String frm){

		SimpleDateFormat formatter = new SimpleDateFormat(frm);
		return (formatter.format(new Date(number)));
	}


	public static long fechaANumero(String fechaStr, String format) throws ParseException{

		long resultado = -1;
		SimpleDateFormat formatter = new SimpleDateFormat(format);

		java.util.Date fecha = formatter.parse(fechaStr);
		resultado = fecha.getTime();
		return resultado;
	}


	public static String cambiaFormato(String fechaStr, String formatoOriginal, String formatoConvertido) throws ParseException{
		
		String nuevoFormato = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat(formatoOriginal);			
		java.util.Date fecha = formatter.parse(fechaStr);
		formatter.applyPattern(formatoConvertido);	
		
		nuevoFormato = formatter.format(fecha);
		
		return nuevoFormato; 
	}
	
	public static String date2String(Date fecha){
		
		String resultado = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		resultado = formatter.format(fecha);
		
		return resultado;
	}
	
	public static String time2String(Date fecha){
		
		String resultado = null;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		resultado = formatter.format(fecha);
		
		return resultado;
	}

	public static Date string2Date(String strFecha) {
		Date resultado = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			resultado = formatter.parse(strFecha);
		} catch (ParseException ex) {
			LOGGER.debug(ex.getMessage());
		}

		return resultado;
	}


}

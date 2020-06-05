package es.golemdr.tiendaweb.client.ext.utils.tools;

import java.text.DecimalFormat;

public class FormateadorUtils {
	
	
	public static String formateaNumeroRegistro(long numeroRegistro){
		
		String resultado = "";
		String numeroConvertido = String.valueOf(numeroRegistro);
		
		String []ceros = {"00000","0000","000","00","0"};
		
		if(numeroConvertido.length() < 6){
			resultado = ceros[numeroConvertido.length()-1] + numeroConvertido;
		}
		
		
		return resultado;
		
		
	}

	
	public static char mayusculaAlAzar(){
		
		int aleatorio = (int)Math.round(Math.random()* 25 + 65);		
		char aux = (char)(aleatorio);
		
			
		return aux;
		
		
	}
	
	public static int numeroAlAzar(){
		
		int aleatorio = (int)(Math.random()* 8)+1;
		
		return aleatorio;
		
	}
	
	public static Double formatDouble(Double original) {
		
		DecimalFormat df = new DecimalFormat("#######.##");      
		
		return Double.valueOf(df.format(original));
		
	}

	
	public static String generaCodigo(){
		
		StringBuffer resultado = new StringBuffer();
		
		// Generamos un ticket con el formato AA99AA99		
		resultado.append(mayusculaAlAzar());
		resultado.append(mayusculaAlAzar());
		resultado.append(numeroAlAzar());
		resultado.append(numeroAlAzar());
		resultado.append(mayusculaAlAzar());
		resultado.append(mayusculaAlAzar());
		resultado.append(numeroAlAzar());
		resultado.append(numeroAlAzar());
		
		return resultado.toString(); 
		
		
		
	}
	
	
}


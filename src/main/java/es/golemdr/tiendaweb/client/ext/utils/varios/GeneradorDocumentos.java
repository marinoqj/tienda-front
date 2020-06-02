package es.golemdr.tiendaweb.client.ext.utils.varios;

import java.util.Random;

public class GeneradorDocumentos {

	/**
	 * Array de letras para calcular el NIF
	 */
	public static final String[] LETRAS_NIF = { "T", "R", "W", "A", "G", "M",
			"Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H",
			"L", "C", "K", "E" };
	/**
	 * Array de ceros para completar los DNI menores de 9 caracteres
	 */
	public static final String[] CEROS = {"0","00","000","0000"};
	
	/**
	 * Array de letras iniciales del NIE
	 */
	public static final String[] LETRAS_NIE = { "X", "Y", "Z"};
	

	/**
	 * Método que genera un NIF aleatoriamente
	 * @return cadena que contiene un NIF válido (de 9 carácteres o menos)
	 */
	public static String generarNIF() {

		String resultado;
		int modulo = 0;
		int dni = 0;

		Random aleatorio = new Random();

		dni = (int) (aleatorio.nextDouble() * 99999999 + 1);

		modulo = dni % 23;

		resultado = dni + LETRAS_NIF[modulo];

		
		return resultado;

	}

	/**
	 * Método para obtener un NIF de 9 caracteres aunque los primeros sean ceros
	 * @return cadena que contiene un NIF válido (siempre de 9 carácteres en los que las primeras posiciones son ceros si es el caso).
	 */
	public static String generarNIFCompleto() {
		
		String resultado;
		
		resultado = generarNIF();
		
		
		if(resultado.length() < 9){
			
			resultado = CEROS[9 - resultado.length() - 1] + resultado;
			
		}
		
		
		return resultado;
		
	}

	/**
	 * Método para generar CIFs de prueba. Todos tienen la misma letra de actividad
	 * @return cadena que contiene un CIF válido
	 */
	public static String generarCIF(){
		
		String letra_actividad = "A";		
		String parte_fija;
		int digito_control = 0;
		String CIF; 
		Random aleatorio = new Random();
		int impar1 = 0;
		int impar3 = 0;
		int impar5 = 0;
		int impar7 = 0;
		
		double aleatorioD = aleatorio.nextDouble();
		
		
		while(aleatorioD < 0.09999999){
			
			//System.out.println(aleatorioD);
			aleatorioD = aleatorio.nextDouble();
			
		}
		

		
		parte_fija = String.valueOf((int)(aleatorioD * 9999999 + 1));
		
		//System.out.println(aleatorioD);
		//System.out.println(parte_fija + "|" + parte_fija.length());
		
		int sumaA = Integer.parseInt(String.valueOf(parte_fija.charAt(1))) 
					+ Integer.parseInt(String.valueOf(parte_fija.charAt(3))) 
					+ Integer.parseInt(String.valueOf(parte_fija.charAt(5))); 

		
		impar1 = Integer.parseInt(String.valueOf(parte_fija.charAt(0))) * 2; 
		impar3 = Integer.parseInt(String.valueOf(parte_fija.charAt(2))) * 2; 
		impar5 = Integer.parseInt(String.valueOf(parte_fija.charAt(4))) * 2;
		impar7 = Integer.parseInt(String.valueOf(parte_fija.charAt(6))) * 2;
		
		
		if (impar1 > 9) {
			impar1 = 1 + (impar1 - 10);
		}
		
		if (impar3 > 9) {
			impar3 = 1 + (impar3 - 10);
		}
		
		if (impar5 > 9) {
			impar5 = 1 + (impar5 - 10);
		}
		
		if (impar7 > 9) {
			impar7 = 1 + (impar7 - 10);
		}
		
		int sumaB = impar1 + impar3 + impar5 + impar7;

		
		int sumaC = sumaA + sumaB;

		
		digito_control = sumaC % 10;
		
		int digitoControlCorregido = (digito_control > 0) ? (10 - digito_control): 0;
		
		
		CIF = letra_actividad + parte_fija + digitoControlCorregido;
		
		return CIF;
		
		
	}
	
	/**
	 * Método que genera un NIE aleatoriamente
	 * @return cadena que contiene un NIE válido (siempre tiene 9 carácteres)
	 */
	public static String generarNIE() {

		String resultado;
		int modulo = 0;
		int numeros = 0;
		int letraInicial = 0;

		Random aleatorioLetraInicial = new Random();
		
		letraInicial = aleatorioLetraInicial.nextInt(3);
		
		Random aleatorioNumeros = new Random();

		numeros = (int) (aleatorioNumeros.nextDouble() * 9999999 + 1);

		modulo = ((letraInicial*10000000 )+ numeros) % 23;

		resultado = LETRAS_NIE[letraInicial] + numeros + LETRAS_NIF[modulo];

		
		if(resultado.length() < 9){
			
			resultado = LETRAS_NIE[letraInicial] + CEROS[9 - resultado.length() - 1] + numeros + LETRAS_NIF[modulo];
			
		}
		
		
		
		return resultado;

	}
	


}

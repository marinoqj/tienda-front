package es.golemdr.tiendaweb.client.ext.utils.varios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorFicheros {

	
	public static int contarLineasFichero(File fichero, boolean contarBlancas){
		
		Scanner s;
		int lineas = 0;
		String linea = null;
		
		try {
			
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				
				linea = s.nextLine();
				
				if(linea.length() == 0 && !contarBlancas){
					
					continue;
				}
				
				lineas++;
			}

			s.close();
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return lineas;
	}
	
	
}

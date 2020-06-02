package es.golemdr.tiendaweb.client.ext.utils.varios;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


@SuppressWarnings("unused")
public class LectorDirectorios {
	
	private static Logger LOGGER = LogManager.getLogger(LectorDirectorios.class);
	
	private static int total = 0;
	private static int nivel = 1;
	private static String indentado;
	private static long tamanyo = 0;
	

	public static void listarDirectorio(String directorio) {
		
		
		File raiz = new File(directorio);
		File [] subdirectorios;
		String[] hijos;
		
		if(raiz.isDirectory()){
			
			hijos = raiz.list();
		     
		    subdirectorios = raiz.listFiles();
		     
		     for (File unSubdirectorio : subdirectorios) {	         
		    	 
		    	 LOGGER.debug("-" + recuperarIndentado(nivel) + unSubdirectorio.getName() + "(" + FileUtils.sizeOf(unSubdirectorio) + ")");
		    	 
		    	 total ++;
		    	 
		    	 if(unSubdirectorio.isDirectory()){
		    		 nivel++;
		    		 imprimeDirectorio(unSubdirectorio);
		    	 }
		    	 
		    	 tamanyo += unSubdirectorio.length();
		    	 
		       }
		    
		     LOGGER.debug("############################################");
		     LOGGER.debug("El número de ficheros y carpetas es: " + total);
		     LOGGER.debug("El tamaño total es: " + FileUtils.sizeOf(raiz));
		     
		}

	}
	
	private static void imprimeDirectorio(File directorio){
		
		File [] ficheros = directorio.listFiles();
		
	     for (File unFichero : ficheros) {	         
	    	 LOGGER.debug("" + recuperarIndentado(nivel) + " + " + unFichero.getName() + "(" + FileUtils.sizeOf(unFichero) + ")");	    	
	    	 
	    	 tamanyo += unFichero.length();
	    	 
	    	 if(unFichero.isDirectory()){
	    		 nivel++;
	    		 imprimeDirectorio(unFichero);
	    	 }
	     
	    	 total++;
	     
	     }
	     
	     nivel--;
		
	}

	
	private static String recuperarIndentado(int nivel){
		
		StringBuffer resultado = new StringBuffer();
		String [] subniveles = {" ","  ","   ","    ","     ","      ","       ","        ","         ","          "," ","  ","   ","    ","     ","      ","       ","        ","         ","          "," ","  ","   ","    ","     ","      ","       ","        ","         ","          "};

		
		for(int i = 1; i <= nivel; i++){
			
			resultado.append(subniveles[i]);
		}	
		
		return resultado.toString();
		
	}


}


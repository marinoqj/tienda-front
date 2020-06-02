package es.golemdr.tiendaweb.client.ext.utils.varios;

import java.io.File;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;



@SuppressWarnings("unused")
public class InspectorProyectos {
	
	private static Logger LOGGER = LogManager.getLogger(InspectorProyectos.class);
	
	
	private static int total = 1;	
	private static int nivel = 1;
	private static String indentado;
	private static long tamanyo = 0;
	
	private static int carpetas = 0;
	
	private static final boolean CON_BLANCAS = true;
	private static final boolean SIN_BLANCAS = false;
	
	private static int ficheros_jpg = 0;
	private static int ficheros_jpeg = 0;
	private static int ficheros_pdf = 0;
	private static int ficheros_docx = 0;
	private static int ficheros_doc = 0;
	private static int ficheros_png = 0;
	private static int ficheros_java = 0;
	private static int ficheros_xml = 0;
	private static int ficheros_properties = 0;
	private static int ficheros_jsp = 0;
	private static int ficheros_css = 0;
	private static int ficheros_gif = 0;
	private static int ficheros_js = 0;
	private static int ficheros_jrxml = 0;
	private static int ficheros_dtd = 0;
	private static int ficheros_tag = 0;
	private static int ficheros_tld = 0;
	private static int ficheros_raros = 0;
	
	
	private static int lineas_java = 0;
	private static int lineas_java_blancas = 0;
	private static int lineas_jsp = 0;
	private static int lineas_jsp_blancas = 0;
	
	
	private static StringWriter sw = null;
	private static Set<String> extensionesRaras = new HashSet<String>();

	
		
	public static void analizarProyecto(String directorioRaiz){
		
		sw = new StringWriter();
		
		
		File raiz = new File(directorioRaiz);
		File [] subdirectorios;
		String[] hijos;
		
		if(raiz.isDirectory()){
			
			hijos = raiz.list();
			
			LOGGER.debug("### Directorio inspeccionado ### : " + raiz.getAbsolutePath());
			LOGGER.debug("### Tamaño total ### : " + FileUtils.sizeOf(raiz));
			
					
		     
		    subdirectorios = raiz.listFiles();
		     
		     for (File unSubdirectorio : subdirectorios) {	         
		    	 
		    	 cuentaExtensiones(unSubdirectorio.getName());
		    	 
		    	 total++;
		    	 
		    	 if(unSubdirectorio.isDirectory()){
		    		 nivel++;
		    		 carpetas++;
		    		 imprimeDirectorio(unSubdirectorio);
		    	 }
		    	 		    	 
		    	 tamanyo += unSubdirectorio.length();

		       }
		     
		     total++;
		    
		     LOGGER.debug("Total elementos: " + total);
		     LOGGER.debug("Carpetas: " + carpetas);
		     LOGGER.debug("Ficheros : " + (ficheros_docx + ficheros_doc + ficheros_java + ficheros_jpg + ficheros_jpeg + ficheros_jsp + ficheros_pdf 
						+ ficheros_properties + ficheros_xml + ficheros_css + ficheros_gif 
						+ ficheros_js + ficheros_dtd + ficheros_jrxml + ficheros_tag + ficheros_tld + ficheros_png + ficheros_raros));

		     
		     LOGGER.debug("----------------");
		     
		     LOGGER.debug("JAVA " + ficheros_java + "|| Total lineas:" + lineas_java + "/" + lineas_java_blancas);
		     LOGGER.debug("JSP " + ficheros_jsp + "|| Total lineas:" + lineas_jsp + "/" + lineas_jsp_blancas);
		     LOGGER.debug("XML " + ficheros_xml);
		     LOGGER.debug("PROPERTIES " + ficheros_properties);
		     LOGGER.debug("TAG " + ficheros_tag);
		     LOGGER.debug("CSS " + ficheros_css);
		     LOGGER.debug("JS " + ficheros_js);
		     LOGGER.debug("DTD " + ficheros_dtd);		     
		     LOGGER.debug("TLD " + ficheros_tld);

		     LOGGER.debug("----------------");
		     
		     LOGGER.debug("JPG/JPEG " + (ficheros_jpg + ficheros_jpeg));
		     LOGGER.debug("GIF " + ficheros_gif);
		     LOGGER.debug("PNG " + ficheros_png);
		     
		     LOGGER.debug("----------------");
		     
		     LOGGER.debug("PDF " + ficheros_pdf);
		     LOGGER.debug("DOC/DOCX " + (ficheros_docx + ficheros_doc));
		     LOGGER.debug("JRXML " + ficheros_jrxml);
		     
		     LOGGER.debug("----------------");
		     
		     LOGGER.debug("RAROS " + ficheros_raros);
		     LOGGER.debug("Extensiones raras: " + sw.toString());
		     
		     LOGGER.debug("----------------");
		     
		     
		     
		     LOGGER.debug("Suma total : " + (carpetas + ficheros_docx + ficheros_doc + ficheros_java + ficheros_jpg + ficheros_jpeg + ficheros_jsp + ficheros_pdf 
		    		 								+ ficheros_properties + ficheros_xml + ficheros_css + ficheros_gif 
		    		 								+ ficheros_js + ficheros_dtd + ficheros_jrxml + ficheros_tag + ficheros_tld + ficheros_png + ficheros_raros));
		}
		
			LOGGER.debug("El tamaño total es: " + FileUtils.sizeOf(raiz));
			
	
	}
	
	private static void imprimeDirectorio(File directorio){
		
		File [] ficheros = directorio.listFiles();
		
		
		
	     for (File unFichero : ficheros) {	         

	    	 cuentaExtensiones(unFichero.getName());
	    	 
	    	 if(!unFichero.isDirectory() && unFichero.getName().contains(".java")){
	    		 int sin_blancas = LectorFicheros.contarLineasFichero(unFichero, SIN_BLANCAS);
	    		 int con_blancas = LectorFicheros.contarLineasFichero(unFichero, CON_BLANCAS);
	    		 LOGGER.debug("El fichero "+ unFichero.getName() + " tiene : " + sin_blancas + "/" + con_blancas + " líneas");
	    		 lineas_java += sin_blancas;
	    		 lineas_java_blancas += con_blancas;
	    	 }else if(!unFichero.isDirectory() && unFichero.getName().contains(".jsp")){
	    		 int sin_blancas = LectorFicheros.contarLineasFichero(unFichero, SIN_BLANCAS);
	    		 int con_blancas = LectorFicheros.contarLineasFichero(unFichero, CON_BLANCAS);
	    		 LOGGER.debug("El fichero "+ unFichero.getName() + " tiene : " + sin_blancas + "/" + con_blancas + " líneas");
	    		 lineas_jsp += sin_blancas;
	    		 lineas_jsp_blancas += con_blancas;
	    	 }    	 
	    	 
	    	 tamanyo += unFichero.length();
	    	 
	    	 if(unFichero.isDirectory()){
	    		 nivel++;
	    		 carpetas++;
	    		 imprimeDirectorio(unFichero);
	    	 }
	     
	    	 total++;
	     
	     }
	     
	     nivel--;
		
	}
	
	
	private static void cuentaExtensiones(String nombreFichero){
		
		String extensionFichero = null;
		
		if(nombreFichero.contains(".")){
			 
			 extensionFichero = nombreFichero.substring(nombreFichero.lastIndexOf("."));
			 
			 if(extensionFichero.equalsIgnoreCase(".jpg")){
				 
				 ficheros_jpg++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".jpeg")){
				 
				 ficheros_jpeg++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".pdf")){
				 
				 ficheros_pdf++;				 			
			 
			 }else if(extensionFichero.equalsIgnoreCase(".docx")){
				 
				 ficheros_docx++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".doc")){
				 
				 ficheros_doc++;
				 
			 }
			 else if(extensionFichero.equalsIgnoreCase(".png")){
				 
				 ficheros_png++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".java")){
				 
				 ficheros_java++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".xml")){
				 
				 ficheros_xml++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".properties")){
				 
				 ficheros_properties++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".jsp")){
				 
				 ficheros_jsp++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".css")){
				 
				 ficheros_css++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".gif")){
				 
				 ficheros_gif++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".js")){
				 
				 ficheros_js++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".jrxml")){
				 
				 ficheros_jrxml++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".dtd")){
				 
				 ficheros_dtd++;
				 
			 }else if(extensionFichero.equalsIgnoreCase(".tag")){
				 
				 ficheros_tag++;		 
			 	
			 }else if(extensionFichero.equalsIgnoreCase(".tld")){
				 
				 ficheros_tld++;		 
			 			 			 				
			 }else{
				 
				 if(!extensionesRaras.contains(extensionFichero)){
					 
					 extensionesRaras.add(extensionFichero);
					 sw.append(extensionFichero + " | ");
				 }
				 				 
				 ficheros_raros++;
			 }
			
			 
		}

		
		
}

	

}


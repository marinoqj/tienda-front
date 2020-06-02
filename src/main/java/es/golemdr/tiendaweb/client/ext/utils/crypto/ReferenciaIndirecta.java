package es.golemdr.tiendaweb.client.ext.utils.crypto;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


public class ReferenciaIndirecta {
	
	public static void generaReferencia(List coleccion, int semilla){
		
		IdOcultable entidad = null;
		Iterator it = coleccion.iterator();
		
		while(it.hasNext()){
			
			entidad = (IdOcultable)it.next();
				
			entidad.setIdEncriptado(generaReferenciaIndirecta(entidad.getId(), semilla));
		}
		
		
	}
	
	
	public static String generaReferenciaIndirecta(Long id, int semilla){
		
		String cadenaIdEncriptada = null;
		String referenciaIndirecta = null;
		
		
		cadenaIdEncriptada = Cifrador.cifraStringAndB64(String.valueOf(id));
		
		referenciaIndirecta = trasponerCadena(cadenaIdEncriptada, semilla);
		
		
		return referenciaIndirecta;
	}

	
	public static String trasponerCadena(String cadenaOriginal, int semilla){
		
		int nuevoValor = 0;
		int valor = 0;
		
		StringBuilder resultado = new StringBuilder();
		
		byte[] bytesCadenaOriginal = cadenaOriginal.getBytes();
		
		for(int i = 0; i < bytesCadenaOriginal.length; i ++){
			
			valor = bytesCadenaOriginal[i];
			
			if(valor >= semilla){
				
				nuevoValor = valor - semilla + 1;
			
			}else{
				
				nuevoValor = valor + semilla + 2;
				
			}
			
			resultado.append(Character.toChars(nuevoValor));
		}
		
		
		//System.out.println(" | " + Base64.encodeBase64String(resultado.toString().getBytes()));
		
		
		
		return new String(Base64.encodeBase64String(resultado.toString().getBytes()));
		
		
	}
	
	
	public static String recomponerYdescifrarCadena(String cadenaOriginal, int semilla){
		
		int nuevoValor = 0;
		int valor = 0;
		
		String resultado = null;
		StringBuilder cadenaRecompuesta = new StringBuilder();
		
		//System.out.println(" Cadena original " +  cadenaOriginal);
		
		byte[] bytesCadenaOriginal = Base64.decodeBase64(cadenaOriginal);
		
		for(int i = 0; i < bytesCadenaOriginal.length; i ++){
			
			valor = bytesCadenaOriginal[i];
			
			if(valor >= semilla){
				
				nuevoValor = valor + semilla - 1;
			
			}else{
				
				nuevoValor = valor - semilla - 2;
				
			}
			
			//System.out.print(" Valor " +  valor);
			//System.out.print(" | Semilla " +  semilla);
			//System.out.println(" | Nuevo valor " +  nuevoValor);
			
			cadenaRecompuesta.append(Character.toChars(nuevoValor));
		}
		
		
		//System.out.println(" Cadena recompuesta " +  cadenaRecompuesta.toString());
		
		resultado = Cifrador.descifraString(cadenaRecompuesta.toString());
		
		return resultado;
		
		
	}
}

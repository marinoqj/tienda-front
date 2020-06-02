package es.golemdr.tiendaweb.client.ext.utils.crypto;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Cifrador {
	
	private static Logger LOGGER =  LoggerFactory.getLogger(Cifrador.class);
	
	public static String cifraStringAndB64(String cadena){
		
		Cipher desCipher = null;
		String cadenaEncryptedB64 = null;
		
	    try {
	    	
	    	// Instancio el cifrador
			desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		   
			// Recupero el fichero que contiene la clave
		    Resource ficheroClave = new ClassPathResource("public.key");		    
		    
		    // Inicializo el cifrador en modo encriptacion
		    desCipher.init(Cipher.ENCRYPT_MODE, loadKey(ficheroClave.getFile()));
		    
		    // Encripto la cadena y la paso a B64
		    byte[] cadenaBytes = cadena.getBytes();
		    byte[] cadenaEncrypted = desCipher.doFinal(cadenaBytes);
		    cadenaEncryptedB64 = Base64.encodeBase64String(cadenaEncrypted);
					
			
		} catch (Exception e) {

			LOGGER.error("Se produjo la excepcion: " + e.getMessage());
			
		} 
		
		
		return cadenaEncryptedB64;
		
	}
	
	public static String descifraString(String cadenaB64){
		
		Cipher desCipher = null;
		byte[] cadenaDecrypted = null;
	    byte[] cadenaEncrypted = null;
	    String cadenaDescifrada = null;
	    
	    
	    
	    try {
	    	
	    	// Instancio el cifrador
	    	desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
	    	
	    	// Recupero el fichero que contien la clave
	    	Resource ficheroClave = new ClassPathResource("public.key");
	    	
	    	// Inicializo el cifrador en modo desencriptacion
			desCipher.init(Cipher.DECRYPT_MODE, loadKey(ficheroClave.getFile()));
			
			// Decodifico la cadena y luego la desencripto
			cadenaEncrypted = Base64.decodeBase64(cadenaB64);
			cadenaDecrypted = desCipher.doFinal(cadenaEncrypted);
			cadenaDescifrada = new String(cadenaDecrypted);
			
		} catch (Exception e) {

			LOGGER.error("Se produjo la excepcion: " + e.getMessage());
			
		} 
	    
	    
		return cadenaDescifrada;
	}
	
	
	private static SecretKey generateKey() throws NoSuchAlgorithmException {
	    KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");	    
	    SecretKey key = keyGenerator.generateKey();
	    return key; 
	} 	
	
	private static void saveKey(SecretKey key, File file) throws IOException  {
	    byte[] encoded = key.getEncoded();
	    FileUtils.writeByteArrayToFile(file, encoded);
	}

	private static SecretKey loadKey(File file) throws IOException {
	    byte[] encoded = FileUtils.readFileToByteArray(file);
	    SecretKey key = new SecretKeySpec(encoded, "DES");
	    return key;
	}

	public static void main(String [] args){
		
		System.out.println(cifraStringAndB64("pepito"));
		System.out.println(descifraString("nuxpZrOlAq8="));
		
		PasswordEncoder delegateEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

		String encoded1 = delegateEncoder.encode("1");

		String encoded2 = new BCryptPasswordEncoder().encode("1");
		
		System.out.println(encoded1);
		System.out.println(encoded2);
		


		
		
	}
	
}

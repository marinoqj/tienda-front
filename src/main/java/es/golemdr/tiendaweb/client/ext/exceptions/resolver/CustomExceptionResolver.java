package es.golemdr.tiendaweb.client.ext.exceptions.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import es.golemdr.tiendaweb.client.ext.exceptions.LoginException;
import es.golemdr.tiendaweb.client.ext.utils.Constantes;
import es.golemdr.tiendaweb.client.ext.utils.tools.FormateadorUtils;

public class CustomExceptionResolver extends SimpleMappingExceptionResolver{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionResolver.class);
	
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    	String mensaje = null;
    	String codigo = null;
    	ModelAndView view = null;
    	
    	if(ex instanceof NullPointerException ){
    		
    		mensaje = "excepcion.valor.nulo";
    	
    	}else if(ex instanceof LoginException){
        		
        	mensaje = "excepcion.error.login";    		
    		
    	}else{
    	
    		mensaje = "excepcion.error.desconocido";
    	}

    	codigo = FormateadorUtils.generaCodigo();
    	
    	
    	LOGGER.error("Se produjo una excepción de tipo : " + ex.getMessage());
    	LOGGER.error("El código de la excepción es : " + codigo);
    	LOGGER.error("La traza de la excepción es : " + recuperarTraza(ex));
    	
    	
    	
    	request.setAttribute(Constantes.ATRIBUTO_MENSAJE, mensaje);
    	request.setAttribute(Constantes.ATRIBUTO_CODIGO, codigo);
    	request.setAttribute(Constantes.ATRIBUTO_TRAZA, recuperarTraza(ex));
    	

        
        // Para el login redirigimos a la pantalla de login(obviamente ;-)
//        if(ex instanceof LoginException){
//        	
//        	view = super.getModelAndView("Login", ex, request);
//        
//        }else{
        	
        	// Para las excepciones que no surgen durante el login utilizamos este método...
           view =  super.resolveException(request, response, handler, ex);
        //}
        
        return view;

    }
    
	public static String recuperarTraza( Throwable throwable ) {

		StringBuilder msg = new StringBuilder();

        //msg.append("Message : ");
        msg.append(throwable.getMessage());

        
        msg.append("\n");
        msg.append("-----\n");
        msg.append("Exception Stack Trace-----\n");
        try {
            StringWriter sWriter = new StringWriter();
            PrintWriter pWriter = new PrintWriter(sWriter);
            throwable.printStackTrace(pWriter);
            msg.append(sWriter.toString());
            msg.append("\n");
            msg.append("------\n");
            sWriter.close();
        } catch (Exception e) {
            msg.append(throwable.toString());
        }
        return msg.toString();		
	}

}

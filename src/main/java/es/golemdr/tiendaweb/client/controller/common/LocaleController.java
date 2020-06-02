package es.golemdr.tiendaweb.client.controller.common;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;




@Controller
public class LocaleController {

	@Resource(name="localeResolver")
	private SessionLocaleResolver slr;
	
	
	@RequestMapping(value="/localeController_{idioma}.do", method=RequestMethod.GET)
	public String cambiarLocale(@PathVariable("idioma") String idioma,HttpServletRequest request,HttpServletResponse response) {
		
		
		// Recuperamos el idioma que viene como parámetro
		Locale locale = null;
		
		if(idioma != null){
			// Creamos un locale con ese idioma
			locale = new Locale(idioma);
			
			// Seteamos ese nuevo locale a la sesión
			slr.setLocale(request, response, locale);
		
		}		
		
		
		return "Home";
	}


	
	
	public SessionLocaleResolver getSlr() {
		return slr;
	}


	public void setSlr(SessionLocaleResolver slr) {
		this.slr = slr;
	}
	
	
}

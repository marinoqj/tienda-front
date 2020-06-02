package es.golemdr.tiendaweb.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;



@Controller
public class HomeController {

	private static Logger logger =  LoggerFactory.getLogger(HomeController.class);
	

	
	@RequestMapping(value=UrlConstants.URL_HOME, method=RequestMethod.GET)
	public String goHome(HttpServletRequest request) {
		
		String destino = null;	
		
		
		destino = ForwardConstants.FWD_HOME;
		
		return destino;
		
	}
}	



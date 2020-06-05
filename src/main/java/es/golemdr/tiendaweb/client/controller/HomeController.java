package es.golemdr.tiendaweb.client.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;
import es.golemdr.tiendaweb.client.domain.Pedido;



@Controller
public class HomeController {

	private static Logger logger =  LoggerFactory.getLogger(HomeController.class);
	

	
	@RequestMapping(value=UrlConstants.URL_HOME, method=RequestMethod.GET)
	public String goHome(HttpServletRequest request) {

		
		// Cargo en sesión un objeto para almacenar los datos del pedido
        HttpSession session = request.getSession(false);	      
		// Cargamos al usuario en sesión				
	    session.setAttribute("pedido", new Pedido());
		
		
		
		return ForwardConstants.FWD_HOME;
		
	}
}	



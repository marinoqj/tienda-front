package es.golemdr.tiendaweb.client.controller;

import java.util.Map;

import javax.annotation.Resource;
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
import es.golemdr.tiendaweb.client.service.CestaService;



@Controller
public class HomeController {

	private static Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private CestaService cestaService;

	
	@RequestMapping(value=UrlConstants.URL_HOME, method=RequestMethod.GET)
	public String goHome(Map<String, Object> map, HttpServletRequest request) {

		
		// Cargo en sesión un objeto para almacenar los datos del pedido
        HttpSession session = request.getSession(false);	      
		// Cargamos al usuario en sesión				
	    session.setAttribute("pedido", new Pedido());
		
		String estadoServidor =  cestaService.checkEstado();
		
		if(estadoServidor != null && !estadoServidor.equals("") && estadoServidor.contains("STATUS: UP")) {
			
			map.put("servidorUP", true);
		}
		
		return ForwardConstants.FWD_HOME;
		
	}
}	



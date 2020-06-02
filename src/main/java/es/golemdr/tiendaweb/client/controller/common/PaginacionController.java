package es.golemdr.tiendaweb.client.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.golemdr.tiendaweb.client.ext.utils.paginacion.PaginacionFactory;






@Controller
public class PaginacionController {

	@RequestMapping(value="/paginacionController{paginacion}.do", method=RequestMethod.GET)
	public String cambiarLocale(@PathVariable("paginacion") String paginacion,HttpServletRequest request,HttpServletResponse response) {
		
		
		PaginacionFactory.setElementosXPagina(Integer.parseInt(paginacion), request);
		
		
		return "Home";
	}
}
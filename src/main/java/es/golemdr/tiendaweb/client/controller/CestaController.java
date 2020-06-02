package es.golemdr.tiendaweb.client.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;
import es.golemdr.tiendaweb.client.domain.Producto;
import es.golemdr.tiendaweb.client.service.CestaService;

@Controller
public class CestaController {
	
	private static Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private CestaService cestaService;
	
	@RequestMapping(value=UrlConstants.URL_PRODUCTOS_CATEGORIA, method=RequestMethod.GET)
	public String list(@PathVariable("idCategoria") String idCategoria,Map<String, Object> map, HttpServletRequest request) {
		
		
		List<Producto> resultado = null;	

		resultado = cestaService.recuperarProductosCategoria(new Long(idCategoria));
		
		map.put("productos", resultado);

		return ForwardConstants.FWD_LISTADO_PRODUCTOS_CATEGORIA;
	}

}

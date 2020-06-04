package es.golemdr.tiendaweb.client.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;
import es.golemdr.tiendaweb.client.domain.Pedido;
import es.golemdr.tiendaweb.client.domain.Producto;
import es.golemdr.tiendaweb.client.service.CestaService;

@Controller
public class CestaController {
	
	private static Logger logger =  LoggerFactory.getLogger(HomeController.class);
	
    @Autowired
    ObjectMapper objectMapper;
	
	@Resource
	private CestaService cestaService;
	
	@RequestMapping(value=UrlConstants.URL_PRODUCTOS_CATEGORIA, method=RequestMethod.GET)
	public String list(@PathVariable("idCategoria") String idCategoria,Map<String, Object> map, HttpServletRequest request) {
		
		
		List<Producto> resultado = null;	

		resultado = cestaService.recuperarProductosCategoria(new Long(idCategoria));
		
		map.put("productos", resultado);

		return ForwardConstants.FWD_LISTADO_PRODUCTOS_CATEGORIA;
		
		
	}
	
	@RequestMapping(value = UrlConstants.URL_ANYADIR_PRODUCTO_CESTA, method = RequestMethod.GET, headers="Accept=application/json",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String anyadirProducto(@RequestParam("idProducto") String idProducto, @RequestParam("precio") String precio) throws JsonProcessingException {
		
		//String json = "{\"total\" : \"1\"}";
		
		Pedido pedido = new Pedido();
		pedido.setIdPedido(1L);
		pedido.setNumArticulos(4);
		pedido.setTotal(12.38);
		
		return objectMapper.writeValueAsString(pedido);
	}

}

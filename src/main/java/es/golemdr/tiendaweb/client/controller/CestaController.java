package es.golemdr.tiendaweb.client.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;
import es.golemdr.tiendaweb.client.domain.Cliente;
import es.golemdr.tiendaweb.client.domain.Detalle;
import es.golemdr.tiendaweb.client.domain.Pedido;
import es.golemdr.tiendaweb.client.domain.Producto;
import es.golemdr.tiendaweb.client.ext.utils.proyecto.PreparadorPedidos;
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
	public String anyadirProducto(@RequestParam("idProducto") String idProducto, @RequestParam("precio") String precio, 
			@RequestParam("nombre") String nombre, HttpServletRequest request) throws JsonProcessingException {
		
		HttpSession session = request.getSession(false);
		
		Pedido pedido = (Pedido)session.getAttribute("pedido");
		
		pedido.setNumArticulos(pedido.getNumArticulos() + 1);
		
		double nuevoTotal = pedido.getTotal() + new Double(precio);
		pedido.setTotal(Precision.round(nuevoTotal, 2));
		
		Detalle detalle = new Detalle();
		
		
		Producto producto = new Producto();
		producto.setIdProducto(new Long(idProducto));
		producto.setPrecio(new Double(precio));
		producto.setNombre(nombre);
		
		detalle.setProducto(producto);
		detalle.setCantidad(1);
		pedido.getDetalles().add(detalle);
		
		return objectMapper.writeValueAsString(pedido);
	}
	
	@RequestMapping(value=UrlConstants.URL_LISTADO_PRODUCTOS_PEDIDO, method=RequestMethod.GET)
	public String listadoProductosPedido(Model model) {
		
		return ForwardConstants.FWD_LISTADO_PRODUCTOS_PEDIDO;
	}	
	
	@RequestMapping(value=UrlConstants.URL_ELIMINAR_PRODUCTO_CESTA, method=RequestMethod.POST)
	public String eliminarProducto(String idProducto , HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		Pedido pedido = (Pedido)session.getAttribute("pedido");
		
		PreparadorPedidos.eliminarProducto(pedido, new Long(idProducto));


		return ForwardConstants.FWD_LISTADO_PRODUCTOS_PEDIDO;
		
		
	}
	
	@RequestMapping(value=UrlConstants.URL_INCREMENTAR_PRODUCTO_CESTA, method=RequestMethod.POST)
	public String incrementarProducto(String idProducto , HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		Pedido pedido = (Pedido)session.getAttribute("pedido");
		
		PreparadorPedidos.incrementarProducto(pedido, new Long(idProducto));


		return ForwardConstants.FWD_LISTADO_PRODUCTOS_PEDIDO;
		
		
	}
	
	@RequestMapping(value=UrlConstants.URL_REDUCIR_PRODUCTO_CESTA, method=RequestMethod.POST)
	public String reducirProducto(String idProducto , HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		Pedido pedido = (Pedido)session.getAttribute("pedido");
		
		PreparadorPedidos.reducirProducto(pedido, new Long(idProducto));


		return ForwardConstants.FWD_LISTADO_PRODUCTOS_PEDIDO;
		
		
	}
	
	@RequestMapping(value=UrlConstants.URL_CONFIRMAR_PEDIDO, method=RequestMethod.GET)
	public String verDatosClienteForm(Model model) {
		
		model.addAttribute(new Cliente());
		
		return ForwardConstants.FWD_DATOS_CLIENTE_FORM;
	}
	
	@RequestMapping(value=UrlConstants.URL_RECUPERAR_CLIENTE_DNI,method=RequestMethod.POST)
	public String editar(String dni, Map<String, Object> map) {

		Cliente resultado = cestaService.recuperarClienteDNI(dni);

		if(resultado == null) {
			
			map.put("existeUsuario",false);
			map.put("dniErroneo",true);
			resultado = new Cliente();
		
		}else {
			
			map.put("existeUsuario",true);
		}

		map.put("cliente",resultado);


		return ForwardConstants.FWD_DATOS_CLIENTE_FORM;
	}
	
	@RequestMapping(value=UrlConstants.URL_TERMINAR_PEDIDO,method=RequestMethod.POST)
	public String terminarPedido(@Valid Cliente cliente, Map<String, Object> map, HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		
		Pedido pedido = (Pedido)session.getAttribute("pedido");		
		pedido.setCliente(cliente);
		
		cestaService.insertarPedido(pedido);
		
		session.removeAttribute("pedido");

		map.put("mensaje", "pedido.ok");


		return ForwardConstants.FWD_MENSAJE;
	}
}

package es.golemdr.tiendaweb.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;
import es.golemdr.tiendaweb.client.domain.Categoria;
import es.golemdr.tiendaweb.client.domain.Producto;
import es.golemdr.tiendaweb.client.service.ProductosService;





@Controller
public class ProductosController {

	private static final Logger LOGGER =  LoggerFactory.getLogger(ProductosController.class);
	
    @Autowired
    ObjectMapper objectMapper;
	
	@Resource
	private ProductosService productosService;
	
	
	/** 
	 * M?todo para mostrar el listado
	 */	
	@RequestMapping(value=UrlConstants.URL_LISTADO_PRODUCTOS, method=RequestMethod.GET)
	public String list(@PathVariable("inicio") int inicio,Map<String, Object> map, HttpServletRequest request) {
		
		// TODO - Resolver el tema de la paginación
		
		List<Producto> resultado = null;
		//PaginacionBean paginacion = PaginacionFactory.getPaginacionBean(request);
		boolean hayFiltro = false;		
		
		//paginacion.setInicio(Integer.valueOf(inicio - 1));			

		//resultado = productosService.getProductos(paginacion);
		resultado = productosService.getProductos();
		
		
		// Actualizamos la paginaci?n
		//paginacion.setInicio(inicio);
		//paginacion.setTotalRegistros(productosService.getTotalProductos());
		
		
		
		//map.put("paginacion", paginacion);
		map.put("productos", resultado);
		map.put("hayFiltro", hayFiltro);
		map.put("producto",new Producto());
		

		return ForwardConstants.FWD_LISTADO_PRODUCTOS;
	}

	
	/** 
	 * M?todo para mostrar el formulario de alta
	 */
	@RequestMapping(value=UrlConstants.URL_ALTA_PRODUCTO, method=RequestMethod.GET)
	public String verAltaForm(Model model) {
		
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria();
		categoria1.setIdCategoria(1L);
		categoria1.setNombre("Charcutería");
		Categoria categoria2 = new Categoria();
		categoria2.setIdCategoria(2L);
		categoria2.setNombre("Pollería");
		Categoria categoria3 = new Categoria();
		categoria3.setIdCategoria(3L);
		categoria3.setNombre("Carnicería");
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		
		model.addAttribute("modo", "insertar");
		model.addAttribute(new Producto());
		model.addAttribute("categorias", categorias);
		
		return ForwardConstants.FWD_PRODUCTO_FORM;
	}	
	

	/** 
	 * M?todo para insertar un nuevo objeto
	 */
	@RequestMapping(value=UrlConstants.URL_INSERTAR_PRODUCTO,method=RequestMethod.POST)
	public String insertar(@Valid Producto producto, BindingResult result, Model model) {
		
		String destino = null;
		
		if (result.hasErrors()) {

			model.addAttribute("modo", "insertar");
			destino =  ForwardConstants.FWD_PRODUCTO_FORM;
			
		}else{

			productosService.insertarProducto(producto);
			destino = ForwardConstants.RED_LISTADO_PRODUCTOS; 
				
		}
		
		
		return destino; 
	}

	
	/** 
	 * M?todo para editar un objeto
	 */
	@RequestMapping(value=UrlConstants.URL_EDITAR_PRODUCTO,method=RequestMethod.POST)
	public String editar(String idProducto, Map<String, Object> map) {

		Producto resultado = null;

		resultado = productosService.getById(new Long(idProducto));

		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria categoria1 = new Categoria();
		categoria1.setIdCategoria(1L);
		categoria1.setNombre("Charcutería");
		Categoria categoria2 = new Categoria();
		categoria2.setIdCategoria(2L);
		categoria2.setNombre("Pollería");
		Categoria categoria3 = new Categoria();
		categoria3.setIdCategoria(3L);
		categoria3.setNombre("Carnicería");
		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		
		map.put("modo", "actualizar");
		map.put("producto",resultado);
		map.put("categorias",categorias);

		return ForwardConstants.FWD_PRODUCTO_FORM;
	}	
		
	
	/** 
	 * M?todo para actualizar un objeto
	 * @throws JsonProcessingException 
	 */	
	@RequestMapping(value=UrlConstants.URL_ACTUALIZAR_PRODUCTO,method=RequestMethod.POST)
	public String actualizar(@Valid Producto producto, BindingResult result, Model model) throws JsonProcessingException {

		
		String destino = null;
		
		if (result.hasErrors()) {
		
			model.addAttribute("modo", "actualizar");		
			destino = ForwardConstants.FWD_PRODUCTO_FORM;
		
		}else{
				
			System.out.println(objectMapper.writeValueAsString(producto));
			
			productosService.actualizarProducto(producto);
			destino = ForwardConstants.RED_LISTADO_PRODUCTOS;		
		
		}
		
		return destino;
	}
	
	

	/** 
	 * M?todo para borrar un objeto
	 */
	@RequestMapping(value=UrlConstants.URL_BORRAR_PRODUCTO,method=RequestMethod.POST)
	public String borrar(String idProducto, Map<String, Object> map) {
		
		// Borramos el objeto
		productosService.borrarProducto(new Long(idProducto));

		return ForwardConstants.RED_LISTADO_PRODUCTOS;
		
	}




}

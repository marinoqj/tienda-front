package es.golemdr.tiendaweb.client.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.golemdr.tiendaweb.client.domain.Categoria;
import es.golemdr.tiendaweb.client.domain.Producto;


@Service
public class ProductosService {
	
	//@Value("${server.name}")
	private String SERVER = "http://localhost";
	
	//@Value("${server.port}")
	private String PORT = "8888";	
	
	private String HOST = SERVER + ":" + PORT;
	
	private final RestTemplate restTemplate;
	
    public ProductosService (){
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }
	
	public List<Producto> getProductos(){
		
		// TODO - Quitar el harcode de la URI de los servicios
		
		ResponseEntity<Producto[]> response = restTemplate.getForEntity(HOST + "/listadoProductos", Producto[].class);
		
		Producto[] productos = response.getBody();
		
		return Arrays.asList(productos);

	}
	
	
	
	public URI insertarProducto(Producto producto) {
		
		return restTemplate.postForLocation(HOST + "/crearProducto", producto);
		
	}

	
	public void actualizarProducto(Producto producto) {
		
		restTemplate.put(HOST + "/actualizarProducto", producto);
		
	}
	
	public Producto getById(Long idProducto) {
	
		return restTemplate.getForObject(HOST + "/recuperarProducto" + idProducto.toString(), Producto.class);
		 
	}

	
	public void borrarProducto(Long idProducto) {
	
		restTemplate.delete(HOST + "/borrarProducto" + idProducto.toString());
		
	}		
	
	public List<Categoria> recuperarCategorias(){
		
		ResponseEntity<Categoria[]> response = restTemplate.getForEntity(HOST + "/recuperarCategorias", Categoria[].class);
		
		Categoria[] categorias = response.getBody();
		
		return Arrays.asList(categorias);

	}

}

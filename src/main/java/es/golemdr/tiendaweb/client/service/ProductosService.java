package es.golemdr.tiendaweb.client.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.golemdr.tiendaweb.client.domain.Producto;


@Service
public class ProductosService {
	
	private final RestTemplate restTemplate;
	
    public ProductosService (){
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }
	
	public List<Producto> getProductos(){
		
		// TODO - Quitar el harcode de la URI de los servicios
		
		ResponseEntity<Producto[]> response = restTemplate.getForEntity("http://localhost:8888/listadoProductos", Producto[].class);
		
		Producto[] productos = response.getBody();
		
		return Arrays.asList(productos);

	}
	
	
	
	public URI insertarProducto(Producto producto) {
		
		return restTemplate.postForLocation("http://localhost:8888/crearProducto", producto);
		
	}

	
	public void actualizarProducto(Producto producto) {
		
		restTemplate.put("http://localhost:8888/actualizarProducto", producto);
		
	}
	
	public Producto getById(Long idProducto) {
	
		return restTemplate.getForObject("http://localhost:8888/recuperarProducto" + idProducto.toString(), Producto.class);
		 
	}

	
	public void borrarProducto(Long idProducto) {
	
		restTemplate.delete("http://localhost:8888/borrarProducto" + idProducto.toString());
		
	}	

}

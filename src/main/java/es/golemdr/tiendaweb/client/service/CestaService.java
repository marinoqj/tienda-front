package es.golemdr.tiendaweb.client.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.golemdr.tiendaweb.client.domain.Cliente;
import es.golemdr.tiendaweb.client.domain.Pedido;
import es.golemdr.tiendaweb.client.domain.Producto;

@Service
public class CestaService {
	
	//@Value("${server.name}")
	private String SERVER = "http://localhost";
	
	//@Value("${server.port}")
	private String PORT = "8888";	
	
	private String HOST = SERVER + ":" + PORT;
	
	private final RestTemplate restTemplate;
	
    public CestaService (){
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }
	
	public List<Producto> recuperarProductosCategoria(Long idCategoria){
		
		// TODO - Quitar el harcode de la URI de los servicios
		
		ResponseEntity<Producto[]> response = restTemplate.getForEntity(HOST + "/recuperarProductosCategoria" + idCategoria, Producto[].class);
		
		Producto[] productos = response.getBody();
		
		return Arrays.asList(productos);

	}
		
	public Cliente recuperarClienteDNI(String dni){
		
		// TODO - Quitar el harcode de la URI de los servicios
		
		Cliente resultado = null;
		
		try {
			
			resultado = restTemplate.getForObject(HOST + "/recuperarClienteDNI" + dni, Cliente.class);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return resultado;

	}
	
	public URI insertarPedido(Pedido pedido) {
		
		// TODO - Quitar el harcode de la URI de los servicios
		
		return restTemplate.postForLocation(HOST + "/crearPedido", pedido);
		
	}
	
	public String checkEstado() {
		
		System.out.println("El servidor es: " + HOST);
		
		return restTemplate.getForObject(HOST + "/checkEstado", String.class);
		 
	}

}

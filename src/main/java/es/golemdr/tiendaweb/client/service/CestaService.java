package es.golemdr.tiendaweb.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.golemdr.tiendaweb.client.domain.Producto;

@Service
public class CestaService {
	
	public List<Producto> recuperarProductosCategoria(Long idCategoria){
		
		List<Producto> productos = new ArrayList<Producto>();
		
		Producto producto1 = new Producto();
		producto1.setIdProducto(1L);
		producto1.setNombre("Patatas");
		producto1.setPrecio("1,59");
		
		Producto producto2 = new Producto();
		producto2.setIdProducto(2L);
		producto2.setNombre("Perejil");
		producto2.setPrecio("10,5");
		
		Producto producto3 = new Producto();
		producto3.setIdProducto(3L);
		producto3.setNombre("Limones");
		producto3.setPrecio("2,10");
		
		Producto producto4 = new Producto();
		producto4.setIdProducto(4L);
		producto4.setNombre("Peras");
		producto4.setPrecio("2,45");
		
		
		productos.add(producto1);
		productos.add(producto2);
		productos.add(producto3);
		productos.add(producto4);

		
		return productos;
	}

}

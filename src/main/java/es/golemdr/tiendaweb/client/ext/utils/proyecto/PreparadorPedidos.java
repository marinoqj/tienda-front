package es.golemdr.tiendaweb.client.ext.utils.proyecto;

import org.apache.commons.math3.util.Precision;

import es.golemdr.tiendaweb.client.domain.Detalle;
import es.golemdr.tiendaweb.client.domain.Pedido;

public class PreparadorPedidos {
	
	public static void eliminarProducto(Pedido pedido, Long idProducto) {
		
		
		for(Detalle unDetalle : pedido.getDetalles()) {
			
			if(unDetalle.getProducto().getIdProducto().longValue() == idProducto.longValue()) {
				
				double nuevoTotal = pedido.getTotal() - (unDetalle.getCantidad() * unDetalle.getProducto().getPrecio());
				pedido.setTotal(Precision.round(nuevoTotal, 2));
				
				pedido.setNumArticulos(pedido.getNumArticulos() - 1);
				
				pedido.getDetalles().remove(unDetalle);
				
				break;
			}
			
		}
		
	}
	
	public static void incrementarProducto(Pedido pedido, Long idProducto) {
		
		
		for(Detalle unDetalle : pedido.getDetalles()) {
			
			if(unDetalle.getProducto().getIdProducto().longValue() == idProducto.longValue()) {
				
				unDetalle.setCantidad(unDetalle.getCantidad() + 1);
				
				double nuevoTotal = pedido.getTotal() + (unDetalle.getProducto().getPrecio());
				pedido.setTotal(Precision.round(nuevoTotal, 2));
				
				pedido.setNumArticulos(pedido.getNumArticulos() + 1);
				
				break;
			}
			
		}
		
	}
	
	public static void reducirProducto(Pedido pedido, Long idProducto) {
		
		
		for(Detalle unDetalle : pedido.getDetalles()) {
			
			if(unDetalle.getProducto().getIdProducto().longValue() == idProducto.longValue()) {
				
				unDetalle.setCantidad(unDetalle.getCantidad() - 1);
				
				double nuevoTotal = pedido.getTotal() - (unDetalle.getProducto().getPrecio());
				pedido.setTotal(Precision.round(nuevoTotal, 2));
				
				pedido.setNumArticulos(pedido.getNumArticulos() - 1);
				
				break;
			}
			
		}
		
	}

}

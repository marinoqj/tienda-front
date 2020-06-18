package es.golemdr.tiendaweb.client.domain;



import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



public class ProductoForm {
	

	private Long idProducto;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	@DecimalMin(value="0.01")
	private BigDecimal precio;  // Utilizo BigDecimal porque sino no puedo usar la anotación DecimalMin
	
	@NotEmpty
	private String nombreFoto;
	
	@NotEmpty
	private String idCategoria;

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getNombreFoto() {
		return nombreFoto;
	}

	public void setNombreFoto(String nombreFoto) {
		this.nombreFoto = nombreFoto;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	


	
}

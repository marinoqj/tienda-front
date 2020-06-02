package es.golemdr.tiendaweb.client.controller.constantes;


public class UrlConstants {

	public static final String SUFIJO_PAGINACION = 	"{inicio}.do";
	public static final String URL_LOGIN = "/login.do";
	public static final String URL_DENIED = "/denied.do";
	public static final String URL_LOGIN_CONTROLLER = "/loginController.do";
	public static final String URL_LOGIN_FAILURE = "/login-failure.do";	
	public static final String URL_HOME = "/home.do";

	
	// Cesta
	public static final String URL_PRODUCTOS_CATEGORIA = "/cesta/recuperarProductosCategoria{idCategoria}.do";
	
	
	// Productos
	public static final String URL_LISTADO_PRODUCTOS = "/listadoProductos" + SUFIJO_PAGINACION;	
	public static final String URL_LISTADO_PRODUCTOS_FILTRADO = "/listadoProductosFiltrado" + SUFIJO_PAGINACION;
	public static final String URL_ALTA_PRODUCTO = "/altaProducto.do";
	public static final String URL_INSERTAR_PRODUCTO = "/insertarProducto.do";
	public static final String URL_EDITAR_PRODUCTO = "/editarProducto.do";
	public static final String URL_ACTUALIZAR_PRODUCTO = "/actualizarProducto.do";
	public static final String URL_BORRAR_PRODUCTO = "/borrarProducto.do";	
	
	
	
}
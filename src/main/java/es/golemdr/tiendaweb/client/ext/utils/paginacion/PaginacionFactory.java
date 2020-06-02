package es.golemdr.tiendaweb.client.ext.utils.paginacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class PaginacionFactory {
	
	private PaginacionFactory(){}

	
	public static PaginacionBean getPaginacionBean(HttpServletRequest request){
		
		PaginacionBean paginacion = null;
		
		HttpSession session = request.getSession(false);
		
		if(session != null) {

			 paginacion = (PaginacionBean)session.getAttribute("paginacion");
			
			
			if(paginacion == null){
				paginacion = new PaginacionBean();
				session.setAttribute("paginacion",paginacion);
			}

		// Añado este else para que funcionen los tests	
		}else {
			
			paginacion = new PaginacionBean();
		}
		
		
		return paginacion;
		
	}

	
	public static void setElementosXPagina(int elementosXpagina,HttpServletRequest request ){
		
		PaginacionBean paginacion = getPaginacionBean(request);
		
		paginacion.setElementosXpagina(elementosXpagina);
		
	}
	
}

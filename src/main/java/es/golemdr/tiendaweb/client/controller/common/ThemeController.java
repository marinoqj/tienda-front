package es.golemdr.tiendaweb.client.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.theme.SessionThemeResolver;

import es.golemdr.tiendaweb.client.ext.utils.Constantes;




@Controller
public class ThemeController {

	@Resource(name="themeResolver")
	private SessionThemeResolver str;
	
	
	@RequestMapping(value="/themeController{tema}.do", method=RequestMethod.GET)
	public String cambiarTema(@PathVariable("tema") String tema,HttpServletRequest request,HttpServletResponse response) {
		
		
		if(tema != null){
			
			//incluyo el nombre del paquete
			tema = Constantes.PAQUETE_THEMES + tema;
			
			// Seteamos ese nuevo tema a la sesión
			str.setThemeName(request, response, tema);
		
		}

		return "Home";
	}
}

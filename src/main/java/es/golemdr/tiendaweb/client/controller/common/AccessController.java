package es.golemdr.tiendaweb.client.controller.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.golemdr.tiendaweb.client.controller.constantes.ForwardConstants;
import es.golemdr.tiendaweb.client.controller.constantes.UrlConstants;


@Controller
@RequestMapping
public class AccessController {
	
	private static final Log logger = LogFactory.getLog(AccessController.class);

	
	@RequestMapping(value=UrlConstants.URL_LOGIN)
	public String login(Model model, @RequestParam(required=false) String mensaje) {		

		model.addAttribute("mensaje", mensaje);
		
		return ForwardConstants.FWD_LOGIN;
	}
	
	@RequestMapping(value = UrlConstants.URL_DENIED)
 	public String denied() {
		
		return ForwardConstants.FWD_ACCESO_DENEGADO;
	}
	
	
	@RequestMapping(value = UrlConstants.URL_LOGIN_FAILURE)
 	public String loginFailure(Model model) {
		
		String mensaje = "usuario.incorrecto";
		
		model.addAttribute("mensaje", mensaje);
		
		return ForwardConstants.FWD_LOGIN;
	}
	
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		
		logger.debug("Paso por logoutSuccess");
		
		String message = "Logout Success!";
		return "redirect:/login?message="+message;
	}
	
}

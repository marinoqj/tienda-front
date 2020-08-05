package es.golemdr.tiendaweb.client.config;

import java.util.Properties;

import javax.servlet.Filter;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.theme.SessionThemeResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

import es.golemdr.tiendaweb.client.controller.views.DownloadFileView;
import es.golemdr.tiendaweb.client.controller.views.ExcelView;
import es.golemdr.tiendaweb.client.ext.aop.TraceInterceptor;
import es.golemdr.tiendaweb.client.ext.exceptions.resolver.CustomExceptionResolver;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan("es.golemdr.tiendaweb.client")
@PropertySource({ "classpath:es/golemdr/tiendaweb/client/application.properties" })
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public ExcelView excel(){
		ExcelView excel = new ExcelView();
		return excel;
	}
	
	@Bean
	public DownloadFileView download(){
		DownloadFileView download = new DownloadFileView();
		return download;
	}
	
	
	/**
	 * Equivalente a <mvc:annotation-driven content-negotiation-manager="contentNegotiationManager" />
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	    configurer.favorPathExtension(true).
	    favorParameter(false).
	    ignoreAcceptHeader(true).
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON); 
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/classes/es/golemdr/tiendaweb/client/config/tiles-defs.xml");
		
		return tilesConfigurer;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// Equivalente a: <bean id="tilesViewResolver" .../>
		registry.tiles();
		
		// Equivalente a: <bean id="jspViewResolver" .../>
		registry.jsp()
				.prefix("/WEB-INF/jsp/")
				.suffix(".jsp")
				.viewNames("jsp/*");
	}
	
//	@Bean
//	public UrlBasedViewResolver tilesViewResolver() {
//		UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
//		tilesViewResolver.setOrder(1);
//		tilesViewResolver.setViewClass(TilesView.class);
//		
//		return tilesViewResolver;
//	}
	
//	@Bean
//	public InternalResourceViewResolver jspViewResolver() {
//		InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
//		jspViewResolver.setOrder(2);
//		jspViewResolver.setPrefix("/WEB-INF/jsp/");
//		jspViewResolver.setSuffix(".jsp");
//		jspViewResolver.setViewNames("jsp/*");
//		
//		return jspViewResolver;
//	}
	
	
	
	@Bean 
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10_000_000); // Le pongo los números con _ para mejorar la lectura (^_^)!
		
		return multipartResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:es/golemdr/tiendaweb/client/messages/ApplicationResources");
		messageSource.setCacheSeconds(0);
		
		return messageSource;
	}
	
	@Bean
	public SessionThemeResolver themeResolver() {
		SessionThemeResolver themeResolver = new SessionThemeResolver();
		themeResolver.setDefaultThemeName("es.golemdr.tiendaweb.client.themes.tema_a");
		
		return themeResolver;
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		
		return localeResolver;
	}
	
	@Bean
	public CustomExceptionResolver customExceptionResolver() {
		CustomExceptionResolver customExceptionResolver = new CustomExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("java.lang.Exception", "ErrorGenerico");
		mappings.setProperty("es.golemdr.tiendaweb.client.ext.exceptions.LoginException", "Login");
		
		customExceptionResolver.setExceptionMappings(mappings);
		
		return customExceptionResolver;
	}
	
	@Bean
	public TraceInterceptor customizableTraceInterceptor() {
		TraceInterceptor customizableTraceInterceptor = new TraceInterceptor();
		customizableTraceInterceptor.setUseDynamicLogger(true);
		customizableTraceInterceptor.setEnterMessage("Entrando $[targetClassShortName].$[methodName]($[arguments])");
		customizableTraceInterceptor.setExitMessage("Saliendo $[targetClassShortName].$[methodName](): $[returnValue]");

		return customizableTraceInterceptor;
	}	
	
	/**
	 * Es equivalente a:
	 * 
	 *	<aop:config>
	 *	  <aop:advisor advice-ref="customizableTraceInterceptor" pointcut="execution(public * es.golemdr.tiendaweb.client.controller..*(..))"/>
	 *	<aop:config>
	 */
	@Bean
    public Advisor controllerAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * es.golemdr.tiendaweb.client.controller..*(..))");
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }
	
	/**
	 * Es equivalente a:
	 * 
	 *	<aop:config>
	 *	  <aop:advisor advice-ref="customizableTraceInterceptor" pointcut="execution(public * es.golemdr.tiendaweb.client.service..*(..))"/>
	 *	<aop:config>
	 */	
	@Bean
    public Advisor serviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * es.golemdr.tiendaweb.client.service..*(..))");
        return new DefaultPointcutAdvisor(pointcut, customizableTraceInterceptor());
    }	
	
	
	@Bean
	public JavaMailSenderImpl mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("localhost");
		mailSender.setPort(27);
		
		return mailSender;
	}

	/**
	 * Le decimos a Spring que nos configure un controlador, de forma "automágica" para la página de inicio "index.jsp"
	 * 
	 * Sería algo equivalente a:
	 * (web.xml)
	 * 
	 * 	<welcome-file-list>
	 *		<welcome-file>index.jsp</welcome-file>
	 *	</welcome-file-list>
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	
	/**
	 * Añadimos el filtro org.springframework.web.filter.CharacterEncodingFilter, que se expecifica en web.xml
	 * 
	 *	<filter>
	 *		<filter-name>characterEncodingFilter</filter-name>
	 *		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	 *			.
	 *			.
	 *	</filter>
	 */
	@Bean
	public FilterRegistrationBean<Filter> characterEncodingRegistration() {
	    FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
	    registration.setFilter(characterEncodingFilter());
	    registration.addUrlPatterns("/*");
	    registration.setName("characterEncodingFilter");
	    registration.setOrder(1);
	    
	    return registration;
	} 

	public Filter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
	    return filter;
	}
	

}

// Notas sobre las anotaciones:
// ============================
//	@Configuration --> Indica a Spring que contiene definiciones de @Beans. 
//		A grandes rasgos sustituye a los ficheros xml de configuración del contexto de la aplicación (aplication-context.xml)
//	@EnableWebMvc --> Añade la infraestructura para que la aplicación soporte el modelo MVC
//	@EnableAspectJAutoProxy --> equivalente a <aop:aspectj-autoproxy/> (fichero: trace-context.xml)
//	@ComponentScan --> equivalente a <context:component-scan>. Al ser recursiva la búsqueda no hace falta nada más, aunque para dejar
//		la configuración igual que en el antiguo spring-context.xml habría que poner:
//			@ComponentScan(basePackages = {"es.golemdr.tiendaweb.client.cotroller", "es.golemdr.tiendaweb.client.service"})
//	@PropertySource --> Configura un objeto Environment en el que se carga uno o varios ficheros properties. Ver ejemplo de uso en la propia clase
//		El objeto Environment "vive" en el contenedor de Beans, ya que forma parte de la arquitectura de Spring. Sólo hay que recuperarlo
//		del contenedor con @Autowired
	

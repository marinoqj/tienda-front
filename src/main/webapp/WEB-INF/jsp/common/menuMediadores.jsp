<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>

			<!-- Menú -->
			
			<nav class="navbar navbar-expand-lg navbar-light fixed-top scrolling-navbar" style="background-color: #e3f2fd;">
			<div class="container">
			  <a class="navbar-brand" href="#">
			  	<img src='<spring:url value="/static/imagenes/logo.png"/>' height="50" class="d-inline-block align-top">
			  </a>
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			        <a class="nav-link" href='<spring:url value="/home.do"/>'>Home <span class="sr-only">(current)</span></a>
			      </li>
					<sec:authorize access="hasAuthority('Gestor')">   
				      <li class="nav-item dropdown active">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Gestor
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href='<spring:url value="/sec/listadoConstantes1.do"/>'><spring:message code="label.constantes"/></a>
							<a class="dropdown-item" href='<spring:url value="/sec/listadoMediadores1.do"/>'><spring:message code="label.mediadores"/></a> 	 							
				        </div>
				      </li>
				      <li class="nav-item dropdown active">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				          Catálogo
				        </a>
				        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href='<spring:url value="/verHistoricoJobs.do"/>'>Histórico Jobs</a>	
							<a class="dropdown-item" href='<spring:url value="/enviarMailBasico.do"/>'>Enviar mail básico</a>													 	 						
							<a class="dropdown-item" href='<spring:url value="/verMailForm.do"/>'>Enviar mail personalizado</a>
				        </div>
				      </li>						        
					</sec:authorize>			      
			    </ul>
			    <ul class="navbar-nav">
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle"  href="#" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
			          aria-haspopup="true" aria-expanded="false">
			          ${usuarioSesion.login} &nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-user-circle fa-lg"></i>
			        </a>
			        <div class="dropdown-menu dropdown-menu-right dropdown-default"
			          aria-labelledby="navbarDropdownMenuLink-333">
			          <a class="dropdown-item" href="#">Mi perfil</a>
			          <a class="dropdown-item" href='<spring:url value="/logout.do"/>'><spring:message code="label.logout"/></a>
			        </div>
			      </li>
			    </ul>
			  </div>
			  </div>
			</nav>			
						
			<!-- FIN Menú -->
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
			        <a class="nav-link" href="homeProtoWeb.do">Home <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Formularios
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="loginForm.do">Login</a> 
						<a class="dropdown-item" href="simple.do">Simple</a> 
						<a class="dropdown-item" href="complejo.do">Complejo</a>
						<a class="dropdown-item" href="pestanyas.do">Compuesto en pestañas</a> 
<!-- 						<a class="dropdown-item" href="#">Carrousel-steper</a>       -->
			        </div>
			      </li>
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Listados
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="listadoSencillo.do">Sencillo</a> 
						<a class="dropdown-item" href="listadoComplejo.do">Complejo</a>
						<a class="dropdown-item" href="listadoCards.do">Cards</a>
			        </div>
			      </li>
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Gráficos
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="barras.do">Barras</a> 
						<a class="dropdown-item" href="lineas.do">Líneas</a>
						<a class="dropdown-item" href="varios.do">Varios</a>
			        </div>
			      </li>	
		      
			    </ul>
			    <ul class="navbar-nav">
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle"  href="#" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
			          aria-haspopup="true" aria-expanded="false">
			          Margarita Salas &nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-user-circle fa-lg"></i>
			        </a>
			        <div class="dropdown-menu dropdown-menu-right dropdown-default"
			          aria-labelledby="navbarDropdownMenuLink-333">
			          <a class="dropdown-item" href="#">Mi perfil</a>
			          <a class="dropdown-item" href="#">Cerrar sesión</a>
			        </div>
			      </li>
			    </ul>
			  </div>
			  </div>
			</nav>			
						
			<!-- FIN Menú -->
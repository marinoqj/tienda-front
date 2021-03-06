<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>
<%-- <%@ page import="es.golemdr.tiendaweb.client.domain.Usuario" %> --%>
		
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
	
	
    <!-- Favicon-->
    <link rel="shortcut icon" href='<spring:url value="/static/imagenes/fav.png"/>' >
	
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/bootstrap.min.css" />' media="all" />
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/dataTables.bootstrap4.min.css" />' media="all" />
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/estilo.css" />' media="all" />


	<!-- FONTAWESOME 4.7.0 -->
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/all.min.css"/>' media="all" />
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/font-awesome.min.css"/>' media="all" />


	<!-- SCRIPTS -->
	<script type="text/javascript" src='<spring:url value="/static/js/jquery-3.3.1.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/js/popper.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/js/bootstrap.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/js/jquery.dataTables.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/js/dataTables.bootstrap4.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/js/Chart.min.js"/>' ></script>
	
	
<script>

function mostrarCapa(idCapa) {
	//alert("Estamos en mostraCapa");
	var capa = document.getElementById(idCapa);
	if (capa.style.display=="none") {
		capa.style.display = "block";
	}
}

function ocultarCapa(idCapa) {
	//alert("Estamos en ocultarCapa");
	var capa = document.getElementById(idCapa);
	if (capa.style.display=="block") {
		capa.style.display = "none";
	}
}


function anyadirProducto(id, price, name){

	
	$.getJSON('anyadirProducto.do', {idProducto : id, precio : price, nombre : name},function (data) {

		var json = data;
		var total = ""  + json.total;  // Hay que hacer que la variable sea de tipo String porque sino no funciona.
		
		var totalFormateado = total.replace(".",",");
		
		$("#cestaTotal").html("&nbsp;&nbsp;&nbsp;&nbsp;" + totalFormateado + "&nbsp;&euro;");
		$("#numArticulos").html(json.numArticulos);
	});
}

</script>
	
</head>
<body>
	<!-- Header -->
	<header>
		<!-- CONTENEDOR -->
		
<%-- 		
			<!-- CABECERA-->
			<DIV>
				<tiles:insertAttribute name="header" />
			</DIV>
			<!-- fin cabecera -->

 --%>
 
			<!-- Menú -->
			
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
			      <li class="nav-item dropdown active">
			        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			          Alimentación
			        </a>
			        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href='<spring:url value="/cesta/recuperarProductosCategoria1.do"/>'>Charcutería</a> 
						<a class="dropdown-item" href='<spring:url value="/cesta/recuperarProductosCategoria2.do"/>'>Pollería</a>
						<a class="dropdown-item" href='<spring:url value="/cesta/recuperarProductosCategoria3.do"/>'>Carnicería</a>
			        </div>
			      </li>
			      <li class="nav-item active">
			        <a class="nav-link" href='<spring:url value="/listadoProductos1.do"/>'>Productos</a>
			      </li>	
			    </ul>
			    <ul class="navbar-nav carrito" style="cursor:pointer">			    
			      <li class="nav-item">
			      <i class="fas fa-shopping-cart fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;
			      </li>	
			      <li class="nav-item">
			      <h5><span class="badge badge-danger"><div id="numArticulos">${pedido.numArticulos}</div></span></h5>&nbsp;&nbsp;&nbsp;&nbsp;
			      </li>
			      <li class="nav-item">
			      <div id="cestaTotal">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber type="number" pattern="#.##" value="${pedido.total}" /></div>
			      </li>	
			    </ul>			    
			  </div>
			  </div>
			</nav>			
						
			<!-- FIN Menú -->	
						
			<!-- FIN Menú -->




		
		<!-- FIN CONTENEDOR -->
	</header>
	<!-- / .Header -->


	<!-- Main layout-->
	<main>
		<div class="container">
		<br><br><br>
			<!-- CONTENIDO -->
			<!-- DIV id="contenido" -->
			<tiles:insertAttribute name="body" />
			<!-- /div -->
			<!-- FIN CONTENIDO -->
		</div>

		<br>
		<br>
		<br>
		<br>

	</main>
	<!-- / .Main layout-->


	<!--Footer-->
				<tiles:insertAttribute name="footer" />
	<!-- / .Footer-->

<script>

$(document).on('click', '.carrito', function(e){
	
	window.location.href = '<spring:url value="/cesta/listadoProductosPedido.do"/>'
	
	})
	
</script>

</body>
</html>


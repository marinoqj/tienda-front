<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp"%>


<!DOCTYPE html>
<html lang="es-ES">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Invetario de Aplicaciones</title>

<!-- Favicon-->
<link rel="shortcut icon"
	href='<spring:url value="/static/imagenes/fav.png"/>'>

<link rel="stylesheet" type="text/css"
	href='<spring:url value="/static/css/bootstrap.min.css" />' media="all" />
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/static/css/dataTables.bootstrap4.min.css" />'
	media="all" />
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/static/css/estilo.css" />' media="all" />


<!-- FONTAWESOME 4.7.0 -->
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/static/css/all.min.css"/>' media="all" />
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/static/css/font-awesome.min.css"/>'
	media="all" />


<!-- SCRIPTS -->
<script type="text/javascript"
	src='<spring:url value="/static/js/jquery-3.3.1.slim.min.js"/>'></script>
<script type="text/javascript"
	src='<spring:url value="/static/js/popper.min.js"/>'></script>
<script type="text/javascript"
	src='<spring:url value="/static/js/bootstrap.min.js"/>'></script>
<script type="text/javascript"
	src='<spring:url value="/static/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript"
	src='<spring:url value="/static/js/dataTables.bootstrap4.min.js"/>'></script>
<script type="text/javascript"
	src='<spring:url value="/static/js/Chart.min.js"/>'></script>






</head>
<body>

	<main>
	
		<nav class="navbar navbar-expand-lg navbar-light fixed-top scrolling-navbar" style="background-color: #e3f2fd;">
			<div class="container">
			  <a class="navbar-brand" href="#">
			  	<img src='<spring:url value="/static/imagenes/golem2.gif"/>' height="50" class="d-inline-block align-top">
			  </a>
			  <h4><b>Tienda web con arquitectura de microservicios</b></h4>
			</div>
		</nav>
	
		<div class="container">

			<br>


			<div class="row">
				<div class="col-md-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><i
								class="fas fa-list-ul fa-lg mr-2"></i></li>
						</ol>
					</nav>
				</div>
			</div>

			<br>
			<br>
			<br>
			
			
			<div class="row">
				<div class="col-md-12">
					Página incial <a href="home.do" class="btn btn-primary btn-sm">Comprar</a>
				</div>
			</div>


			<br>
			<br>
			<br>


		</div>
	</main>

    <footer class="page-footer fixed-bottom">
        <!-- Copyright -->
        <div class="footer-copyright text-center font-small">
            <div class="fondo-azul-claro pb-3">
                <hr>

                Contacto | Aviso legal | © 2020 Copyright: <a href="http://www.golemdr.es/">GolemDR </a>

            </div>
        </div>
        <!-- Copyright -->
    </footer>

</body>
</html>
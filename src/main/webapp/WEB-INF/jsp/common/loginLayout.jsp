<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="./static/css/estilos.css" media="all" />
	<link rel="stylesheet" type="text/css" href='<spring:url value="/static/css/bootstrap.min.css" />'media="all" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
<!-- CONTENEDOR -->	
<DIV id=contenedor>


<!-- CONTENIDO -->
<DIV id=contenido>
		<tiles:insertAttribute name="body"/>		
</div>
<!-- FIN CONTENIDO -->
</div>
<!-- FIN CONTENEDOR -->	

<!-- PIE -->
<DIV id=pie>
	<tiles:insertAttribute name="footer"/>
</DIV>
<!-- FIN PIE -->
	
		
</body>
</html>
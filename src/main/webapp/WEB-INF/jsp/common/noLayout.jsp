<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>
<%-- <%@ page import="es.golemdr.tiendaweb.client.domain.Usuario" %> --%>
		
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
	<title><tiles:insertAttribute name="title" ignore="true"/></title>
	
	<tiles:insertAttribute name="body"/>		
		
</body>
</html>
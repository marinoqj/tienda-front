<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>



<br>
<br>
<br>
<br>





<div class="row">
	<div class="col-md-3 col-lg-4">&nbsp;</div>
	<div class="col-md-6 col-lg-4">
		
 		<form name="formulario_login" id="formulario_login" action="login" method="post" novalidate="novalidate" class="shadow p-3 mb-5 bg-white rounded text-center border">	
 		<div class="p-4">

			<span class="h4 mb-4">Acceso a la aplicación: MEDIADORES</span>
			<br><br>
			<img src='<spring:url value="/static/imagenes/user-circle-solid.png"/>' height="100" width="100">
			<br><br>
			<!-- Usuario -->
			<input type="text" name="username" value="${usuario.login}" class="form-control mb-4" placeholder="Usuario"/>

			<!-- Password -->
			<input type="password" name="password" class="form-control mb-4" placeholder="Password" />

			<!-- Sign in button -->
			<button class="btn btn-primary btn-block btn-sm" type="submit">Entrar</button>

		</div>
		</form>
		
	</div>
	<div class="col-md-3 col-lg-4">&nbsp;</div>
</div>

<c:if  test="${not empty mensaje}">
	<div class="row">
		<div class="col-md-12 text-center" id="rojo"><spring:message code="${mensaje}" /></div>
	</div>
	
</c:if>	









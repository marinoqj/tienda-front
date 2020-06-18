<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>


<script>
function mostrarFormularioCompleto(){
	
	mostrarCapa("formularioCompleto");
	ocultarCapa("botonComprobar");
	ocultarCapa("msg1");
	mostrarCapa("dni");
	
	$("#msg2").html("Si es un usuario nuevo por favor rellene todos los campos para terminar el pedido. Gracias");

}

function mostarSoloDNI(){
	
	
	mostrarCapa("dni");
	ocultarCapa("formularioCompleto");
	mostrarCapa("botonComprobar");
	ocultarCapa("msg1");
	
	$("#msg2").html("Introduzca su DNI y confirme sus datos para terminar el pedido. Gracias");

}


function recuperarClienteDNI(){

	var inputDNI = document.getElementById("inputDNI");
	
 	document.formulario.dni.value = inputDNI.value;
 	document.formulario.action="recuperarClienteDNI.do";
 	document.formulario.submit();

}

</script>

<form name="formulario" method="post">
	<input type="hidden" name="dni"/>
</form>

	<form:form modelAttribute="cliente" action='terminarPedido.do' method="post">

	<div class="row">
		<div class="col-md-12">
			<div id="msg1" style="display:block">
				<br>
				<br>
				Para continuar, indíquenos por favor si es un usuario nuevo o si ya está registrado. Gracias
			</div>		
		</div>
	</div>

	<br>

<c:if test="${!existeUsuario}">
	<div class="form-row">
		<div class="custom-control custom-radio">
		  <input type="radio" id="customRadio1" name="tipoCliente" class="custom-control-input" onclick='mostarSoloDNI()'>
		  <label class="custom-control-label" for="customRadio1">Estoy registrado</label>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<div class="custom-control custom-radio">
		  <input type="radio" id="customRadio2" name="tipoCliente" class="custom-control-input" onclick='mostrarFormularioCompleto()'>
		  <label class="custom-control-label" for="customRadio2">Soy nuevo usuario</label>
		</div>	  
	</div>
</c:if>

	<br>
	<br>


	<div class="row">
		<div class="col-md-12">
			<div id="msg2"></div>		
		</div>
	</div>

	<br>
	
								<form:hidden path="idCliente"/>

						
								
								<div id="dni" style="display:none">														
								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="dni"><spring:message code="label.dni"/></label> <form:input path="dni" class="form-control" id="inputDNI" readonly="${existeUsuario}"/><form:errors path="dni" element="div" id="rojo"/>
									</div>
								</div>
								</div>

								<div id="formularioCompleto" style="display:none">

								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="nombre"><spring:message code="label.nombre.cliente"/></label> <form:input path="nombre" class="form-control" readonly="${existeUsuario}"/><form:errors path="nombre" element="div" id="rojo"/>
									</div>
								</div>
					

								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="apellidos"><spring:message code="label.apellidos"/></label> <form:input path="apellidos" class="form-control" readonly="${existeUsuario}"/><form:errors path="apellidos" element="div" id="rojo"/>
									</div>
								</div>								
								
								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="direccion"><spring:message code="label.direccion"/></label> <form:input path="direccion" class="form-control"/><form:errors path="direccion" element="div" id="rojo"/>
									</div>
								</div>	
								
								<div class="form-row">
									<div class="form-group col-md-12">
										<label for="telefono"><spring:message code="label.telefono"/></label> <form:input path="telefono" class="form-control"/><form:errors path="telefono" element="div" id="rojo"/>
									</div>
								</div>									
								
								<button class="btn btn-success btn-sm">&nbsp;&nbsp;Terminar pedido</button>															
					
								</div>

							</form:form>
							
							<div id="botonComprobar" style="display:block">
							
								<button class="btn btn-primary btn-sm" onclick="recuperarClienteDNI()">&nbsp;&nbsp;Comprobar</button>	
							
							</div>
							

<c:if test="${existeUsuario || formularioConErrores}">
<script>

mostrarFormularioCompleto();

$("#msg2").html("Puede modificar su teléfono o dirección en caso necesario, y terminar el pedido. Gracias");


</script>
</c:if>	

<c:if test="${!existeUsuario && formularioConErrores}">
<script>

mostrarFormularioCompleto();

$("#msg2").html("Por favor, rellene todos los campos obligatorios. Gracias");


</script>
</c:if>

<c:if test="${dniErroneo}">
<script>

$("#msg1").html("El DNI que nos ha facilitado no está registrado. Intenteló de nuevo o registrese como nuevo usuario. Gracias");


</script>
</c:if>	

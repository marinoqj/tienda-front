

 
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>


<script>
function eliminarProducto(idProducto){

	 	document.formulario.idProducto.value = idProducto;
	 	document.formulario.action="eliminarProducto.do";
	 	document.formulario.submit();

}

function incrementarProducto(idProducto){

 	document.formulario.idProducto.value = idProducto;
 	document.formulario.action="incrementarProducto.do";
 	document.formulario.submit();

}

function reducirProducto(idProducto){

 	document.formulario.idProducto.value = idProducto;
 	document.formulario.action="reducirProducto.do";
 	document.formulario.submit();

}

function mostarConfirmEliminarProducto(idProducto) {
    var message = '<spring:message code="confirmacion.borrar.producto"/>';
    
    $("#aceptarBorrar").attr("href", "javascript:eliminarProducto(" + idProducto + ");");
    
    mostrarConfirm(message);
}



function mostrarConfirm(message) {
    $('#alertModal').find('.modal-body p').html(message);
    $('#alertModal').modal('show');
} 
</script>


<!-- Warning Modal -->
<div id="alertModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
         <p></p>
      </div>
      <div class="modal-footer">         
         <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal"><i class="fas fa-times-circle"></i>&nbsp;&nbsp;Cancelar</button>
         <a class="btn btn-primary btn-sm" role="button" href="#" id="aceptarBorrar"><i class="fas fa-check-circle"></i>&nbsp;&nbsp;<spring:message code="button.aceptar" /></a>
      </div>
    </div>
  </div>
</div>

<!-- ./ Warning Modal -->

<form name="formulario" method="post">
	<input type="hidden" name="idProducto"/>
</form>
				
		<c:if  test="${!empty pedido}">           
		
		<br>
		
		<div class="row">
			<div class="col-md-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active"><i class="fas fa-shopping-cart fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Productos en la cesta</li>
					</ol>
				</nav>
			</div>
		</div>

        	  <!-- DataTables Example -->
              <table class="table table-hover">
				<thead class="blue lighten-4">
					<tr class="bg-light">	
					<th><spring:message code="label.nombre.producto"/></th>															
					<th><spring:message code="label.precio"/></th>																							
					<th align="center">Cantidad</th>
					<th>&nbsp;</th>
                  </tr>
                </thead>
                <tfoot>
                  <tr class="bg-light">
					<th>&nbsp;</th>																					
					<th>&nbsp;</th>																							
					<th align="center">Total</th>
					<th>${pedido.total}</th>
                  </tr>
                </tfoot>
                <tbody>
					<c:forEach items="${pedido.detalles}" var="detalle">
						<tr>
						
							<td>${detalle.producto.nombre}</td>						
						
							<td>${detalle.producto.precio}</td>		
							
							<td align="center"><i class="fas fa-minus-circle fa-lg" style="color:gray;cursor:pointer" onclick="reducirProducto(${detalle.producto.idProducto})"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${detalle.cantidad}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="fas fa-plus-circle fa-lg" style="color:green;cursor:pointer" onclick="incrementarProducto(${detalle.producto.idProducto})"></i></td>	
							
							<td>${detalle.producto.precio * detalle.cantidad} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="fas fa-times-circle fa-lg" style="color:red;cursor:pointer" onclick="mostarConfirmEliminarProducto(${detalle.producto.idProducto})"></i></td>						
																
						</tr>
					</c:forEach>
                </tbody>
              </table>		
	
			<br>
			
			
			<div class="row">
				<div class="col-md-10">&nbsp;</div>
				<div class="col-md-2">
					<a href="home.do" class="btn btn-primary btn-sm">Confirmar pedido</a>
				</div>
			</div>		
			
		</c:if>

	
		<c:if  test="${empty pedido.detalles}">
		
			<br>
			<br>
			<br>
			<br>
			<center>El pedido no tiene ningún producto...</center>
		</c:if>
	
		<br>
		<br>
	
	
		

	
		
		
<script>

$(document).ready(function() {
	  $('#dataTable').DataTable();	 
	});


</script>		

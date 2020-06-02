

 
<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>


<script>
function borrarProducto(idProducto){

	 	document.formulario.idProducto.value = idProducto;
	 	document.formulario.action="borrarProducto.do";
	 	document.formulario.submit();

}
function editarProducto(idProducto){
	 
 	document.formulario.idProducto.value = idProducto;
 	document.formulario.action="editarProducto.do";
 	document.formulario.submit();
 

}
function altaProducto(){

	window.location.href= "altaProducto.do";
	
}

function verBusquedaProducto(){

	window.location.href= "verBusquedaProducto.do";
	
}

function mostarConfirmBorrarProducto(idProducto) {
    var message = '<spring:message code="confirmacion.borrar.producto"/>';
    
    $("#aceptarBorrar").attr("href", "javascript:borrarProducto(" + idProducto + ");");
    
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
				
		<c:if  test="${!empty productos}">           
		
		<br>
		
		<div class="row">
			<div class="col-md-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item active"><i
							class="fas fa-list-alt fa-lg mr-1"></i><i
							class="fas fa-users fa-lg mr-2"></i>Listado de productos</li>
					</ol>
				</nav>
			</div>
		</div>
		
		
		
		
		
		
		



	<table class="table table-hover">
		<thead class="blue lighten-4">
			<tr class="bg-light">	
		    				
					<th><spring:message code="label.nombre.producto"/></th>					
							
					<th><spring:message code="label.precio"/></th>					
																			
					<th width="10%">&nbsp;</th>
				</tr> 
			</thead>
			<tbody>	
		<c:forEach items="${productos}" var="producto">
			<tr>
			
				<td>${producto.nombre}</td>								
			
				<td>${producto.precio}</td>								
								
				
				<td>
					<div>
							<label data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <span style="cursor: pointer;"><i
									class="fas fa-cog fa-lg"></i></span>
							</label>
							<ul class="dropdown-menu dropdown-primary">
								<li class="nav-item dropdown"><a class="dropdown-item"
									href="javascript:editarProducto('${producto.idProducto}')"><spring:message code="label.editar"/></a></li>
								<li class="nav-item dropdown"><a class="dropdown-item"
									href="javascript:mostarConfirmBorrarProducto('${producto.idProducto}')"><spring:message code="label.borrar"/></a></li>
							</ul>
						</div>				  
				</td>						
			</tr>
		</c:forEach>
			</tbody>
			</table>
		
			
		</c:if>
		
		<c:if  test="${empty productos}">
		
			<br>
			<br>
			<br>
			<br>
			<center>No hay productos que mostrar...</center>
		</c:if>
	
		<div class="row">
		<div class="col-md-5">
		<!-- 	<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#nuevoFormulario"><i class="fas fa-plus-circle"></i>&nbsp;&nbsp;Nuevo</button> -->
			<button type="button" class="btn btn-primary btn-sm" onclick="javascript:altaProducto();"><i class="fas fa-plus-circle"></i>&nbsp;&nbsp;Nuevo</button>
			<button type="button" class="btn btn-success btn-sm"><i class="fas fa-search"></i> &nbsp;&nbsp;Buscar</button>
		</div>
		<div class="col-md-3">      
			<button type="button" class="btn btn-outline-blue btn-rounded btn-sm px-2">
		        <i class="fas fa-file-pdf fa-2x"></i>
		      </button>
		      <button type="button" class="btn btn-outline-blue btn-rounded btn-sm px-2">
		        <i class="fas fa-file-excel fa-2x"></i>
		      </button>
		</div>
		<div class="col-md-4">
					<c:if test="${hayFiltro eq false}">
						<mistags:paginacion accion="listadoProductos" />
					</c:if>
		
					<c:if test="${hayFiltro eq true}">
						<mistags:paginacion accion="listadoProductosFiltrado" />
					</c:if>
		</div>
		</div>		
		
		
		

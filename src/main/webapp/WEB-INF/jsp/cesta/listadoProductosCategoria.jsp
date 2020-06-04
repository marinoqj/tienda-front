<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp"%>


<br>
<br>
<br>


	<div class="row">
	
	<c:forEach items="${productos}" var="producto">
		<div class="col-lg-3 mb-5">
			<!-- Card -->
			<div class="card">

				<!-- Card image -->
				<img class="card-img-top"
					src='<spring:url value="/static/imagenes/cesta/jamon.jpg"/>' />

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<span class="card-title">
						<a>${producto.nombre}</a>
					</span>
					<br>
					<!-- Text -->
					<span class="card-text">${producto.precio} &euro;</span><br>
					<br>
					<!-- Button -->
					<a href="#" class="btn btn-primary btn-sm btn-comprar">Comprar</a>

				</div>

			</div>
			<!-- Card -->
		</div>
	</c:forEach>
	
	</div>
	
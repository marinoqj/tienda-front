<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<%@ tag body-content="empty" %>
<%@ attribute name="accion" required="true" %>	

<!-- 
<c:set var="fin" value="${paginacion.inicio + paginacion.elementosXpagina}"/>
<c:set var="paginaActual" value="${(paginacion.inicio + paginacion.elementosXpagina - 1)/paginacion.elementosXpagina}"/>
 -->
<c:if test="${(paginacion.totalRegistros % paginacion.elementosXpagina) != 0}">
	<c:set var="ultimo" value="${paginacion.totalRegistros -(paginacion.totalRegistros % paginacion.elementosXpagina) + 1}"/>
</c:if>
<c:if test="${(paginacion.totalRegistros % paginacion.elementosXpagina) == 0}">
	<c:set var="ultimo" value="${paginacion.totalRegistros - paginacion.elementosXpagina + 1}"/>
</c:if>
	
		

    <ul class="pagination pg-blue justify-content-end">
	<c:if test="${(paginacion.totalPaginas) > 1}">
			<c:if test="${paginacion.paginaActual == 1}">	
			    <li class="page-item disabled"><a class="page-link">Primero</a></li>
			    <li class="page-item disabled">
			      <a class="page-link" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Previous</span>
			      </a>
			    </li>			
			</c:if>		
			<c:if test="${(paginacion.inicio - paginacion.elementosXpagina) >= 0}">
			    <li class="page-item"><a href='<c:out value="${accion}"/>1.do' class="page-link">Primero</a></li>
			    <li class="page-item">
			      <a href='<c:out value="${accion}"/><c:out value="${paginacion.inicio - paginacion.elementosXpagina}"/>.do' class="page-link" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			        <span class="sr-only">Previous</span>
			      </a>
			    </li>			
			</c:if>
				<li class="page-item active"><a class="page-link"><fmt:formatNumber>${paginacion.paginaActual}</fmt:formatNumber></a></li>				
			<c:if test="${paginacion.totalRegistros > paginacion.elementosXpagina && paginacion.fin <= paginacion.totalRegistros}">	
			    <li class="page-item">
			      <a href='<c:out value="${accion}"/><c:out value="${paginacion.inicio + paginacion.elementosXpagina}"/>.do' class="page-link" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			        <span class="sr-only">Next</span>
			      </a>
			    </li>
			    <li class="page-item"><a href='<c:out value="${accion}"/><c:out value="${ultimo}"/>.do' class="page-link">Último</a></li>
			</c:if>
			<c:if test="${paginacion.paginaActual == paginacion.totalPaginas}">	
			    <li class="page-item disabled">
			      <a class="page-link" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			        <span class="sr-only">Next</span>
			      </a>
			    </li>
			    <li class="page-item disabled"><a class="page-link">Último</a></li>
			</c:if>	
			<li class="page-item"><a class="page-link">(<c:out value="${paginacion.totalPaginas}"/> págs.)</a></li>		
	</c:if>
	</ul>


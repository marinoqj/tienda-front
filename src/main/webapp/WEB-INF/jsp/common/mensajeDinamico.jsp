<%@ include file="/WEB-INF/jsp/common/include_taglib.jsp" %>

		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
		
<c:if test="${not empty mensaje}">
	<div class="row alert alert-success">
		<div class="col-2">&nbsp;</div>
		<div class="col-8">
				<i class="fas fa-info-circle fa-2x"></i>&nbsp;&nbsp;&nbsp;${mensaje}
		</div>
		<div class="col-2">&nbsp;</div>
	</div>
	<br><br><br>	
</c:if>
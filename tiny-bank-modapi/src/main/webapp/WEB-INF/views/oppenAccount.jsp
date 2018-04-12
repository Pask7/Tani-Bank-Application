<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>

	<div class="container">
	
	<form:form method="post" modelAttribute="account">
		<form:hidden path="id"/>
			
			<fieldset class="form-group">
				<form:label path="displayName">Display Name</form:label> 
				<form:input path="displayName" type="text"
					class="form-control" required="required"/>
				<form:errors path="displayName" cssClass="text-warning"/>
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
			
		
	</div>
<%@ include file = "common/footer.jspf" %>
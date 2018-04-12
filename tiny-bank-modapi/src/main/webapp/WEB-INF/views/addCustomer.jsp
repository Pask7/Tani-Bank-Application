<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>

	<div class="container">
	
	<form:form method="post" modelAttribute="customer">
		<form:hidden path="customerId"/>

			<fieldset class="form-group">
				<form:label path="name">Name</form:label> 
				<form:input path="name" type="text"
					class="form-control" required="required"/>
				<form:errors path="name" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="surname">Surname</form:label> 
				<form:input path="surname" type="text"
					class="form-control" required="required"/>
				<form:errors path="surname" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="birthDate">Birth Date</form:label> 
				<form:input path="birthDate"  type="text"
					class="form-control" required="required"/>
				<form:errors path="birthDate" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="address">Address</form:label> 
				<form:input path="address" type="text"
					class="form-control" required="required"/>
				<form:errors path="address" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="accounts">Accounts</form:label> 
				<form:input path="accounts" type="text"
					class="form-control" required="required"/>
				<form:errors path="accounts" cssClass="text-warning"/>
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
			
		
	</div>
<%@ include file = "common/footer.jspf" %>
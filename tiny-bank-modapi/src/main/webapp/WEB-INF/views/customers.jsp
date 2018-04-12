
<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>
<div class="container">
<H1>Our Customers</H1>
		<table class="table table-striped">
			<caption> These are our customers </caption>
			<thead>
				<tr>
					<th>Customer Id</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Birth Date</th>
					<th>Address</th>
					<th>Accounts</th>
					<th>Open Account</th>
					<th>Delete Customer</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${customers}" var ="customer">
			
				<tr>
					<td>${customer.customerId}</td>
					<td>${customer.name}</td>
					<td>${customer.surname}</td>
					<td><fmt:formatDate value="${customer.birthDate}" pattern="dd/mm/yyyy"/></td>
					<td>${customer.address}</td>
					<td>${customer.accounts}</td>
					<td><a type="button " class = "btn btn-success" href ="/oppenAccount?customerId=${customer.customerId}">Open Account</a></td>
					<td><a type="button " class = "btn btn-warning" href ="/delete?customerId=${customer.customerId}">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
<br>
<br>
<div><a class="button" href = "/addCustomer"> Add Customer</a></div>
</div>
<%@ include file = "common/footer.jspf" %>
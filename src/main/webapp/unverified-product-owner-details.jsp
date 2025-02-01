<%@page import="java.util.List"%>
<%@page
	import="com.samdell.E_Commerce_JEE_Project.dao.impl.ProductOwnerDaoImpl"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.dao.ProductOwnerDao"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.entity.ProductOwner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Unverified product Owner Details here</title>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/8.2.0/mdb.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<style>
body {
	background-color: #f8f9fa;
}

.table-container {
	max-width: 900px;
	margin: 30px auto;
	background: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>

	<%
	ProductOwnerDao dao = new ProductOwnerDaoImpl();

	List<ProductOwner> owners = dao.getAllNonVerifiedProductOwnerDao();
	%>

	<div class="container table-container">
		<h2 class="text-center mb-4">Product_owner verification table</h2>

		<div class="table-responsive">
			<table
				class="table table-striped table-hover text-center align-middle">
				<thead class="table-dark">
					<tr>
						<th scope="col">Owner-Id</th>
						<th scope="col">Owner-Name</th>
						<th scope="col">Owner-Email</th>
						<th scope="col">Owner-verification-status</th>
						<th scope="col">Owner-Verification</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (ProductOwner owner : owners) {
					%>
					<tr>
						<td><%=owner.getProductOwnerId()%></td>
						<td><%=owner.getProductOwnerName()%></td>
						<td><%=owner.getProductOwnerEmail()%></td>
						<td><span class="badge badge-danger rounded-pill d-inline"><%=owner.getProductOwnerVerify()%></span></td>
						<td><a href="ownerVerify?id=<%=owner.getProductOwnerId()%>"
							class="btn btn-success btn-sm">VERIFY</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
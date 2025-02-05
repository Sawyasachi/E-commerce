<%@page import="java.io.OutputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.dao.ProductDao"%>
<%@page
	import="com.samdell.E_Commerce_JEE_Project.dao.impl.ProductDaoImpl"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.dao.ProductOwnerDao"%>
<%@page
	import="com.samdell.E_Commerce_JEE_Project.dao.impl.ProductOwnerDaoImpl"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.samdell.E_Commerce_JEE_Project.entity.ProductOwner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product owner here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<style>
.profile-card {
	max-width: 400px;
	margin: auto;
	text-align: center;
	padding: 20px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	border-radius: 10px;
	background: white;
}

.btn-action {
	margin: 5px;
}
</style>
</head>
<body>
	<%
	ProductOwner productOwner = (ProductOwner) session.getAttribute("session");
	String msg = (String) request.getAttribute("msg");
	ProductDao productDao = new ProductDaoImpl();

	List<Product> products = productDao.displayAllProductDetailDao();
	%>


	<%
	if (productOwner != null) {
	%>

	<div class="container mt-4">
		<h2 class="text-center">Product Owner Home</h2>

		<%
		if (msg != null) {
		%>

		<h4><%=msg%></h4>
		<%
		}
		%>

		<!-- Profile Card -->
		<div class="profile-card bg-light">
			<!-- <img src="https://via.placeholder.com/150"
				class="rounded-circle mb-3" alt="Profile Picture"> -->
			<h4>
				Id :<%=productOwner.getProductOwnerId()%></h4>
			<h4>
				Name :<%=productOwner.getProductOwnerName()%></h4>
			<p>
				Email:
				<%=productOwner.getProductOwnerEmail()%></p>
			<p>
				Verify:
				<%=productOwner.getProductOwnerVerify()%></p>
			<button class="btn btn-warning" data-bs-toggle="modal"
				data-bs-target="#updateProductOwnerDetail">
				<i class="fa fa-edit"></i> Edit Profile
			</button>
		</div>

		<hr>

		<h3 class="text-center">Manage Products</h3>
		<button class="btn btn-success mb-3" data-bs-toggle="modal"
			data-bs-target="#addProductModal">
			<i class="fa fa-plus"></i> Add Product
		</button>

		<!-- Product Table -->
		<%
		for (Product product : products) {
		%>

		<%
		if (product != null) {
		%>

		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>Image</th>
					<th>Id</th>
					<th>Product Name</th>
					<th>color</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Brand</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img
						src="DisplayImageController?id=<%=product.getProductId()%>"
						class="img-thumbnail" alt="Product Image" name="id"></td>
					<td><%=product.getProductId()%></td>
					<td><%=product.getProductName()%></td>
					<td><%=product.getProductColor()%></td>
					<td><%=product.getProductQuant()%></td>
					<td>RS.<%=product.getProductPrice()%></td>
					<td><%=product.getProductBrand()%></td>
					<td>
						<button class="btn btn-primary btn-sm btn-action">
							<i class="fa fa-edit"></i> Edit
						</button>
						<button class="btn btn-danger btn-sm btn-action">
							<i class="fa fa-trash"></i> Delete
						</button>
					</td>
				</tr>
				<!-- More rows dynamically added -->
			</tbody>
		</table>


		<%
		} else {
		%>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<td>No data present here..</td>
				</tr>
			</thead>
		</table>

		<%
		}
		%>


		<%
		}
		%>
	</div>

	<!-- Add Product Modal -->
	<div class="modal fade" id="addProductModal" tabindex="-1"
		aria-labelledby="addProductLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addProductLabel">Add Product</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="productRegister" method="post"
						enctype="multipart/form-data">
						<div class="mb-3">
							<label class="form-label">Product Name</label> <input type="text"
								class="form-control" placeholder="Enter product name"
								name="name">
						</div>
						<div class="mb-3">
							<label class="form-label">Product Color</label> <input
								type="text" class="form-control"
								placeholder="Enter product color" name="color">
						</div>
						<div class="mb-3">
							<label class="form-label">Product Quantity</label> <input
								type="number" class="form-control"
								placeholder="Enter product quantity" name="quantity">
						</div>
						<div class="mb-3">
							<label class="form-label">Price</label> <input type="number"
								class="form-control" placeholder="Enter price" name="price">
						</div>
						<div class="mb-3">
							<label class="form-label">Product brand</label> <input type="text"
								class="form-control" placeholder="Enter product brand"
								name="brand">
						</div>
						<div class="mb-3">
							<label class="form-label">Upload Image</label> <input type="file"
								class="form-control" name="image">
						</div>
						<input type="hidden"
								class="form-control" name="productOwnerId" value="<%= productOwner.getProductOwnerId()%>">
						<button type="submit" class="btn btn-success">Add</button>
					</form>
				</div>
			</div>
		</div>
	</div>


	<!-- Update Product Owner Detail Modal -->
	<div class="modal fade" id="updateProductOwnerDetail" tabindex="-1"
		aria-labelledby="updateProductOwnerDetail" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addProductLabel">Update Product
						Owner</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="updateProductOwner" method="get">
						<div class="mb-3">
							<label class="form-label">Product Owner Id</label> <input
								type="number" class="form-control"
								value="<%=productOwner.getProductOwnerId()%>" readonly>
						</div>
						<div class="mb-3">
							<label class="form-label">Product Owner Name</label> <input
								type="text" class="form-control"
								value="<%=productOwner.getProductOwnerName()%>" name="name">
						</div>
						<div class="mb-3">
							<label class="form-label">Product Owner email</label> <input
								type="number" class="form-control"
								value="<%=productOwner.getProductOwnerEmail()%>" name="email">
						</div>
						<button type="submit" class="btn btn-success">Update</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<%
	} else {
	%>


	<%
	request.setAttribute("msg", "please Login...");
	request.getRequestDispatcher("product-owner-login.jsp").forward(request, response);
	%>

	<%
	}
	%>



</body>
</html>
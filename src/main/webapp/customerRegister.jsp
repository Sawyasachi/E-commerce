<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer-Registration</title>

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/8.2.0/mdb.min.css"
	rel="stylesheet" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>

	<%
		String msg = (String)request.getAttribute("msg");
	%>

	<section class="vh-100" style="background-color: #2779e2;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-9">

					<h1 class="text-white mb-4">Customer Registration</h1>
					
					<%if(msg != null) { %><h2><%=msg %></h2><%} %>

					<form action="customerRegister" method="post" enctype="multipart/form-data">
						
						<div class="card" style="border-radius: 15px;">
						<div class="card-body">

							<div class="row align-items-center pt-4 pb-3">
								<div class="col-md-3 ps-5">

									<h6 class="mb-0">Name</h6>

								</div>
								<div class="col-md-9 pe-5">

									<input type="text" class="form-control form-control-lg" name="customerName"/>

								</div>
							</div>

							<hr class="mx-n3">

							<div class="row align-items-center py-3">
								<div class="col-md-3 ps-5">

									<h6 class="mb-0">Email address</h6>

								</div>
								<div class="col-md-9 pe-5">

									<input type="email" class="form-control form-control-lg"
										placeholder="example@example.com" name="customerEmail"/>

								</div>
							</div>

							<hr class="mx-n3">

							<div class="row align-items-center py-3">
								<div class="col-md-3 ps-5">

									<h6 class="mb-0">Password</h6>

								</div>
								<div class="col-md-9 pe-5">

									<input type="password" class="form-control form-control-lg"
										placeholder="" name="customerPassword"/>

								</div>
							</div>

							<hr class="mx-n3">

							<div class="row align-items-center py-3">
								<div class="col-md-3 ps-5">

									<h6 class="mb-0">Upload Image</h6>

								</div>
								<div class="col-md-9 pe-5">

									<input class="form-control form-control-lg" id="formFileLg"
										type="file" name="customerImage"/>
									<div class="small text-muted mt-2">Upload your image. Max file size 1.5 MB</div>

								</div>
							</div>

							<hr class="mx-n3">

							<div class="px-5 py-4">
								<button type="submit" data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-lg">Send application</button>
							</div>

						</div>
					</div>
					
					</form>

				</div>
			</div>
		</div>
	</section>
	
	<!-- MDB -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/8.2.0/mdb.umd.min.js"></script>

</body>
</html>
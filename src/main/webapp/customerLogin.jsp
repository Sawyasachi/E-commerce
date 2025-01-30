<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login here</title>

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
		String msg = (String) request.getAttribute("msg");
	%>

	<section class="vh-100" style="background-color: #508bfc;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-12 col-md-8 col-lg-6 col-xl-5">
					<div class="card shadow-2-strong" style="border-radius: 1rem;">
						<div class="card-body p-5 text-center">

							<h3 class="mb-5">Sign in</h3>
							
							<%if(msg != null) {%><h4><%=msg %></h4><%} %>

							<form action="loginCustomer" method="post">

								<div data-mdb-input-init class="form-outline mb-4">
									<input type="email" id="typeEmailX-2"
										class="form-control form-control-lg" name="customerEmail" /> <label
										class="form-label" for="typeEmailX-2">Email</label>
								</div>

								<div data-mdb-input-init class="form-outline mb-4">
									<input type="password" id="typePasswordX-2"
										class="form-control form-control-lg" name="customerPassword" />
									<label class="form-label" for="typePasswordX-2">Password</label>
								</div>

								<!-- Checkbox -->
								<div class="form-check d-flex justify-content-start mb-4">
									<input class="form-check-input" type="checkbox" value=""
										id="form1Example3" /> <label class="form-check-label"
										for="form1Example3"> Remember password </label>
								</div>

								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-primary btn-lg btn-block" type="submit">Login</button>

								<hr class="my-4">

								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-lg btn-block btn-primary"
									style="background-color: #dd4b39;" type="submit">
									<i class="fab fa-google me-2"></i> Sign in with google
								</button>
								<button data-mdb-button-init data-mdb-ripple-init
									class="btn btn-lg btn-block btn-primary mb-2"
									style="background-color: #3b5998;" type="submit">
									<i class="fab fa-facebook-f me-2"></i>Sign in with facebook
								</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>C4LCUL4D0R4</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/indexcss.css">

</head>
<body>  
<div id="painel-direito"></div>
	<div class="container mt-5 pt-5">
		<div class="card mx-auto border-0">
			<div class="card-header border-bottom-0 bg-transparent">
				<ul class="nav nav-tabs justify-content-center pt-4" id="pills-tab"
					role="tablist">
					<li class="nav-item"><a class="nav-link active text-primary"
						id="pills-login-tab" data-toggle="pill" href="#pills-login"
						role="tab" aria-controls="pills-login" aria-selected="true">Login</a>
					</li>

					<li class="nav-item"><a class="nav-link text-primary"
						id="pills-register-tab" data-toggle="pill" href="#pills-register"
						role="tab" aria-controls="pills-register" aria-selected="false">Register</a>
					</li>
				</ul>
			</div>

			<div class="card-body pb-4">
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="pills-login"
						role="tabpanel" aria-labelledby="pills-login-tab">
						<form>
							<div class="form-group">
								<input type="email" name="email" class="form-control" id="email"
									placeholder="Email" required autofocus>
							</div>

							<div class="form-group">
								<input type="password" name="password" class="form-control"
									id="password" id="password" placeholder="Password" required>
							</div>

							<div class="custom-control custom-checkbox">
								<input class="custom-control-input" id="customCheck1" checked="checked"
									type="checkbox"> <label class="custom-control-label"
									for="customCheck1">Check me out</label>
							</div>

							<div class="text-center pt-4">
								<button type="submit" class="btn btn-primary">Login</button>
							</div>

							<div class="text-center pt-2">
								<a class="btn btn-link text-primary" href="#">Forgot Your
									Password?</a>
							</div>
						</form>
					</div>

					<div class="tab-pane fade" id="pills-register" role="tabpanel"
						aria-labelledby="pills-register-tab">
						
							<div class="form-group">
								<input type="text" name="username" id="nameCadastro"
									class="form-control" placeholder="Nome de Usuario" required autofocus maxlength="10">
							</div>

							<div class="form-group">
								<input type="email" name="email" id="emailCadastro" class="form-control"
									placeholder="Email" required>
							</div>

							<div class="form-group">
								<input type="password" name="password" id="password1"
									class="form-control" placeholder="Senha" required maxlength="10">
							</div>

							<div class="form-group">
								<input type="password" name="password_confirmation"
									id="password-confirm" class="form-control"
									placeholder="Confirme sua senha" required maxlength="10">
							</div>

							<div class="text-center pt-2 pb-1">
								<button type="submit" class="btn btn-primary" id="subcadastro">Resgistrar</button>
							</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/js.js"></script>
</body>
</html>
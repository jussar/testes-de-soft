<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>C4LCUL4D0R4</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/usuariocss.css">
</head>
<body>

	<nav class="navbar navbar-dark bg-dark navbar-expand-sm">
		<a class="navbar-brand" href="#"> <img
			src="https://lh3.googleusercontent.com/proxy/6AfzYCc2_2ninlBplN_SkHm3Q14tTcsNrB9iKY5wwDAzLntCgitLwWN0D0QtuqdicOCcOcj0XNtxxEIYCWGqehhAbigTOXoZdy_O29HvDQc4GPeHtg"
			width="30" height="30" alt="logo"> C4lcul4d0r4
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbar-list-2" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbar-list-2">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id="ed_perfil">Editar perfil</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id="ed_dados">Editar dados</a></li>
				<li class="nav-item"><a class="nav-link" href="#" id="calcular">Calculadora</a></li>
			</ul>
		</div>
	</nav>
	<div id="div3">
		<div id="div1">
			<form action="../EditarDadosPessoais" method="post" id="EditarDadosPessoais">
				<div class="form-group">
					<label for="exampleInputEmail1">Novo email</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Seu email"> <small
						id="emailHelp" class="form-text text-muted">Nunca vamos
						compartilhar seu email, com ninguém.</small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Senha</label> <input
						type="password" class="form-control" id="exampleInputPassword1" value='<c:out value="${usuario.senha }"></c:out>'
						maxlength="10" placeholder="Senha" onfocus="">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Confirme sua Senha</label> <input
						type="password" class="form-control" id="exampleInputPassword2" value='<c:out value="${usuario.senha }"></c:out>'
						maxlength="10" placeholder="Senha" onfocus="">
				</div>
				<button type="submit" class="btn btn-primary">Enviar</button>
			</form>
		</div>
		<div id="div2"></div>
		<div id="div4"></div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script src="../js/js.js"></script>
</body>
</html>
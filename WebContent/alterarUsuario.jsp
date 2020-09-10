<%@page import="br.projeto1.model.Usuario" %>
<!DOCTYPE html>
<html lang="pt_br">

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sistema de Cadastro de Usuários</title>

<script language="JavaScript" SRC="js/funcoes.js"></script>

<link rel="shortcut icon" href="images/user.ico">
<link rel="stylesheet" href="styles/main.css">
<link rel="stylesheet" href="styles/partials/header.css">
<link rel="stylesheet" href="styles/partials/forms.css">
<link rel="stylesheet" href="styles/partials/page-create-user.css">

<link
	href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&amp;family=Poppins:wght@400;600&amp;display=swap"
	rel="stylesheet">
</head>
<body id="page-cadastro">
	<div id="container">
		<header class="page-header">
			<div class="top-bar-container">
				<a href="index.jsp"> <img src="images/back.svg" alt="Voltar">
				</a> <img src="images/team.svg" alt="LogoSistema">
			</div>

			<div class="header-content">
				<strong>Bem-vindo a página de alteração de cadastro.</strong>
			</div>
		</header>

		<main>
		<form action="alterarUsuario" id="create-user" method="post">
		<% Usuario objUsuario = (Usuario) request.getSession().getAttribute("objUsuario"); %>
			<fieldset>
				<legend>Seus dados</legend>
				<div class="input-block">
					<label for="codigo">Código</label> <input name="txtCodigo"
						id="txtCodigo" size="45" maxlength="45" size="30" maxlength="30" readonly style="background-color:transparent;" 
						value="<%=objUsuario.getCodigo()%>">
				</div>
				<div class="input-block">
					<label for="name">Nome Completo</label> <input name="txtNome"
						id="txtNome" size="45" maxlength="45" 
						value="<%=objUsuario.getNome()%>">
				</div>
				<div class="input-block">
					<label for="email"> E-mail</label> <input name="txtEmail"
						id="txtEmail" size="45" maxlength="45" type="email"
						value="<%=objUsuario.getEmail()%>">
				</div>
				<div class="input-block">
					<label for="password"> Senha (máximo 8 caracteres)</label> <input
						name="txtPassword" id="txtPassword" type="password" size="8"
						maxlength="8" required>
				</div>
				<div class="input-block">
					<label for="confirmPassword"> Confirmar Senha (máximo 8
						caracteres)</label> <input name="txtConfirmPassword" id="txtConfirmPassword"
						type="password" size="8" maxlength="8" required>
				</div>
			</fieldset>
		</form>
		<footer>
			<p>
				<img src="images/warning.svg" alt="Aviso importante">
				Importante! <br> Após edição, sua senha antiga será excluída.
			</p>
			<button type="submit" form="create-user" onclick="validatePassword()">Salvar cadastro</button>
		</footer> </main>

	</div>
</body>
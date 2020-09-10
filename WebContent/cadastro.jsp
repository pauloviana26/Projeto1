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
				<strong>Bem-vindo a página de cadastro.</strong>
				<p>Favor preencher os campos abaixo.</p>
			</div>
		</header>

		<main>
		<form action="novoUsuario" id="create-user" method="post">
			<fieldset>
				<legend>Seus dados</legend>
				<div class="input-block">
					<label for="name">Nome Completo</label> <input name="txtNome"
						id="txtNome" size="45" maxlength="45" required>
				</div>
				<div class="input-block">
					<label for="email"> E-mail</label> <input name="txtEmail"
						id="txtEmail" size="45" maxlength="45" type="email" required>
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
				Importante! <br> Preencha todos os dados
			</p>
			<button type="submit" form="create-user" onclick="validatePassword()">Salvar cadastro</button>
		</footer> </main>

	</div>
</body>
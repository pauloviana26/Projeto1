<%@page import="java.util.ArrayList, br.projeto1.model.Usuario" %>
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
<link rel="stylesheet" href="styles/partials/page-find-user.css">

<link
	href="https://fonts.googleapis.com/css2?family=Archivo:wght@400;700&amp;family=Poppins:wght@400;600&amp;display=swap"
	rel="stylesheet">
</head>
<body id="page-find-user">
	<div id="container">
		<header class="page-header">
			<div class="top-bar-container">
				<a href="index.jsp"> <img src="images/back.svg" alt="Voltar">
				</a> <img src="images/team.svg" alt="LogoSistema">
			</div>

			<div class="header-content">
				<strong>Consulta de Usuários</strong>
				<p>Favor preencher o campo abaixo.</p>
				<form action="consultarUsuario" id="search-users" method="post">
					<div class="input-block">
						<label for="name">Nome do Usuário</label> <input name="txtNome"
						id="txtNome" size="45" maxlength="45" >
					</div>
					<button type="submit">Filtrar</button>
				</form>
			</div>
		</header>

		<main>
			<% ArrayList listaUsuario = (ArrayList) request.getSession().getAttribute("listaUsuario"); %>
			<% if ((listaUsuario != null) && (listaUsuario.size() != 0))  { %>
				<% for (int i = 0; i < listaUsuario.size(); i++) { %>
					<% Usuario objUsuario = (Usuario) listaUsuario.get(i); %>
					<article class="user-item">
						<header>
							<div>
                            	<strong><%=objUsuario.getCodigo()%> - <%=objUsuario.getNome()%></strong>
                            	<span><%=objUsuario.getEmail()%></span>
                        	</div>
						</header>
						<footer>
                            <a href="consultarUsuarioAlterar?codigo=<%=objUsuario.getCodigo()%>" class="button" target="_blank">
                                Editar
                            </a>
                            <a href="excluirUsuario?codigo=<%=objUsuario.getCodigo()%>" class="button" target="_blank">
                                Excluir
                            </a>
                    	</footer>
					</article>
				<% } %>		
			<% } else { %>
			<p class="no-results">Nenhum usuário encontrado com a sua pesquisa.</p>    
			<% } %>
		</main>

	</div>
</body>
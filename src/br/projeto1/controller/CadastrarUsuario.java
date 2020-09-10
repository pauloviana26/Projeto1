package br.projeto1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto1.dao.UsuarioDAO;
import br.projeto1.model.Usuario;

public class CadastrarUsuario extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String nome = request.getParameter("txtNome");
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtPassword");
			
			if (nome == null || nome.equals(""))
			{
				response.sendRedirect("erro.jsp");
			}
			if (email == null || email.equals(""))
			{
				response.sendRedirect("erro.jsp");
			}
			if (senha == null || senha.equals(""))
			{
				response.sendRedirect("erro.jsp");
			}

			// cria o model usuario
			Usuario objUsuario = new Usuario();
			objUsuario.setNome(nome);
			objUsuario.setEmail(email);
			objUsuario.setSenha(senha);
			// chama o DAO para para fazer a inserção
			UsuarioDAO dao = new UsuarioDAO();
			dao.inserirUsuario(objUsuario);
			response.sendRedirect("sucesso.jsp");

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.sendRedirect("erro.jsp");
		}
	}
}
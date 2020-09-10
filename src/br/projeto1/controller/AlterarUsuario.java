package br.projeto1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto1.dao.UsuarioDAO;
import br.projeto1.model.Usuario;

public class AlterarUsuario extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtPassword");
			String codigo = request.getParameter("txtCodigo");
			
			Usuario objUsuario = new Usuario();
			objUsuario.setNome(nome);
			objUsuario.setEmail(email);
			objUsuario.setSenha(senha);
			objUsuario.setCodigo(Integer.parseInt(codigo));
			// chama o DAO para para fazer a inserção
			UsuarioDAO dao = new UsuarioDAO();
			dao.atualizarUsuario(objUsuario);
			
			// chama a consulta novamente
			ArrayList<Usuario> listaUsuario = dao.consultarUsuarioByNome("");

			request.getSession().setAttribute("listaUsuario", listaUsuario);
			response.sendRedirect("consultarUsuario.jsp");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.sendRedirect("erroAplicacao.jsp");
		}
	}
}

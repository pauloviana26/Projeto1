package br.projeto1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto1.dao.UsuarioDAO;
import br.projeto1.model.Usuario;

public class ConsultarUsuario extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("txtNome");
			
			UsuarioDAO dao = new UsuarioDAO();
			ArrayList<Usuario> listaUsuario = dao.consultarUsuarioByNome(nome);
			
			request.getSession().setAttribute("listaUsuario", listaUsuario);
			response.sendRedirect("consultarUsuario.jsp");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.sendRedirect("erroAplicacao.jsp");
		}
	}
}

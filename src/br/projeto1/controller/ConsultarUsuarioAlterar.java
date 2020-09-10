package br.projeto1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.projeto1.dao.UsuarioDAO;
import br.projeto1.model.Usuario;

public class ConsultarUsuarioAlterar extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String codigo = request.getParameter("codigo");
			
			Usuario objUsuario = null;
			
			if (codigo != null && !codigo.equals(""))
			{
				UsuarioDAO dao = new UsuarioDAO();
				objUsuario= dao.consultarUsuarioByCodigo(Integer.parseInt(codigo));
			}
			
			request.getSession().setAttribute("objUsuario", objUsuario);
			response.sendRedirect("alterarUsuario.jsp");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			response.sendRedirect("erroAplicacao.jsp");
		}
	}
}

package br.projeto1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.projeto1.model.Usuario;

public class UsuarioDAO extends AcessoBancoDAO{
	
	public void inserirUsuario(Usuario objUsuario) throws Exception{
		try {
			conectar();
			
			String query = "Insert INTO usuario (NOME,EMAIL,SENHA) VALUES ('"
					+ objUsuario.getNome() + "', '" + objUsuario.getEmail() + "', '" + objUsuario.getSenha() + "')";
			System.out.println(query);
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);
			
	
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
	
	public void atualizarUsuario(Usuario objUsuario) throws Exception {
		try {
			conectar();
			
			String query = "update usuario set NOME= '" + objUsuario.getNome() +"',EMAIL= '" + objUsuario.getEmail() +"',SENHA='" + objUsuario.getSenha() +"' where ID=" + objUsuario.getCodigo();
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);
			
			/*
			 * 
			 * String query = "update tb_pets set nome= '" + objPets.getNome() + "',raca= '"+ objPets.getRaca() +"' where codigo=" + objPets.getCodigo() ;
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);*/
			
	
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
	
	public ArrayList<Usuario> consultarUsuarioByNome(String nomePesquisa) throws Exception {
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			ResultSet rs;
			conectar();
			
			String query = "select ID, NOME, EMAIL from usuario where ucase(NOME) like '" + nomePesquisa.toUpperCase() + "%'";
			//System.out.println(query);
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);
			
			while(rs.next()) {
				int cod = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				
				Usuario usuario = new Usuario();
				usuario.setCodigo(cod);
				usuario.setNome(nome);
				usuario.setEmail(email);
				listaUsuario.add(usuario);
			}
			
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return listaUsuario;
		
	}
	
	public Usuario consultarUsuarioByCodigo(int codigo) throws Exception {
		Usuario usuario = null;
		try {
			ResultSet rs;
			conectar();
			
			String query = "select ID, NOME, EMAIL from usuario where ID=" + codigo;
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);
			
			if(rs.next()) {
				int cod = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				usuario = new Usuario();
				usuario.setCodigo(cod);
				usuario.setNome(nome);
				usuario.setEmail(email);
			}
			
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return usuario;
	}
	
	public void excluirUsuario(Usuario objUsuario) throws Exception {
		try {
			conectar();
			
			String query = "delete from usuario where ID= " + objUsuario.getCodigo();
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);
			
	
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
}

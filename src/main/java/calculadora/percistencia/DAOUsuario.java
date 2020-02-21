package calculadora.percistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import calculadora.models.Usuario;

public class DAOUsuario {

	private Conecxao con;

	public DAOUsuario() {
		con = new Conecxao();
	}

	public Usuario addUsuario(String nome,String email1,String senha) {
		this.con.conectar();
		Usuario u = new Usuario();
		String sql = "INSERT INTO usuario (nome,email,senha,avatar) values (?,?,?,?)";
		try (PreparedStatement statement = this.con.getConection().prepareStatement(sql);) {
			statement.setString(1, nome);
			statement.setString(2, email1);
			statement.setString(3, senha);
			statement.setString(4, "../perfil/anonimo.png");
			statement.execute();
			u.setNome(nome);
			u.setEmail(email1);
			u.setSenha(senha);
			u.setAvatar("../perfil/anonimo.png");
			return u;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
		return null;
	}

	public Usuario login(String email, String senha) {
		this.con.conectar();
		String sql = "SELECT* FROM usuario WHERE senha = ? and email= ?";
		Usuario u = new Usuario();
		try (PreparedStatement statement = this.con.getConection().prepareStatement(sql);) {
			statement.setString(1, senha);
			statement.setString(2, email);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				u.setNome(result.getString("nome"));
				u.setEmail(result.getString("email"));
				u.setSenha(result.getString("senha"));
				u.setAvatar(result.getString("avatar"));
				u.setBio(result.getString("bio"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
    
	public boolean excluirConta(Usuario u) {
		this.con.conectar();
		String sql = "DELETE FROM usuario WHERE senha= ? and email= ?";
		try(PreparedStatement statement = this.con.getConection().prepareStatement(sql);) {
			statement.setString(1, u.getEmail());
			statement.setString(2, u.getSenha());
			statement.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

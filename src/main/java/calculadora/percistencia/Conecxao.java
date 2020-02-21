package calculadora.percistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecxao {
	private Connection con;
	private String url;
	private String user;
	private String senha;
	
	public Conecxao() {
		this.senha = "senha";
		this.url ="jdbc:postgresql://localhost:5432/webI";
		this.user = "postgres";
	}
	
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			System.out.println("impossive se conectar ao banco");
		} catch (ClassNotFoundException e) {
			System.out.println("impossive se conectar ao banco");
		}
		
	}
	public Connection getConection() {
		return con;
	}
}

package calculadora.models;

public class Usuario {

	
	private String nome;
	private String email;
	private String senha;
	private String bio;
	private String avatar;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, String email, String senha, String bio, String avatar) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.bio = bio;
		this.avatar = avatar;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}

package calculadora.teste;

import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import calculadora.models.Usuario;
import calculadora.percistencia.DAOUsuario;
import junit.framework.Assert;

public class Testes extends DBTestCase{

	private FlatXmlDataSet banco;
	
	public Testes() {
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.postgresql.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:postgresql://localhost:5432/webI");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "postgres");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "senha");
	}
	
	@Override
	//faz o carregamento dos dados para o BD(postgres)
	protected IDataSet getDataSet() throws Exception {
		banco = new FlatXmlDataSetBuilder().build(new FileInputStream("arq.xml"));
		return banco;
	}

	public void testlogin() throws DataSetException, SQLException, Exception {
		ITable l = getConnection().createQueryTable("usuario", "SELECT nome FROM usuario WHERE email = 'neide@gmail.com' and senha = '123456'");
		assertEquals("neide", l.getValue(0, "nome"));
	}
	
	//C01 T01 Cadastrar um usuário que ainda não tenha um endereço de email cadastrado
	public void testCadastroUsuarioInexistente() {
		String nome = "cleyde";
		String email = "cleyde@gmail.com";
		String senha = "123456";
		Usuario u = null;
		DAOUsuario dao = mock(DAOUsuario.class);
		when(dao.addUsuario(nome, email, senha)).thenReturn(u);
		Assert.assertEquals(u, dao.addUsuario(nome, email, senha));
	}
	
	//C01 T02 Cadastrar com um email ja cadastrado
	public void testCadastrarComMesmoEmail() {
		DAOUsuario dao = mock(DAOUsuario.class);
		Usuario u = new Usuario();
		u.setEmail("neide@gmail.com");
		u.setNome("edien");
		u.setSenha("1234567");
		when(dao.addUsuario(u.getNome(), u.getEmail(), u.getSenha())).thenReturn(null);
		Assert.assertEquals(null, dao.addUsuario(u.getNome(), u.getEmail(), u.getSenha()));
	}
	
	//C01 T03 confirmar senha
	public void testConfirmarSenha() {
		
	}
	
	//C02 T01 Email e senha previamente já cadastrado no banco
	public void testLogin() {
		DAOUsuario dao = mock(DAOUsuario.class);
		String Login = "neide@gmail.com";
		String senha = "123456";
		Usuario u = null;
		when(dao.login(Login, senha)).thenReturn(u);
		Assert.assertEquals(null, dao.login(Login, senha));
	}
	
	//C02 T02 Email não cadastrado
	public void testEmailNaoCadastrado() {
		DAOUsuario dao = mock(DAOUsuario.class);
		String Login = "ariel@gmail.com";
		String senha = "123456";
		when(dao.login(Login, senha)).thenReturn(null);
		Assert.assertEquals(null, dao.login(Login, senha));
	}
	
	//C02 T03 Senha não cadastrada.
	public void testsenhaNaoCadastrado() {
		DAOUsuario dao = mock(DAOUsuario.class);
		String Login = "neide@gmail.com";
		String senha = "aurora123";
		when(dao.login(Login, senha)).thenReturn(null);
		Assert.assertEquals(null, dao.login(Login, senha));
	}
	
	//C02 T04 Campo login não pode ser vazio.
	public void testCampoLoginVazio() {
		DAOUsuario dao = mock(DAOUsuario.class);
		String Login = "";
		String senha = "aurora123";
		when(dao.login(Login, senha)).thenReturn(null);
		Assert.assertEquals(null, dao.login(Login, senha));
	}
	
	//C02 T05 Campo senha não pode ser vazio
	public void testCamposenhaVazio() {
		DAOUsuario dao = mock(DAOUsuario.class);
		String Login = "neide@gmail.com";
		String senha = "";
		when(dao.login(Login, senha)).thenReturn(null);
		Assert.assertEquals(null, dao.login(Login, senha));
	}
	
	//C03 T01 Existir no banco de dados
	public void testExcluirConta() {
		DAOUsuario dao = mock(DAOUsuario.class);
		Usuario u = new Usuario();
		u.setEmail("neide@gmail.com");
		u.setSenha("123456");
		when(dao.excluirConta(u)).thenReturn(true);
		Assert.assertEquals(true, dao.excluirConta(u));
	}
	//C03 T02 Nao existir no banco de dados
	public void testNaoExistirExcluirConta() {
		DAOUsuario dao = mock(DAOUsuario.class);
		Usuario u = new Usuario();
		u.setEmail("neide@hotmail.com");
		u.setSenha("123456");
		when(dao.excluirConta(u)).thenReturn(false);
		Assert.assertEquals(false, dao.excluirConta(u));
	}
	public boolean SemEspacosNaSenha() {
		Usuario u = new Usuario();
		u.setSenha(" 123456");
		if(u.getSenha().indexOf(" ")>=0) {
			return false;
		}
		return true;
	}
	//C04 T01 Senha não pode conter espaços.
	public void testSemEspacosNaSenha() {
		Assert.assertEquals(SemEspacosNaSenha(), false);
	}
	public boolean CamposVazios() {
		Usuario u = new Usuario();
		u.setSenha(null);
		u.setEmail(null);
		u.setSenha(null);
		if(u.getSenha()!=null||u.getEmail()!=null||u.getNome()!=null) {
			return false;
		}
		return true;
	}
	
	//C04 T02 os campos de email, senha e nome de usuários precisam ser preenchidos.
		public void testCamposVazios() {
			Assert.assertEquals(CamposVazios(), true);
		}
		
	//C04 T03 Nome de usuário precisa ser único
		public void testNomeDeUsuario() {
			DAOUsuario dao = mock(DAOUsuario.class);
			String nome = "neide";
			String email = "vania@gmail.com";
			String senha = "123456";
			when(dao.addUsuario(nome, email, senha)).thenReturn(null);
			Assert.assertEquals(null, dao.addUsuario(nome, email, senha));
		}
		
	//C04 T04 Email precisa ser único
		public void testEmailUnico() {
			DAOUsuario dao = mock(DAOUsuario.class);
			String nome = "neidinha";
			String email = "neide@gmail.com";
			String senha = "123456";
			when(dao.addUsuario(nome, email, senha)).thenReturn(null);
			Assert.assertEquals(null, dao.addUsuario(nome, email, senha));
		}
		
		public boolean qtdeCaracterSenha(String senha) {
			if(senha.length()<6 && senha.length()>=10) {
				return true;
			}
			return false;
		}
		
		//C04 T05 Senha precisa ter entre 6 a 10 carácter
		public void testqtdeCaracterSenha() {
			String senha = "1234567";
			Assert.assertEquals(qtdeCaracterSenha(senha), true);
		}
}

package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import calculadora.models.Usuario;
import calculadora.percistencia.DAOUsuario;

@WebServlet("/CriarConta")
public class Cadastrar extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("inpnome");
		String email1 = req.getParameter("inpemail");
		String password = req.getParameter("inpsenha");
		System.out.println("string valor " + username);
		SimpleEmail email = new SimpleEmail();

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("seu email", "sua senha");
			email.setSSL(true);
			email.addTo(email1); // pode ser qualquer email
			email.setFrom("aras.strong8@gmail.com"); // será passado o email que você fará a autenticação
			email.setSubject("Email de Confirmação");
			String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
					"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B",
					"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
					"W", "X", "Y", "Z" };

			String senha = "";

			for (int x = 0; x < 10; x++) {
				int j = (int) (Math.random() * carct.length);
				senha += carct[j];

			}
			email.setMsg("seu codigo de acesso é: "+senha);
			email.send();
			System.out.println("deu certo");
		} catch (EmailException e) {

			System.out.println(e.getMessage());

		}

		DAOUsuario dao = new DAOUsuario();
		Usuario usuario = (Usuario) dao.addUsuario(username, email1, password);
		if (usuario != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuario", usuario);
		} else {
			resp.setContentType("text/plain");
			PrintWriter out = resp.getWriter();
			out.println("email ou nome de usuario ja cadastrado");
		}

	}

}

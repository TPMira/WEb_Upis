package login;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/autenticacao")
public class AutenticarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String name = request.getParameter("nomeUsuario");
			
			String password = request.getParameter("senhaUsuario");
			
			if(name.equals("Thiago") && password.equals("mira123")) {
				
				Usuario user = new Usuario(name, password);
				
				HttpSession session = request.getSession();
				
				session.setAttribute("aut", user);
				
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("Login efeituado com Sucesso!");
				out.println("<meta http-equiv=\"refresh\" content=\"0;url=http://localhost:8080/web1/CalculoAniver.html\" />");
				out.println("</body>");
				out.println("</html>");
				
			}else {
				
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("</head>");
				out.println("<body>");
				out.println("Usuário ou senha inválidos");
				out.println("<a href=\"Login.html\"> Tentar novamente </a>");
				out.println("</body>");
				out.println("</html>");
				
			}
			
	}

}

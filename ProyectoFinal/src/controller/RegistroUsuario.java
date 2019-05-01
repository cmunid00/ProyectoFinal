package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beans.Usuario;
import model.DAO.UsuarioDAO;

/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		Usuario u = new Usuario(usuario, nombre, pass, email, "Cliente");
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = null;
		try {
			user = dao.insertarUsuario(u);
			HttpSession sesion = request.getSession(true);
			if (user != null) {
				sesion.setAttribute("usuario", user);
				sesion.setAttribute("pagina", "inicio");
				sesion.removeAttribute("mensaje");
			} else {
				sesion.setAttribute("mensaje", "Usuario ya Registrado");
				sesion.setAttribute("pagina", "registro");
			}
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

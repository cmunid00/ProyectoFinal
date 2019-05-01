package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beans.Linea_Pedido;
import model.Beans.Pedido;
import model.Beans.Usuario;
import model.DAO.Linea_PedidoDAO;
import model.DAO.PedidoDAO;
import model.DAO.UsuarioDAO;

/**
 * Servlet implementation class DevolverLineasFactura
 */
@WebServlet("/DevolverLineasFactura")
public class DevolverLineasFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DevolverLineasFactura() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Linea_PedidoDAO dao = new Linea_PedidoDAO();
		PedidoDAO pDao = new PedidoDAO();
		UsuarioDAO uDao = new UsuarioDAO();
		Pedido p = null;
		Usuario u = null;
		ArrayList<Linea_Pedido> lineas = null;
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession sesion = request.getSession(true);
		lineas = dao.seleccionarLineasPedido(id);
		int idPedido = lineas.get(0).getCodPedido();
		p = pDao.seleccionarPedido(idPedido);
		u = uDao.seleccionarUsuario(p.getCodUsuario());
		sesion.setAttribute("user", u);
		sesion.setAttribute("lineas", lineas);
		sesion.setAttribute("pedido", p);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

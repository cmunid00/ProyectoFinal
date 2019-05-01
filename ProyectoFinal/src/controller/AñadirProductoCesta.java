package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Beans.Producto;
import model.DAO.ProductoDAO;

/**
 * Servlet implementation class AñadirProductoCesta
 */
@WebServlet("/AñadirProductoCesta")
public class AñadirProductoCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AñadirProductoCesta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductoDAO pdo = new ProductoDAO();
		ArrayList<Producto> cesta = null;
		int id = Integer.parseInt(request.getParameter("id"));
		int numero = Integer.parseInt(request.getParameter("numero"));
		HttpSession sesion = request.getSession(true);
		if ((ArrayList<Producto>) sesion.getAttribute("cesta") != null) {
			cesta = (ArrayList<Producto>) sesion.getAttribute("cesta");
		} else {
			cesta = new ArrayList<Producto>();
		}
		for (int i = 0; i < numero; i++) {
			cesta.add(pdo.seleccionarProducto(id));
		}
		sesion.setAttribute("cesta", cesta);
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

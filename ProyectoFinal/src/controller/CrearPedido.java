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
import model.Beans.Producto;
import model.Beans.Usuario;
import model.DAO.Linea_PedidoDAO;
import model.DAO.PedidoDAO;
import model.DAO.ProductoDAO;

/**
 * Servlet implementation class CrearPedido
 */
@WebServlet("/CrearPedido")
public class CrearPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrearPedido() {
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
		ArrayList<Producto> cesta = null;
		HttpSession sesion = request.getSession(true);
		cesta = (ArrayList<Producto>) sesion.getAttribute("cesta");
		ProductoDAO dao = new ProductoDAO();
		Usuario user = (Usuario) sesion.getAttribute("usuario");
		ArrayList<Producto> productos = dao.seleccionarProductos();
		Pedido p = null;
		PedidoDAO pedido = new PedidoDAO();
		Linea_Pedido l = null;
		Linea_PedidoDAO linea = new Linea_PedidoDAO();
		int codPedido;
		int[] cantidad = new int[productos.size()];
		int[] ids = new int[productos.size()];
		float totalCesta = 0;
		for (int i = 0; i < productos.size(); i++) {
			ids[i] = productos.get(i).getId();
			cantidad[i] = 0;
		}
		for (int i = 0; i < cesta.size(); i++) {
			for (int j = 0; j < cantidad.length; j++) {
				if (cesta.get(i).getId() == ids[j]) {
					cantidad[j]++;
				}
			}
			totalCesta += cesta.get(i).getPrecio();
		}
		p = new Pedido(user.getUsuario(), totalCesta);
		codPedido = pedido.insertarPedido(p);
		for (int i = 0; i < productos.size(); i++) {
			if (cantidad[i] > 0) {
				l = new Linea_Pedido(codPedido, productos.get(i).getId(), cantidad[i],
						(productos.get(i).getPrecio() * cantidad[i]));
				linea.insertarLineaPedido(l);
			}
		}
		sesion.removeAttribute("cesta");
		response.sendRedirect("index.jsp");
	}

}

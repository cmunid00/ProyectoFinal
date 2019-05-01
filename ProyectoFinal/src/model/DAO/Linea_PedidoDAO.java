package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Linea_Pedido;

public class Linea_PedidoDAO {
	static Connection con = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public ArrayList<Linea_Pedido> seleccionarLineasPedido(int codPedido) {
		ArrayList<Linea_Pedido> pedidos = new ArrayList<Linea_Pedido>();
		int id, idProducto, cantidad;
		float total;
		Linea_Pedido p;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Linea_Pedido where codPedido=?");
			ps.setInt(1, codPedido);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				idProducto = rs.getInt("idProducto");
				cantidad = rs.getInt("cantidad");
				total = rs.getFloat("total");
				p = new Linea_Pedido(id, codPedido, idProducto, cantidad, total);
				pedidos.add(p);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return pedidos;
	}
	public boolean insertarLineaPedido(Linea_Pedido p) {
		boolean insertado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("insert into Linea_Pedido values (?,?,?,?)");
			ps.setInt(1, p.getCodPedido());
			ps.setInt(2, p.getIdProducto());
			ps.setInt(3, p.getCantidad());
			ps.setFloat(4, p.getTotal());
			int n = ps.executeUpdate();
			if (n == 1) {
				insertado = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return insertado;
	}
}

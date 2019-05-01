package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Beans.Pedido;

public class PedidoDAO {
	static Connection con = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public ArrayList<Pedido> seleccionarPedidos() {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		int codPedido;
		String codUsuario;
		float total;
		Date fecha;
		Pedido p;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Pedido");
			rs = ps.executeQuery();
			while (rs.next()) {
				codPedido = rs.getInt("codPedido");
				codUsuario = rs.getString("codUsuario");
				total = rs.getFloat("total");
				fecha = rs.getDate("fecha");
				p = new Pedido(codPedido, codUsuario, total, fecha);
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

	public Pedido seleccionarPedido(int id) {
		String codUsuario;
		float total;
		Date fecha;
		Pedido p = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Pedido where codPedido=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				codUsuario = rs.getString("codUsuario");
				total = rs.getFloat("total");
				fecha = rs.getDate("fecha");
				p = new Pedido(id, codUsuario, total, fecha);
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
		return p;
	}

	public int insertarPedido(Pedido p) {
		int id = -1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("insert into Pedido (codUsuario, total) values (?,?)");
			ps.setString(1, p.getCodUsuario());
			ps.setFloat(2, p.getTotal());
			int n = ps.executeUpdate();
			if (n == 1) {
				ps = con.prepareStatement("select * from Pedido where codPedido=(select max(codPedido) from Pedido)");
				rs = ps.executeQuery();
				while (rs.next()) {
					id = rs.getInt("codPedido");
				}
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
		return id;
	}
}

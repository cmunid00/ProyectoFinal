package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Beans.Producto;

public class ProductoDAO {
	static Connection con = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public ArrayList<Producto> seleccionarProductos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		int id;
		float precio;
		String codProducto, nombre, url, descripcion;
		Producto p;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Producto");
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
				codProducto = rs.getString("codProducto");
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
				precio = rs.getFloat("precio");
				url = rs.getString("url");
				p = new Producto(id, codProducto, nombre, descripcion, precio, url);
				productos.add(p);
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
		return productos;
	}

	public Producto seleccionarProducto(int id) {
		float precio;
		String codProducto;
		String nombre, url, descripcion;
		Producto p = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Producto where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				codProducto = rs.getString("codProducto");
				nombre = rs.getString("nombre");
				descripcion = rs.getString("descripcion");
				precio = rs.getFloat("precio");
				url = rs.getString("url");
				p = new Producto(id, codProducto, nombre, descripcion, precio, url);
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

	public boolean productoExiste(String codProducto) {
		boolean encontrado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Producto where codProducto=?");
			ps.setString(1, codProducto);
			rs = ps.executeQuery();
			while (rs.next()) {
				encontrado = true;
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
		return encontrado;
	}

	public boolean borrarProducto(int id) {
		boolean borrado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("delete from Producto where id=?");
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if (n == 1) {
				borrado = true;
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
		return borrado;
	}

	public boolean insertarProducto(Producto p) {
		boolean insertado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement(
					"insert into Producto (codProducto, nombre, descripcion, precio) values (?,?,?,?)");
			ps.setString(1, p.getCodProducto());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getDescripcion());
			ps.setFloat(4, p.getPrecio());
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

	public boolean modificarProducto(Producto p) {
		boolean modificado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement(
					"update Producto set codProducto=?, nombre=?, descripcion=?, precio=? where id=?");
			ps.setString(1, p.getCodProducto());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getDescripcion());
			ps.setFloat(4, p.getPrecio());
			ps.setInt(5, p.getId());
			con.setAutoCommit(false);
			int n = ps.executeUpdate();
			if (n == 1) {
				modificado = true;
			}
			con.commit();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception ex) {
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				con.setAutoCommit(true);
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
		return modificado;
	}
	
	public boolean cambiarProducto(Producto p) {
		boolean modificado = false;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement(
					"update Producto set nombre=?, descripcion=?, precio=? where codProducto=?");
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getDescripcion());
			ps.setFloat(3, p.getPrecio());
			ps.setString(4, p.getCodProducto());
			int n = ps.executeUpdate();
			if (n == 1) {
				modificado = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				con.setAutoCommit(true);
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
		return modificado;
	}
}

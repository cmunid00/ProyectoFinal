package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Beans.Usuario;

public class UsuarioDAO {
	static Connection con = null;
	static Statement st = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public Usuario iniciarSesion(Usuario u) {
		Usuario usuario = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Usuario where codUsuario=? and password=?");
			ps.setString(1, u.getUsuario());
			ps.setString(2, u.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(rs.getString("codUsuario"), rs.getString("nombre"), rs.getString("password"),
						rs.getString("correo"), rs.getString("rol"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
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
		return usuario;
	}

	public Usuario seleccionarUsuario(String codUsuario) {
		Usuario usuario = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Usuario where codUsuario=?");
			ps.setString(1, codUsuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new Usuario(rs.getString("codUsuario"), rs.getString("nombre"), rs.getString("password"),
						rs.getString("correo"), rs.getString("rol"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
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
		return usuario;
	}

	public Usuario insertarUsuario(Usuario u) {
		boolean encontrado = false;
		Usuario user = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(
					"jdbc:sqlserver://SERBATIC-04340\\EQUIPO:1433;databaseName=ProyectoFinal;integratedSecurity=true;",
					"", "");
			ps = con.prepareStatement("select * from Usuario where codUsuario=?");
			ps.setString(1, u.getUsuario());
			rs = ps.executeQuery();
			if (rs.next()) {
				encontrado = true;
			}
			if (!encontrado) {
				ps = con.prepareStatement("insert into Usuario values (?,?,?,?,?)");
				ps.setString(1, u.getUsuario());
				ps.setString(2, u.getNombre());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getCorreo());
				ps.setString(5, u.getRol());
				int n = ps.executeUpdate();
				if (n == 1) {
					user = new Usuario(u.getUsuario(), u.getNombre(), u.getCorreo(), u.getRol());
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
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return user;
	}
}

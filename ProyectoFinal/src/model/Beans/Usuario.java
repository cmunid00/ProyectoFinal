package model.Beans;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String usuario;
	private String nombre;
	private String password;
	private String correo;
	private String rol;

	public Usuario() {
	}

	public Usuario(String usuario, String password) {
		this.usuario = usuario;
		this.password = password;
	}

	public Usuario(String usuario, String correo, String rol) {
		this.usuario = usuario;
		this.correo = correo;
		this.rol = rol;
	}

	public Usuario(String usuario, String nombre, String correo, String rol) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
	}

	public Usuario(String usuario, String nombre, String password, String correo, String rol) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario: " + usuario + ", nombre: " + nombre + ", password: " + password + ", correo: " + correo
				+ ", rol: " + rol;
	}

}

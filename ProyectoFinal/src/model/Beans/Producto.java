package model.Beans;

import java.io.Serializable;

public class Producto implements Serializable {
	private int id;
	private String codProducto;
	private String nombre;
	private String descripcion;
	private float precio;
	private String url;

	public Producto() {
	}

	public Producto(String nombre, String descripcion, float precio, String url) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.url = url;
	}

	public Producto(String codProducto, String nombre, String descripcion, float precio) {
		super();
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(String codProducto, String nombre, String descripcion, float precio, String url) {
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.url = url;
	}

	public Producto(int id, String codProducto, String nombre, String descripcion, float precio) {
		super();
		this.id = id;
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public Producto(int id, String codProducto, String nombre, String descripcion, float precio, String url) {
		super();
		this.id = id;
		this.codProducto = codProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", código Producto: " + codProducto + ", nombre: " + nombre + ", descripcion: "
				+ descripcion + ", precio: " + precio + ", url: " + url;
	}

}

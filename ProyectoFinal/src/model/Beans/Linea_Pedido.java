package model.Beans;

public class Linea_Pedido {
	private int id;
	private int codPedido;
	private int idProducto;
	private int cantidad;
	private float total;

	public Linea_Pedido(int codPedido, int idProducto, int cantidad, float total) {
		this.codPedido = codPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public Linea_Pedido(int id, int codPedido, int idProducto, int cantidad, float total) {
		this.id = id;
		this.codPedido = codPedido;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", código de pedido: " + codPedido + ", id de producto, " + idProducto + ", cantidad: "
				+ cantidad + ", total: " + total;
	}

}

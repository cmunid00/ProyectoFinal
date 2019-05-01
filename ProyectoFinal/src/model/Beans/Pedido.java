package model.Beans;

import java.util.Date;

public class Pedido {
	private int codPedido;
	private String codUsuario;
	private float total;
	private Date fecha;

	public Pedido(String codUsuario, float total) {
		this.codUsuario = codUsuario;
		this.total = total;
	}

	public Pedido(int codPedido, String codUsuario, float total, Date fecha) {
		super();
		this.codPedido = codPedido;
		this.codUsuario = codUsuario;
		this.total = total;
		this.fecha = fecha;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Código de pedido: " + codPedido + ", código de usuario: " + codUsuario + ", total: " + total
				+ ", fecha: " + fecha;
	}
}

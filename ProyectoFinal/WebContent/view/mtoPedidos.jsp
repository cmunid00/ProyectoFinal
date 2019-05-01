<%@page import="model.Beans.Usuario"%>
<%@page import="model.DAO.Linea_PedidoDAO"%>
<%@page import="model.Beans.Linea_Pedido"%>
<%@page import="model.Beans.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO.PedidoDAO"%>
<%
	HttpSession sesion = request.getSession(true);
	PedidoDAO dao = new PedidoDAO();
	Linea_PedidoDAO lineaDao = new Linea_PedidoDAO();
	ArrayList<Pedido> pedidos = dao.seleccionarPedidos();
	ArrayList<Linea_Pedido> lineas = null;
	Usuario user = null;
	Pedido pedido = null;
%>
<div id="pedido" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close col-1" data-dismiss="modal">&times;</button>
				<h4 class="modal-title col-12">Detalle de Pedido</h4>
			</div>
			<div class="modal-body text-center">
				<%
					if (sesion.getAttribute("lineas") != null) {
						lineas = (ArrayList<Linea_Pedido>) sesion.getAttribute("lineas");
						if (sesion.getAttribute("pedido") != null) {
							pedido = (Pedido) sesion.getAttribute("pedido");
						}
						if (sesion.getAttribute("user") != null) {
							user = (Usuario) sesion.getAttribute("user");
						}
					} else {
						lineas = new ArrayList<Linea_Pedido>();
					}
				if(user!=null && pedido!=null){
				%>
				<p class="form-control col-lg-12">Cliente: <%=user.getNombre() %></p>
				<p class="form-control col-lg-12">Código de pedido: <%=pedido.getCodPedido() %></p>
				<p class="form-control col-lg-12">Fecha de pedido: <%=pedido.getFecha().toString() %></p>
				<%
					for (int i = 0; i < lineas.size(); i++) {
				%>
				<p class="form-control col-lg-12">
					Id:
					<%=lineas.get(i).getId()%>, Producto:
					<%=lineas.get(i).getIdProducto()%>, Cantidad:
					<%=lineas.get(i).getCantidad()%>, Precio:
					<%=lineas.get(i).getTotal()%></p>
				<%
					}
				%>
				<p class="form-control col-lg-12">Total factura: <%=pedido.getTotal() %></p>
				<%} %>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default col-4"
					data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>
<h1 class="text-primary text-center">Lista de Pedidos</h1>
<div class="container text-center">
	<a class="btn btn-info btn-lg text-center"
		href="/ProyectoFinal/CambiarPagina?pagina=inicio">Atrás</a>
</div>
<br>
<div class="container d-flex justify-content-around flex-wrap">
	<% if (pedidos.size()<1) { %>
		<div class="container text-center">
			<h3 class="text-danger">Aún no se ha realizado ningún pedido</h3>
		</div>
		<% } else {
		for (Pedido p : pedidos) {
	%>
	<div
		class="d-flex flex-column container col-3 text-center mb-5 mx-2 border border-primary border-4 rounded py-3">
		<p>
			Código de pedido:
			<%=p.getCodPedido()%></p>
		<p>
			Usuario:
			<%=p.getCodUsuario()%></p>
		<p>
			Precio:
			<%=p.getTotal()%></p>
		<p>
			Fecha:
			<%=p.getFecha()%></p>
		<br>
		<button name="<%=p.getCodPedido()%>" id="boton<%=p.getCodPedido()%>"
			class="btn btn-default btn-block ml-1" data-toggle="modal"
			data-target="#pedido">Mostrar Detalle</button>
	</div>
	<%
			}
		}
	%>
</div>
<script>
	$(document).ready(function() {
		<%for (Pedido p : pedidos) {%>
			$("#boton<%=p.getCodPedido()%>").click(function() {
				var datos = {id : <%=p.getCodPedido()%> };
				$.ajax({
					url : 'http://localhost:8080/ProyectoFinal/DevolverLineasFactura',
					type : 'get',
					data : datos,
					success : function() {
						$(".modal-dialog").load(" .modal-content");
					}
				});
			});
		<% } %>
	});
</script>
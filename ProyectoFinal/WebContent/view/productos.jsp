<%@page import="model.Beans.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DAO.ProductoDAO"%>
<%
	HttpSession sesion = request.getSession(true);
	ProductoDAO dao = new ProductoDAO();
	ArrayList<Producto> productos = dao.seleccionarProductos();
	ArrayList<Producto> cesta = null;
	int[] cantidad = new int[productos.size()];
	int[] ids = new int[productos.size()];
	float totalCesta = 0;

	if (sesion.getAttribute("cesta") != null) {
		cesta = (ArrayList<Producto>) sesion.getAttribute("cesta");
	} else {
		cesta = new ArrayList<Producto>();
	}

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
%>
<br>
<h1 class="text-primary text-center">Lista de Productos</h1>
<div class="container text-center">
	<a class="btn btn-info btn-lg text-center" href="/ProyectoFinal/CambiarPagina?pagina=inicio">Atrás</a>
		<button class="btn btn-info btn-lg text-center" data-toggle="modal"
		data-target="#carrito">Carrito</button>
	<div id="carrito" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close col-1" data-dismiss="modal">&times;</button>
					<h4 class="modal-title col-11">Carrito de Compra</h4>
				</div>
				<div class="modal-body">
					<%
						for (int i = 0; i < productos.size(); i++) {
							if(cantidad[i]>0){
					%>
					<div class="container">
						<label><%=productos.get(i).getNombre()%></label>
						<label>, Unidades: <%=cantidad[i] %></label>
						<label>, Precio: <%=(productos.get(i).getPrecio()*cantidad[i])%></label>
					</div>
					<%
							}
						}
					%>
					<p>Precio Total: <%=totalCesta %></p>
				</div>
				<form method="post" action="/ProyectoFinal/CrearPedido">
					<div class="modal-footer">
						<button type="button" class="btn btn-default col-4"
							data-dismiss="modal">Cerrar</button>
					<% if(!cesta.isEmpty()) { %>
						<button type="submit" id="finalizarCompra" class="btn btn-default col-7">Finalizar
							Compra</button>
					<% } else { %>
						<button type="submit" id="finalizarCompra" class="btn btn-default col-7" disabled>Finalizar
							Compra</button>
					<% } %>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<br>
<div class="container d-flex justify-content-around flex-wrap">
	<%
		for (Producto p : productos) {
	%>
	<div
		class="d-flex flex-column container col-3 text-center mb-5 mx-2 border border-primary border-4 rounded py-3">
		<img class="img-responsive" src="<% if(p.getUrl() !=null) { out.write(p.getUrl()); } else { out.write("webroot/img/sinimagen.jpg"); }%>">
		<p><%=p.getNombre()%></p>
		<p><%=p.getPrecio()%>
			euros
		</p>
		<input type="number" id="numero<%=p.getId()%>"
			name="numero<%=p.getId()%>" min="1" max="100" value="1">
		<br> <br>
		<button name="<%=p.getId()%>"
			id="boton<%=p.getId()%>" class="btn btn-default btn-block text-center ml-1">Añadir</button>
	</div>
	<%
		}
	%>
</div>
<script>
	$(document).ready(function() {
		<%for (Producto p : productos) {%>
			$("#boton<%=p.getId()%>").click(function() {
				var datos = {id:<%=p.getId()%>,
							numero: $("#numero<%=p.getId()%>").val()
				};
				$.ajax({
					url : 'http://localhost:8080/ProyectoFinal/AñadirProductoCesta',
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
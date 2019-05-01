<%@page import="java.util.ArrayList"%>
<%@page import="model.Beans.Producto"%>
<%@page import="model.DAO.ProductoDAO"%>
<%
	ProductoDAO dao = new ProductoDAO();
	ArrayList<Producto> productos = dao.seleccionarProductos();
%>
<form method="post" action="/ProyectoFinal/ModificarProducto">
	<div id="modificar" class="modal fade" role="dialog">
		<div class="modal-dialog uno">
			<div class="modal-content uno">
				<div class="modal-header text-center">
					<button type="button" class="close col-1" data-dismiss="modal">&times;</button>
					<h4 class="modal-title col-12">Modificar Producto</h4>
				</div>
				<div class="modal-body text-center">
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Id: </label> <input
							type="text" id="idModificar" name="id"
							class="form-control col-lg-9" readonly="readonly">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Código: </label><input
							type="text" minlength="3" maxlength="10" id="codigoModificar"
							name="codigo" class="form-control col-lg-9">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Nombre: </label><input
							type="text" minlength="3" maxlength="50" id="nombreModificar"
							name="nombre" class="form-control col-lg-9">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Descripción: </label><input
							type="text" minlength="3" maxlength="255"
							id="descripcionModificar" name="descripcion"
							class="form-control col-lg-9">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Precio: </label><input
							type="number" min="0" max="10000" id="precioModificar"
							name="precio" class="form-control col-lg-9">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default col-5"
						data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-default col-6"
						id="aceptarModificar">Aceptar</button>
				</div>
			</div>
		</div>
	</div>
</form>
<form method="post" action="/ProyectoFinal/BorrarProducto">
	<div id="borrar" class="modal fade" role="dialog">
		<div class="modal-dialog dos">
			<div class="modal-content dos">
				<div class="modal-header text-center">
					<button type="button" class="close col-1" data-dismiss="modal">&times;</button>
					<h4 class="modal-title col-12">Borrar Producto</h4>
				</div>
				<div class="modal-body text-center">
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Id: </label> <input
							type="text" id="idBorrar" name="id" class="form-control col-lg-9"
							readonly="readonly">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Código: </label><input
							type="text" minlength="3" maxlength="10" id="codigoBorrar"
							name="codigo" class="form-control col-lg-9" readonly="readonly">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Nombre: </label><input
							type="text" minlength="3" maxlength="50" id="nombreBorrar"
							name="nombre" class="form-control col-lg-9" readonly="readonly">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Descripción: </label><input
							type="text" minlength="3" maxlength="255" id="descripcionBorrar"
							name="descripcion" class="form-control col-lg-9"
							readonly="readonly">
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Precio: </label><input
							type="number" min="0" max="10000" id="precioBorrar" name="precio"
							class="form-control col-lg-9" readonly="readonly">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default col-5"
						data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-default col-6"
						id="aceptarBorrar">Borrar</button>
				</div>
			</div>
		</div>
	</div>
</form>
<form method="post" action="/ProyectoFinal/InsertarProducto">
	<div id="insertar" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center">
					<button type="button" class="close col-1" data-dismiss="modal">&times;</button>
					<h4 class="modal-title col-12">Insertar Producto</h4>
				</div>
				<div class="modal-body text-center">
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Código: </label><input
							type="text" minlength="3" maxlength="10"
							name="codigo" class="form-control col-lg-9" required>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Nombre: </label><input
							type="text" minlength="3" maxlength="50"
							name="nombre" class="form-control col-lg-9" required>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Descripción: </label><input
							type="text" minlength="3" maxlength="255"
							name="descripcion" class="form-control col-lg-9" required>
					</div>
					<div class="form-group row">
						<label class="col-lg-3 col-form-label">Precio: </label><input
							type="number" min="0" max="10000" name="precio"
							class="form-control col-lg-9" required>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default col-5"
						data-dismiss="modal">Cancelar</button>
					<button type="submit" class="btn btn-default col-6"
						id="aceptarBorrar">Insertar</button>
				</div>
			</div>
		</div>
	</div>
</form>
<h1 class="text-primary text-center">Lista de Productos</h1>
<div class="container text-center">
	<div class="container text-center">
		<a class="btn btn-info text-center"
			href="/ProyectoFinal/CambiarPagina?pagina=inicio">Atrás</a>
		<button name="insertar" id="insertar" class="btn btn-success" data-toggle="modal" data-target="#insertar">Insertar</button>
	</div>
	<br>
	<div id="contenedor"
		class="container">
		<%
			if (productos.size() < 1) {
		%>
		<div class="container text-center">
			<h3 class="text-danger">Aún no está disponible ningún producto</h3>
		</div>
		<%
			} else {
		%>
		<table class="table table-hover text-centered">
			<tr>
				<td class="font-weight-bold">ID</td>
				<td class="font-weight-bold">Código</td>
				<td class="font-weight-bold">Nombre</td>
				<td class="font-weight-bold">Descripción</td>
				<td class="font-weight-bold">Precio</td>
				<td class="font-weight-bold">Opciones</td>
			</tr>
			<%
				for (Producto p : productos) {
			%>
			<tr>
				<td class="align-middle"><%=p.getId()%>
				</td>
				<td class="align-middle"><%=p.getCodProducto()%>
				</td>
				<td class="align-middle"><%=p.getNombre()%>
				</td>
				<td class="align-middle"><%=p.getDescripcion()%>
				</td>
				<td class="align-middle"><%=p.getPrecio()%></td>
				<td>
					<button name="modificar<%=p.getId()%>" id="modificar<%=p.getId()%>"
						class="btn btn-warning px-3" data-toggle="modal"
						data-target="#modificar">Modificar</button>
					<button name="borrar<%=p.getId()%>" id="borrar<%=p.getId()%>"
						class="btn btn-danger px-4" data-toggle="modal"
						data-target="#borrar">Borrar</button>
				</td>
			</tr>
			<%
					}
				}
			%>
		</table>
	</div>
</div>
<script>
	$(document).ready(function() {
		<% for (Producto p : productos) { %>
			$("#modificar<%=p.getId()%>").click(function() {
				$("#idModificar").val(<%=p.getId()%>);
				$("#codigoModificar").val("<%=p.getCodProducto()%>");
				$("#nombreModificar").val("<%=p.getNombre()%>");
				$("#descripcionModificar").val("<%=p.getDescripcion()%>");
				$("#precioModificar").val(<%=p.getPrecio()%>);
			});
			
			$("#borrar<%=p.getId()%>").click(function() {
				$("#idBorrar").val(<%=p.getId()%>);
				$("#codigoBorrar").val("<%=p.getCodProducto()%>");
				$("#nombreBorrar").val("<%=p.getNombre()%>");
				$("#descripcionBorrar").val("<%=p.getDescripcion()%>");
				$("#precioBorrar").val(<%=p.getPrecio()%>);
			});
		<% } %>
	});
</script>
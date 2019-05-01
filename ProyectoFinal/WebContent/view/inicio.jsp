<%@page import="model.Beans.Usuario"%>
<%
	HttpSession sesion = request.getSession(true);
	Usuario user = (Usuario) sesion.getAttribute("usuario");
%>
<form method="post" action="/ProyectoFinal/CerrarSesion">
	<label
		class="col-6 lead text-default display-4 text-center align-middle mr-5">Bienvenido
		<%=user.getNombre()%></label> <input type="submit"
		class="btn btn-default col-3" value="Cerrar Sesión">
</form>
<br>
<div class="container d-flex justify-content-between flex-wrap">
	<%
		if (user.getRol().equals("Cliente")) {
	%>
	<div class="container text-center">
		<a href="/ProyectoFinal/CambiarPagina?pagina=productos"><img
			src="webroot/img/productos.jpg"><label
			class="display-4 text-warning text-center align-middle ml-5">Ver Productos</label></a>
	</div>
	<%
		} else if (user.getRol().equals("Administrador")) {
	%>
	<div class="container text-center">
		<a href="/ProyectoFinal/CambiarPagina?pagina=mtoProductos"><img
			src="webroot/img/gestionarProductos.png" alt="Productos"></a><label
			class="display-4 text-warning text-center align-middle">Gestionar
			Productos</label>
	</div>
	<div class="container text-center">
		<a href="/ProyectoFinal/CambiarPagina?pagina=mtoPedidos"><img
			src="webroot/img/verPedidos.jpg" alt="Pedidos"></a><label
			class="display-4 text-warning text-center align-middle ml-5">Ver
			Pedidos</label>
	</div>
	<%
		}
	%>
</div>
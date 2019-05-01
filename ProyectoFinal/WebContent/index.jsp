<%@page import="thread.Fichero"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fábrica de Quesos</title>
<link rel="icon" type="image/x-icon" href="webroot/img/favicon.ico">
<link rel="stylesheet" href="webroot/css/estilos.css">
<link rel="stylesheet" href="bootstrap/bootstrap.min.css"
	type="text/css" media="all" />
<link rel="stylesheet" href="bootstrap/mdb.lite.min.css" type="text/css"
	media="all" />
<script type="text/javascript" src="bootstrap/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="bootstrap/popper.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
	<header>
		<h1 class="display-4 text-light">Fábrica de Quesos</h1>
	</header>
	<%
		Fichero f = new Fichero();
		f.start();
		HttpSession sesion = request.getSession(true);
		String pagina = (String) sesion.getAttribute("pagina");
		String enlace = "./view/" + pagina + ".jsp";
		if (pagina == null) {
	%>
	<jsp:include page="./view/presentacion.jsp" />
	<%
		} else {
	%>
	<jsp:include page="<%=enlace%>" />
	<%
		}
		if (sesion.getAttribute("mensaje") != null) {
	%>
	<label class="text-center text-danger display-4 col-12"><%=(String) sesion.getAttribute("mensaje")%></label>
	<%
		}
	%>
	<section class="separador"></section>
	<footer>
		<p>
			<a href="webroot/img/modelos/DiagramaClases.JPG" target="_blank"
				class="m-2">Clases</a>
			<a href="webroot/img/modelos/DiagramaCasosDeUso.JPG" target="_blank"
				class="m-2">Casos De Uso</a>
				Christian Muñiz de la Huerga Copyright 2019
			<a href="webroot/img/modelos/EstructuraDeAlmacenamiento.JPG" target="_blank"
				class="m-2">Estructura de Almacenamiento</a> 
		</p>
	</footer>
</body>
</html>
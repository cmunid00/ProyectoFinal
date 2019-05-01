<br>
<div class="container">
	<form method="post" action="/ProyectoFinal/InicioSesion">
		<div class="form-group row">
			<label for="usuario" class="col-lg-3 col-form-label">Nombre
				de usuario: </label> <input type="text" class="form-control col-lg-9"
				name="usuario" id="usuario" minlength="3" maxlength="10" required>
		</div>
		<div class="form-group row">
			<label for="pass" class="col-lg-3 col-form-label">Contraseña:
			</label> <input type="password" class="form-control col-8" name="pass"
				id="pass" minlength="3" maxlength="10" required> <span
				id="ojo">&nbsp;&nbsp;&#128065;</span>
		</div>
		<div class="form-group row">
			<a class="btn btn-default col-4" href="/ProyectoFinal/CambiarPagina?pagina=presentacion">Volver al inicio</a>
			<a class="btn btn-default col-3" href="/ProyectoFinal/CambiarPagina?pagina=registro">Registrarse</a>
			<input type="submit" class="btn btn-default col-4" name="inicio" value="Iniciar Sesión">
		</div>
	</form>
</div>
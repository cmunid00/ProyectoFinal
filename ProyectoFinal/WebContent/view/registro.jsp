<br>
<div class="container">
	<form method="post" action="/ProyectoFinal/RegistroUsuario">
		<div class="form-group row">
			<label for="usuario" class="col-lg-3 col-form-label">Usuario: </label> <input type="text" class="form-control col-lg-7"
				name="usuario" id="usuario" minlength="3" maxlength="10" required>
		</div>
		<div class="form-group row">
			<label for="nombre" class="col-lg-3 col-form-label">Nombre: </label> 
			<input type="text" class="form-control col-lg-7"
				name="nombre" id="nombre" minlength="3" maxlength="20" required>
		</div> 
		<div class="form-group row">
			<label for="pass" class="col-lg-3 col-form-label">Contraseña:
			</label> <input type="password" class="form-control col-7" name="pass"
				id="pass" minlength="3" maxlength="10" required> <span
				id="ojo">&nbsp;&nbsp;&#128065;</span>
		</div>
		<div class="form-group row">
			<label for="pass2" class="col-lg-3 col-form-label">Repita Contraseña:
			</label> <input type="password" class="form-control col-7" name="pass2"
				id="pass2" minlength="3" maxlength="10" required> <span
				id="ojo2">&nbsp;&nbsp;&#128065;</span>
		</div>
		<div class="form-group row">
			<label for="email" class="col-lg-3 col-form-label">Correo: </label> 
			<input type="email" class="form-control col-lg-7"
				name="email" id="email" minlength="3" maxlength="50" required>
		</div> 
		<div class="form-group row">
			<a class="btn btn-default col-5" href="/ProyectoFinal/CambiarPagina?pagina=login">Cancelar</a>
			<input type="submit" class="btn btn-default col-5" name="registro" value="Registrarse" id="registro">
		</div>
	</form>
</div>
$(document).ready(function() {
	$("#ojo").click(function() {
		var tipo = $("#pass").attr("type");
		if (tipo == "password") {
			$("#pass").attr("type", "text");
		} else {
			$("#pass").attr("type", "password");
		}

	});

	$("#ojo2").click(function() {
		var tipo = $("#pass2").attr("type");
		if (tipo == "password") {
			$("#pass2").attr("type", "text");
		} else {
			$("#pass2").attr("type", "password");
		}
	});

	$("#pass2").blur(function() {
		var pass = $("#pass").val();
		var pass2 = $("#pass2").val();
		if (pass == pass2) {
			$("#registro").prop("disabled", false);
		} else {
			$("#registro").prop("disabled", true);
		}
	});

});
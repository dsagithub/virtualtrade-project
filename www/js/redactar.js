var API_BASE_URL = "http://147.83.7.155:8080/virtualtrade-api";

var destinatario = $.cookie('destinatario');
var anuncioid = $.cookie('anuncioid');
var origen = $.cookie('email');
var password = $.cookie('userpass')

$(document).ready(function() {

	if ($.cookie('loggedin') == 'nologueado') {
		$("#logout").hide();
		$("#perfil").hide();
		$("#anadirnuevo").hide();
		$("#buscar").hide();
		$("#mensajes").hide();
	}

	if ($.cookie('loggedin') == 'logueado') {
		$("#singup").hide();
		$("#signin").hide();
	}

});

$("#logout").click(function(e) {
	e.preventDefault();
	console.log("dsag");
	logout();
});

function logout() {
	$("#logout").hide();
	$("#perfil").hide();
	$("#anadirnuevo").hide();
	$("#buscar").hide();
	$("#mensajes").hide();
	$.removeCookie('email');
	$.removeCookie('userpass');
	$.cookie('loggedin', "nologueado");
	window.location = "http://147.83.7.155/virtualtrade/index.html";
}

$("#button_send_msg").click(function(e) {
	e.preventDefault();
	EnviarMensaje();
});

$("#button_cancell").click(function(e) {
	e.preventDefault();
	CancelarMensaje();
});

function CancelarMensaje() {
	// FALTA BORRAR cookies
	document.location.href = '/virtualtrade/index.html';

	$.removeCookie('destinatario');
	$.removeCookie('anuncioid');
}

function EnviarMensaje() {

	var url = API_BASE_URL + '/mensajes';
	var object = new Object();
	object.emaildestino = destinatario;
	object.anuncioid = anuncioid;
	object.subject = $("#subject").val();
	object.content = $("#content").val();
	console.log(object.emaildestino);
	console.log(object.anuncioid);
	console.log(object.subject);
	console.log(object.content);

	if (object.subject == '') {

		alert("El campo subject es obligatorio"); 

	}
	
	else if (object.content == '') {

		alert("El campo content es obligatorio"); 

	}

	else {
		var data = JSON.stringify(object);
		$
				.ajax(
						{
							url : url,
							type : 'POST',
							dataType : "json",
							crossDomain : true,
							headers : {
								"Accept" : "application/vnd.virtual.api.mensaje+json",
								"Content-Type" : "application/vnd.virtual.api.mensaje+json"
							},
							data : data,
							beforeSend : function(request) {
								request.withCredentials = true;
								request.setRequestHeader("Authorization",
										"Basic "
												+ btoa('arnaumail' + ':'
														+ 'arnau'));
							}
						}).done(function(data, status, jqxhr) {
					$("#create_result").text("Anuncio creado correctamente");
					console.log("Mensaje enviado");
					// FALTA BORRAR COOKIES
					document.location.href = '/virtualtrade/index.html';

					$.removeCookie('destinatario');
					$.removeCookie('anuncioid');

				}).fail(function(jqXHR, textStatus) {
					$("#create_result").text("No agregado");
				});
	}

}

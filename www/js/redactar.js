var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var destinatario= $.cookie('destinatario');
var anuncioid= $.cookie('anuncioid');
var origen= $.cookie('email');
var password = $.cookie('userpass')


$("#button_send_msg").click(function(e) {
	e.preventDefault();
	EnviarMensaje();
});

$("#button_cancell").click(function(e) {
	e.preventDefault();
	CancelarMensaje();
});

function CancelarMensaje() {
	//FALTA BORRAR cookies
	document.location.href='/virtualtrade/index.html';
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
	
	var data = JSON.stringify(object);

	$.ajax(
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
					request.setRequestHeader("Authorization", "Basic "
							+ btoa('arnaumail' + ':' + 'arnau'));
				}
			}).done(function(data, status, jqxhr) {
		$("#create_result").text("Anuncio creado correctamente");
		console.log("Mensaje enviado");
		//FALTA BORRAR COOKIES
		document.location.href='/virtualtrade/index.html';
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});

}

var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var destinatario= $cookie.('destinatario');
var anuncioid= $cookie.('anuncioid');
var origen= $cookie.('email');
var password = $cookie.('userpass')


$("#button_send_msg").click(function(e) {
	e.preventDefault();
	EnviarMensaje();
}

function EnviarMensaje() {
	
	var url = API_BASE_URL + '/anuncios';
	var object = new Object();
	var imagen = new Object();
	object.subject = $("#subject").val();
	object.content = $("#content").val();
	
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
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});

}

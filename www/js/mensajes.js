var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var destinatario = new Array();
var anuncioid = new Array();
var contador=0;

var password = $.cookie('userpass')
var email = $.cookie('email')

$(document).ready(function() {
	getMensajes();
});

$("#button_enviados").click(function(e) {
	e.preventDefault();
	getEnviados();
//	console.log("asdfasfd");
	
});



//$("#button_responder_mensaje_0").click(function(e) {
//	e.preventDefault();
//
//	getResponderMensaje();
//	console.log("lkdjaf");
//});

//$("#button_responder_mensaje_1").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[1]);
//	$.cookie('anuncioid',anuncioid[1]);
//	getResponderMensaje();
//});
//
//
//$("#button_responder_mensaje_2").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[2]);
//	$.cookie('anuncioid',anuncioid[2]);	
//	getResponderMensaje();
//
//});
//
//
//$("#button_responder_mensaje_3").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[3]);
//	$.cookie('anuncioid',anuncioid[3]);
//	getResponderMensaje();
//});
//
//
//$("#button_responder_mensaje_4").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[4]);
//	$.cookie('anuncioid',anuncioid[4]);	
//	getResponderMensaje();
//});
//
//
//$("#button_responder_mensaje_5").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[5]);
//	$.cookie('anuncioid',anuncioid[5]);	
//	getResponderMensaje();
//
//	
//});
//
//$("#button_responder_mensaje_6").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[6]);
//	$.cookie('anuncioid',anuncioid[6]);	
//	getResponderMensaje();
//
//});
//
//
//$("#button_responder_mensaje_7").click(function(e) {
//	e.preventDefault();
//	$.cookie('destinatario',destinatario[7]);
//	$.cookie('anuncioid',anuncioid[7]);	
//	getResponderMensaje();
//});
//
//$("#button_responder_mensaje_8").click(function(e) {
//	e.preventDefault();
//	$cookie('destinatario',destinatario[8]);
//	$cookie('anuncioid',anuncioid[8]);	
//	getResponderMensaje();
//});
function getEnviados() {
	var url = API_BASE_URL + "/mensajes/enviados?offset=0&length=10";
	
	$("#mensajes_result").text("");
	
	$.ajax(
			{
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(email + ':' + password));
				},

			}).done(
			function(data, status, jqxhr) {
				var response = JSON.parse(jqxhr.responseText);
				var mensajes = response.mensajes;
				
				
				$("#mensajes_result").text("");

				$.each(mensajes, function(i, v) {
					var mensaje = v;
					var $grouplist = $('#mensajes_result');
//					$('<li>' + mensaje.anuncioid + '</li>')
//							.appendTo($grouplist);
//					$('<li>' + mensaje.mensajeid + '</li>')
//							.appendTo($grouplist);
					$('<div><p align=right>'+mensaje.creation_timestamp+ '</p><h5>Destino: ' + mensaje.emaildestino +'</h5></div>').appendTo(
							$grouplist);
					
					$('<h5>Asunto: ' + mensaje.subject + '</h5>').appendTo($grouplist);
					$("<hr noshade size=1> ").appendTo($grouplist);
					$('<div style="height:100px">Contenido: ' + mensaje.content + '</div>').appendTo($grouplist);
					$("<hr noshade size=1> ").appendTo($grouplist);

//					$('<li>' + mensaje.emaildestino + '</li>').appendTo(
//							$grouplist);

					$("<hr noshade size=7> ").appendTo($grouplist);					
					
					 $(button_enviados).hide();
				});

			}).fail(function() {
		$("#mensajes_result").text("No hay mensajes");
	});


	
}

function getResponderMensaje0() {
	$.cookie('destinatario',destinatario[0]);
	$.cookie('anuncioid',anuncioid[0]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje1() {
	$.cookie('destinatario',destinatario[1]);
	$.cookie('anuncioid',anuncioid[1]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje2() {
	$.cookie('destinatario',destinatario[2]);
	$.cookie('anuncioid',anuncioid[2]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje3() {
	$.cookie('destinatario',destinatario[3]);
	$.cookie('anuncioid',anuncioid[3]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje4() {
	$.cookie('destinatario',destinatario[4]);
	$.cookie('anuncioid',anuncioid[4]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje5() {
	$.cookie('destinatario',destinatario[5]);
	$.cookie('anuncioid',anuncioid[5]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje6() {
	$.cookie('destinatario',destinatario[6]);
	$.cookie('anuncioid',anuncioid[6]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje7() {
	$.cookie('destinatario',destinatario[7]);
	$.cookie('anuncioid',anuncioid[7]);	
	document.location.href='/virtualtrade/redactar.html';
}
function getResponderMensaje8() {
	$.cookie('destinatario',destinatario[8]);
	$.cookie('anuncioid',anuncioid[8]);	
	document.location.href='/virtualtrade/redactar.html';
}

function getResponderMensaje9() {
	$.cookie('destinatario',destinatario[9]);
	$.cookie('anuncioid',anuncioid[9]);	
	
//	button_enviados.hide()
	document.location.href='/virtualtrade/redactar.html';
}






function getMensajes() {

	var url = API_BASE_URL + "/mensajes/recibidos?offset=0&length=10";
	
	$.ajax(
			{
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(email + ':' + password));
				},

			}).done(
			function(data, status, jqxhr) {
				var response = JSON.parse(jqxhr.responseText);
				var mensajes = response.mensajes;
				
				
				$("#mensajes_result").text("");

				$.each(mensajes, function(i, v) {
					var mensaje = v;
					var $grouplist = $('#mensajes_result');
//					$('<li>' + mensaje.anuncioid + '</li>')
//							.appendTo($grouplist);
//					$('<li>' + mensaje.mensajeid + '</li>')
//							.appendTo($grouplist);
					$('<div><p align=right>'+mensaje.creation_timestamp+ '</p><h5>Origen: ' + mensaje.emailorigen +'</h5></div>').appendTo(
							$grouplist);
					
					$('<h5>Asunto: ' + mensaje.subject + '</h5>').appendTo($grouplist);
					$("<hr noshade size=1> ").appendTo($grouplist);
					$('<div style="height:100px">Contenido: ' + mensaje.content + '</div>').appendTo($grouplist);
					$("<hr noshade size=1> ").appendTo($grouplist);
					$('<button type="button" onclick="getResponderMensaje'+contador+'()" class="btn btn-info" id="button_responder_mensaje_'+contador+'">Responder</button>').appendTo($grouplist);

//					$('<li>' + mensaje.emaildestino + '</li>').appendTo(
//							$grouplist);

					$("<hr noshade size=7> ").appendTo($grouplist);
					
					destinatario[contador]= mensaje.emailorigen;
					anuncioid[contador]= mensaje.anuncioid;
					console.log(destinatario[contador]);
					console.log(anuncioid[contador]);
					contador++;
					
					
				});

			}).fail(function() {
		$("#mensajes_result").text("No hay mensajes");
	});

}

var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var user = $.cookie('email');
var password = $.cookie('userpass');

$(document).ready(function() {
	getUser();
	console.log("has pulsado el boton");
});

$("#button_update_user").click(function(e) {
	e.preventDefault();
	Modificar();
});

//function Modificar() {
//
//	var url = API_BASE_URL + '/users/' + user;
//	var object = new Object();
//	object.name = $("#name").val();
//	object.phone = $("#phone").val();
//	object.ciudad = $("#ciudad").val();
//	object.calle = $("#calle").val();
//	object.numero = $("#numero").val();
//	object.piso = $("#piso").val();
//	object.puerta = $("#puerta").val();
//
//	var data = JSON.stringify(object);
//
//	$.ajax(
//			{
//				url : url,
//				type : 'PUT',
//				crossDomain : true,
//				dataType : 'json',
//				headers : {
//					"Accept" : "application/vnd.virtual.api.user+json",
//					"Content-Type" : "application/vnd.virtual.api.user+json"
//				},
//				beforeSend : function(request) {
//					request.withCredentials = true;
//					request.setRequestHeader("Authorization", "Basic "
//							+ btoa(user + ':' + password));
//				},
//			}).done(function(data, status, jqxhr) {
//
//		$("#update_result").text("Datos modificados correctamente");
//	}).fail(function(jqXHR, textStatus) {
//		$("#update_result").text("Error al modificar los datos");
//	});
//}

function getUser() {
	var url = API_BASE_URL + "/users/" + user;

	$.ajax(
			{
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				headers : {
					"Accept" : "application/vnd.virtual.api.user+json",
				},
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(user + ':' + password));
				},
			}).done(function(data, status, jqxhr) {
		var user = JSON.parse(jqxhr.responseText);

		$("#name").val(user.name);
		$("#phone").val(user.phone);
		$("#ciudad").val(user.ciudad);
		$("#calle").val(user.calle);
		$("#numero").val(user.numero);
		$("#piso").val(user.piso);
		$("#puerta").val(user.puerta);

	}).fail(function() {
		console.log("error");
	});

}



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
        window.location = "http://localhost/virtualtrade/index.html";
}



function Modificar() {
	var url = API_BASE_URL + '/users/' + user;
	var object = new Object();
	object.name = $("#name").val();
	object.phone = $("#phone").val();
	object.ciudad = $("#ciudad").val();
	object.calle = $("#calle").val();
	object.numero = $("#numero").val();
	object.piso = $("#piso").val();
	object.puerta = $("#puerta").val();


	var data = JSON.stringify(object);
	$.ajax({
		url : url,
		type : 'PUT',
		dataType : "json",
		crossDomain : true,
		headers : {
			"Accept" : "application/vnd.virtual.api.user+json",
			"Content-Type" : "application/vnd.virtual.api.user+json"
		},
		data : data,
		beforeSend : function(request) {
			request.withCredentials = true;
			request.setRequestHeader("Authorization", "Basic "
					+ btoa(user + ':' + password));
		},
	}).done(function(data, status, jqxhr) {
		
		document.location.href=("http://localhost/virtualtrade/perfil.html");

		$("#update_result").text("Usuario modificado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#update_result").text("Usuario no modificado");
	});
}
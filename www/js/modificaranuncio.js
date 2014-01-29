var API_BASE_URL = "http://147.83.7.155:8080/virtualtrade-api";

var user = $.cookie('email');
var password = $.cookie('userpass');
var idanuncio = $.cookie('id');

$(document).ready(function() {
	console.log(idanuncio);
	getAnuncio();
	console.log("has pulsado el boton");
	
	
    $("#atributo_2").chained("#atributo_1");
    $("#atributo_3").chained("#atributo_2");
    $("#atributo_4").chained("#atributo_2");
	
	
});

$("#button_update_user").click(function(e) {
	e.preventDefault();
	Modificar();
});


function getAnuncio() {
	var url = API_BASE_URL + "/anuncios/" + idanuncio;

	$.ajax(
			{
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				headers : {
					"Accept" : "application/vnd.virtual.api.anuncio+json",
				},
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(user + ':' + password));
				},
			}).done(function(data, status, jqxhr) {
		var object = JSON.parse(jqxhr.responseText);
		$("#name").val(object.subject);
		$("#phone").val(object.content);
		$("#calle").val(object.precio);
		$('#atributo_1 :selected').val(object.atributo1);
		$('#atributo_2 :selected').val(object.atributo2);
		$('#atributo_3 :selected').val(object.atributo3);
		$('#atributo_4 :selected').val(object.marca);
//		
//		$("#atributo_2").val(object.atributo2);
//		$("#atributo_3").val(object.atributo3);
//		$("#atributo_4").val(object.marca);
//		$("#numero").val(object.marca);

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
        window.location = "http://147.83.7.155/virtualtrade/index.html";
}



function Modificar() {
	
	var url = API_BASE_URL + "/anuncios/" + idanuncio;
	var object = new Object();

	object.subject = $("#name").val();
	object.content = $("#phone").val();
	object.precio = $("#calle").val();
//	object.marca = $("#numero").val();

    object.atributo1 = $('#atributo_1 :selected').val();
    object.atributo2 = $('#atributo_2 :selected').val();
    object.atributo3 = $('#atributo_3 :selected').val();
    object.marca = $('#atributo_4 :selected').val();
	
    
    
    
//	$("#name").val(object.subject);
//	$("#phone").val(object.content);
//	$("#calle").val(object.precio);
//	$("#numero").val(object.marca);
//	
//	
//	
//	object.name = $("#name").val();
//	object.phone = $("#phone").val();
//	object.ciudad = $("#ciudad").val();
//	object.calle = $("#calle").val();
//	object.numero = $("#numero").val();
//	object.piso = $("#piso").val();
//	object.puerta = $("#puerta").val();


	var data = JSON.stringify(object);
	$.ajax({
		url : url,
		type : 'PUT',
		dataType : "json",
		crossDomain : true,
		headers : {
			"Accept" : "application/vnd.virtual.api.anuncio+json",
			"Content-Type" : "application/vnd.virtual.api.anuncio+json"
		},
		data : data,
		beforeSend : function(request) {
			request.withCredentials = true;
			request.setRequestHeader("Authorization", "Basic "
					+ btoa(user + ':' + password));
		},
	}).done(function(data, status, jqxhr) {
		document.location.href=("http://147.83.7.155/virtualtrade/anuncio.html");

		$("#update_result").text("Anuncio modificado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#update_result").text("Anuncio no modificado");
	});
}
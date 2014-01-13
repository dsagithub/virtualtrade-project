var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$(document).ready(function() {
	$("#atributo_2").chained("#atributo_1");
	$("#atributo_3").chained("#atributo_2");
	$("#atributo_4").chained("#atributo_2");


});



$("#button_post_anuncio").click(function(e) {
	e.preventDefault();
	create();
});

function create() {
	
	var usrmail=getUser($.cookie('email'));
	var usrpass=getUser($.cookie('userpass'));

	var url = API_BASE_URL + '/anuncios';
	var object = new Object();
	var imagen = new Object();
	object.subject = $("#subject").val();
	object.content = $("#content").val();
	object.precio=$("#precio").val();
	object.atributo1=$('#atributo_1 :selected').val();
	object.atributo2=$('#atributo_2 :selected').val();
	object.atributo3=$('#atributo_3 :selected').val();
	object.marca=$('#atributo_4 :selected').val();
	object.estado = true;
	imagen.foto1 = $('#fileupload1').val();
	imagen.foto2 = $('#fileupload1').val();
	imagen.foto3 = $('#fileupload1').val();

	var data = JSON.stringify(object);
	$.ajax(
			{
				url : url,
				type : 'POST',
				dataType : "json",
				crossDomain : true,
				headers : {
					"Accept" : "application/vnd.virtual.api.anuncio+json",
					"Content-Type" : "application/vnd.virtual.api.anuncio+json"
				},
				data : data,
				username : usrmail,
				password : usrpass,
				
			}).done(function(data, status, jqxhr) {
		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
	
	var data2 = JSON.stringify(imagen);
	$.ajax(
			{
				url : url,
				type : 'POST',
				dataType : "json",
				crossDomain : true,
				headers : {
					"Accept" : "application/vnd.virtual.api.picture+json",
					"Content-Type" : "application/vnd.virtual.api.picture+json"
				},
				data : data2,
				username : 'arnaumail',
				password : 'arnau',
				
			}).done(function(data2, status, jqxhr) {
		$("#create_result").text("Imagen agregada correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("Imagen no agregada");
	});
	
	
	
	
	
}


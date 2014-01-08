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
	

	var url = API_BASE_URL + '/anuncios';
	var object = new Object();
	object.subject = $("#subject").val();
	object.content = $("#content").val();
	object.precio=$("#precio").val();
	object.atributo1=$('#atributo_1 :selected').val();
	object.atributo2=$('#atributo_2 :selected').val();
	object.atributo3=$('#atributo_3 :selected').val();
	object.marca=$('#atributo_4 :selected').val();
	object.estado = true;

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
				username : 'arnaumail',
				password : 'arnau',
				
			}).done(function(data, status, jqxhr) {
		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
}


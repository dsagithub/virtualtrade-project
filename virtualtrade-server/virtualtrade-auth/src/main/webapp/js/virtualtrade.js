var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$("#button_get_anuncios").click(function(e) {
	e.preventDefault();
	getAnuncios();
});


function getAnuncios() {
	var url = API_BASE_URL + "/anuncios?offset=0&length=10";

	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
		username : "arnaumail",
		password : "arnau",

	}).done(function(data, status, jqxhr) {
		var response = JSON.parse(jqxhr.responseText);
		var anuncios = response.anuncios;

		$("#anuncios_result").text("");

		$.each(anuncios, function(i, v) {
			var anuncio = v;
			var $grouplist = $('#anuncios_result');
			$('<li>' + anuncio.anuncioid + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.email + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.subject + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.content + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.estado + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.precio + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.creation_timestamp + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.atributo1 + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.atributo2 + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.atributo3 + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.marca + '</li>').appendTo($grouplist);
			
			
			
			$('<li>' + anuncio.imagenes + '</li>').appendTo($grouplist);
			$("<HR>").appendTo($grouplist);

		});
	}).fail(function() {
		$("#anuncios_result").text("No hay anuncios");
	});

}


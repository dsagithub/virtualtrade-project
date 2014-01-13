var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$(document).ready(function() {
	getAnuncio();
});

function getAnuncio() {
	//Hay que poner el 3 como una variable en cuanto se le pase la id al clicar en una anuncio
	var url = API_BASE_URL + "/anuncios/3";

	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
		username : "arnaumail",
		password : "arnau",

	}).done(function(data, status, jqxhr) {
		var anuncio = JSON.parse(jqxhr.responseText);

		if(anuncio.estado==true){
		
			
			
			
			var $grouplist = $('#anuncio_result');
			
	//		$('<h2>' + anuncio.subject + '</h2>').appendTo($grouplist);
			$('<h4>'+ anuncio.precio +'euros</h4>').appendTo($grouplist);
			$('<li> Descripci&oacuten: ' + anuncio.content + '</li>').appendTo($grouplist);
			$('<li>Usuario vendedor: ' + anuncio.email + '</li>').appendTo($grouplist);
			$('<li>' + anuncio.creation_timestamp + '</li>').appendTo($grouplist);
			$('<li>Marca del producto: ' + anuncio.marca + '</li>').appendTo($grouplist);	

			var imagenes = anuncio.imagenes;
			$.each(imagenes, function(i,v){
			var	imagen=v;
				$('<span class="span3"><img src="' + imagen.urlimagen + '"border="1" width="160" height="90"></span>').appendTo($grouplist);	
			});
			
			$("<HR>").appendTo($grouplist);
		}
		
		else if(anuncio.estado==false){
			
			$("#anuncio_result").text("Articulo vendido");
			
		}
		
	}).fail(function() {
		$("#anuncio_result").text("No hay anuncios");
	});

}




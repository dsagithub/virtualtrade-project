var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var id = $.cookie('id');

$(document).ready(function() {
	getanuncio();
});

function getanuncio() {

	console.log(id);
	console.log("geawgd");

	var url = API_BASE_URL + "/anuncios/"+id;

	$.ajax(
			{
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa('arnaumail' + ':' + 'arnau'));
				},

			}).done(function(data, status, jqxhr) {
	//	var response = JSON.parse(jqxhr.responseText);
		var anuncio = JSON.parse(jqxhr.responseText);
	//	var anuncio = response.anuncio;
	//	var links = response.links;

		// $.cookie('idanuncio', );

//		next = links[0].uri;
//		prev = links[1].uri;

//		console.log("El proximo next es:" + next);

		

			foto_anuncio1.src = anuncio.imagenes[0].urlimagen;
			$("#title1").text(anuncio.subject);
			$("titulooo").text(anuncio.subject);
			$("#content1").text(anuncio.content);
			$("#precio1").text(anuncio.precio + " \u20ac");
		
			if(anuncio.imagenes[1].urlimagen != undefined){
				foto_anuncio2.src = anuncio.imagenes[1].urlimagen;
			}
			
			else if (anuncio.imagenes[1].urlimagen != undefined){
				foto_anuncio3.src = anuncio.imagenes[2].urlimagen;
			}
			
			
//		
//		else if (id == 2) {
//
//			foto_anuncio1.src = anuncios[1].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[1].subject);
//			$("#content1").text(anuncios[1].content);
//			$("#precio1").text(anuncios[1].precio + " \u20ac");
//		}
//		else if (id == 3) {
//
//			foto_anuncio1.src = anuncios[2].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[2].subject);
//			$("#content1").text(anuncios[2].content);
//			$("#precio1").text(anuncios[2].precio + " \u20ac");
//		}
//
//		else if (id == 4) {
//
//			foto_anuncio1.src = anuncios[3].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[3].subject);
//			$("#content1").text(anuncios[3].content);
//			$("#precio1").text(anuncios[3].precio + " \u20ac");
//		}
//		
//		
//		else if (id == 4) {
//
//			foto_anuncio1.src = anuncios[3].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[3].subject);
//			$("#content1").text(anuncios[3].content);
//			$("#precio1").text(anuncios[3].precio + " \u20ac");
//		}
//		
//		else if (id == 5) {
//
//			foto_anuncio1.src = anuncios[4].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[4].subject);
//			$("#content1").text(anuncios[4].content);
//			$("#precio1").text(anuncios[4].precio + " \u20ac");
//		}
//		else if (id == 6) {
//
//			foto_anuncio1.src = anuncios[5].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[5].subject);
//			$("#content1").text(anuncios[5].content);
//			$("#precio1").text(anuncios[5].precio + " \u20ac");
//		}	else if (id == 7) {
//
//			foto_anuncio1.src = anuncios[6].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[6].subject);
//			$("#content1").text(anuncios[6].content);
//			$("#precio1").text(anuncios[6].precio + " \u20ac");
//		}
//		else if (id == 8) {
//
//			foto_anuncio1.src = anuncios[7].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[7].subject);
//			$("#content1").text(anuncios[7].content);
//			$("#precio1").text(anuncios[7].precio + " \u20ac");
//		}
//		else if (id == 9) {
//
//			foto_anuncio1.src = anuncios[8].imagenes[0].urlimagen;
//			$("#title1").text(anuncios[8].subject);
//			$("#content1").text(anuncios[8].content);
//			$("#precio1").text(anuncios[8].precio + " \u20ac");
//		}
//		

	}).fail(function() {
		$("#anuncios_result").text("No hay anuncios");
	});

	$.removeCookie('id');
}

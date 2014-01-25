var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var prev;
var next;
var id1;
var id2;
var id3;
var id4;
var id5
var id6;
var id7;
var id8
var id9;

$(document).ready(function() {
	getAnuncios_Atributos();
	getMensajes();
	$("#atributo_2").chained("#atributo_1");
	$("#atributo_3").chained("#atributo_2");
	$("#atributo_4").chained("#atributo_2");
	
	console.log($.cookie('email'));
	
	if(	$.cookie('email')==0){	
		
	}
	//	$.cookie('userpass', userpass);)
	
//	ocultar();

	/*
	 * var a= $.cookie('email'); $("#nombreusuarioaqui").text(a);
	 * $("#singup").text(""); $("#signin").text("");
	 */

});

$("#button_prev").click(function(e) {
	e.preventDefault();
	getAnunciosPrev();
});

$("#button_next").click(function(e) {
	e.preventDefault();
	getAnunciosNext();
});


$("#button_get_anuncios_atributos").click(function(e) {
	e.preventDefault();
	getAnuncios_Atributos();
});
//
//function getAnuncio1() {
//
//	var url = API_BASE_URL
//	+ "/anuncios/atributos?offset=0&length=10";
//	
//	$.ajax(
//			{
//				url : url,
//				type : 'GET',
//				crossDomain : true,
//				dataType : 'json',
//				beforeSend : function(request) {
//					request.withCredentials = true;
//					request.setRequestHeader("Authorization", "Basic "
//							+ btoa('arnaumail' + ':' + 'arnau'));
//				},
//
//			}).done(function(data, status, jqxhr) {
//		var response = JSON.parse(jqxhr.responseText);
//		var anuncios = response.anuncios;
//		var links = response.links;
//
//		// $.cookie('idanuncio', );
//
//		next = links[0].uri;
//		prev = links[1].uri;
//
//		console.log("El proximo next es:" + next);
//
//		foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
//		$("#title1").text(anuncios[0].subject);
//		$("#content1").text(anuncios[0].content);
//		$("#precio1").text(anuncios[0].precio + " \u20ac");
//
//	}).fail(function() {
//		$("#anuncios_result").text("No hay anuncios");
//	});
//}


function getAnuncio1() {
	$.cookie('id', id1);
}
function getAnuncio2() {
	
	$.cookie('id', id2);
}
function getAnuncio3() {
	
	$.cookie('id', id3);
}
function getAnuncio4() {
	
	$.cookie('id', id4);
}
function getAnuncio5() {
	
	$.cookie('id', id5);
}
function getAnuncio6() {
	
	$.cookie('id', id6);
}
function getAnuncio7() {
	
	$.cookie('id', id7);
}
function getAnuncio8() {
	
	$.cookie('id', id8);
}
function getAnuncio9() {
	
	$.cookie('id', id9);
}



function getAnuncios_Atributos(atributo1, atributo2, atributo3, atributo4) {

	
	
	atributo1 = $('#atributo_1 :selected').val();
	atributo2 = $('#atributo_2 :selected').val();
	atributo3 = $('#atributo_3 :selected').val();
	atributo4 = $('#atributo_4 :selected').val();

	if (atributo4 != "all" & atributo3 != "all") {
		var url = API_BASE_URL
				+ "/anuncios/atributos?offset=0&length=9&atributo1="
				+ atributo1 + "&atributo2=" + atributo2 + "&atributo3="
				+ atributo3 + "&marca=" + atributo4 + "";

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
			var response = JSON.parse(jqxhr.responseText);
			var anuncios = response.anuncios;
			var links = response.links;

			
			
			// $.cookie('idanuncio', );

			next = links[0].uri;
			prev = links[1].uri;

			console.log("El proximo next es:" + next);

			foto_anuncio1.src = null;
			$("#title1").text(null);
			$("#content1").text(null);
			$("#precio1").text(null);

			
			foto_anuncio2.src = null;
			$("#title2").text(null);
			$("#content2").text(null);
			$("#precio2").text(null);

			foto_anuncio3.src = null;
			$("#title3").text(null);
			$("#content3").text(null);
			$("#precio3").text(null);

			foto_anuncio4.src = null;
			$("#title4").text(null);
			$("#content4").text(null);
			$("#precio4").text(null);

			foto_anuncio5.src = null;
			$("#title5").text(null);
			$("#content5").text(null);
			$("#precio5").text(null);

			foto_anuncio6.src = null;
			$("#title6").text(null);
			$("#content6").text(null);
			$("#precio6").text(null);

			foto_anuncio7.src = null;
			$("#title7").text(null);
			$("#content7").text(null);
			$("#precio7").text(null);

			foto_anuncio8.src = null;
			$("#title8").text(null);
			$("#content8").text(null);
			$("#precio8").text(null);

			foto_anuncio9.src = null;
			$("#title9").text(null);
			$("#content9").text(null);
			$("#precio9").text(null);

			foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
			$("#title1").text(anuncios[0].subject);
			$("#content1").text(anuncios[0].content);
			$("#precio1").text(anuncios[0].precio + " \u20ac");
			id1=anuncios[0].anuncioid;

			console.log(id1);

			foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
			$("#title2").text(anuncios[1].subject);
			$("#content2").text(anuncios[1].content);
			$("#precio2").text(anuncios[1].precio + " \u20ac");
			id2=anuncios[1].anuncioid;

			foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
			$("#title3").text(anuncios[2].subject);
			$("#content3").text(anuncios[2].content);
			$("#precio3").text(anuncios[2].precio + " \u20ac");
			id3=anuncios[2].anuncioid;

			foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
			$("#title4").text(anuncios[3].subject);
			$("#content4").text(anuncios[3].content);
			$("#precio4").text(anuncios[3].precio + " \u20ac");
			id4=anuncios[3].anuncioid;

			foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
			$("#title5").text(anuncios[4].subject);
			$("#content5").text(anuncios[4].content);
			$("#precio5").text(anuncios[4].precio + " \u20ac");
			id5=anuncios[4].anuncioid;

			foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
			$("#title6").text(anuncios[5].subject);
			$("#content6").text(anuncios[5].content);
			$("#precio6").text(anuncios[5].precio + " \u20ac");
			id6=anuncios[5].anuncioid;

			foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
			$("#title7").text(anuncios[6].subject);
			$("#content7").text(anuncios[6].content);
			$("#precio7").text(anuncios[6].precio + " \u20ac");
			id7=anuncios[6].anuncioid;

			foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
			$("#title8").text(anuncios[7].subject);
			$("#content8").text(anuncios[7].content);
			$("#precio8").text(anuncios[7].precio + " \u20ac");
			id8=anuncios[7].anuncioid;

			foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
			$("#title9").text(anuncios[8].subject);
			$("#content9").text(anuncios[8].content);
			$("#precio9").text(anuncios[8].precio + " \u20ac");
			id9=anuncios[8].anuncioid;
			
			console.log(id1);

		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});
	}

	else if (atributo3 != "all") {

		var url = API_BASE_URL
				+ "/anuncios/atributos?offset=0&length=9&atributo1="
				+ atributo1 + "&atributo2=" + atributo2 + "&atributo3="
				+ atributo3;

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
			var response = JSON.parse(jqxhr.responseText);
			var anuncios = response.anuncios;
			var links = response.links;

			next = links[0].uri;
			prev = links[1].uri;

			console.log("El proximo next es:" + next);

			foto_anuncio1.src = null;
			$("#title1").text(null);
			$("#content1").text(null);
			$("#precio1").text(null);

			foto_anuncio2.src = null;
			$("#title2").text(null);
			$("#content2").text(null);
			$("#precio2").text(null);

			foto_anuncio3.src = null;
			$("#title3").text(null);
			$("#content3").text(null);
			$("#precio3").text(null);

			foto_anuncio4.src = null;
			$("#title4").text(null);
			$("#content4").text(null);
			$("#precio4").text(null);

			foto_anuncio5.src = null;
			$("#title5").text(null);
			$("#content5").text(null);
			$("#precio5").text(null);

			foto_anuncio6.src = null;
			$("#title6").text(null);
			$("#content6").text(null);
			$("#precio6").text(null);

			foto_anuncio7.src = null;
			$("#title7").text(null);
			$("#content7").text(null);
			$("#precio7").text(null);

			foto_anuncio8.src = null;
			$("#title8").text(null);
			$("#content8").text(null);
			$("#precio8").text(null);

			foto_anuncio9.src = null;
			$("#title9").text(null);
			$("#content9").text(null);
			$("#precio9").text(null);

			foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
			$("#title1").text(anuncios[0].subject);
			$("#content1").text(anuncios[0].content);
			$("#precio1").text(anuncios[0].precio + " \u20ac");
			id1=anuncios[0].anuncioid;

			console.log(id1);

			foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
			$("#title2").text(anuncios[1].subject);
			$("#content2").text(anuncios[1].content);
			$("#precio2").text(anuncios[1].precio + " \u20ac");
			id2=anuncios[1].anuncioid;

			foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
			$("#title3").text(anuncios[2].subject);
			$("#content3").text(anuncios[2].content);
			$("#precio3").text(anuncios[2].precio + " \u20ac");
			id3=anuncios[2].anuncioid;

			foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
			$("#title4").text(anuncios[3].subject);
			$("#content4").text(anuncios[3].content);
			$("#precio4").text(anuncios[3].precio + " \u20ac");
			id4=anuncios[3].anuncioid;

			foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
			$("#title5").text(anuncios[4].subject);
			$("#content5").text(anuncios[4].content);
			$("#precio5").text(anuncios[4].precio + " \u20ac");
			id5=anuncios[4].anuncioid;

			foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
			$("#title6").text(anuncios[5].subject);
			$("#content6").text(anuncios[5].content);
			$("#precio6").text(anuncios[5].precio + " \u20ac");
			id6=anuncios[5].anuncioid;

			foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
			$("#title7").text(anuncios[6].subject);
			$("#content7").text(anuncios[6].content);
			$("#precio7").text(anuncios[6].precio + " \u20ac");
			id7=anuncios[6].anuncioid;

			foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
			$("#title8").text(anuncios[7].subject);
			$("#content8").text(anuncios[7].content);
			$("#precio8").text(anuncios[7].precio + " \u20ac");
			id8=anuncios[7].anuncioid;

			foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
			$("#title9").text(anuncios[8].subject);
			$("#content9").text(anuncios[8].content);
			$("#precio9").text(anuncios[8].precio + " \u20ac");
			id9=anuncios[8].anuncioid;

		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});

	}

	else if (atributo2 != "all") {

		var url = API_BASE_URL
				+ "/anuncios/atributos?offset=0&length=9&atributo1="
				+ atributo1 + "&atributo2=" + atributo2;

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
			var response = JSON.parse(jqxhr.responseText);
			var anuncios = response.anuncios;
			var links = response.links;

			next = links[0].uri;
			prev = links[1].uri;

			console.log("El proximo next es:" + next);

			foto_anuncio1.src = null;
			$("#title1").text(null);
			$("#content1").text(null);
			$("#precio1").text(null);

			foto_anuncio2.src = null;
			$("#title2").text(null);
			$("#content2").text(null);
			$("#precio2").text(null);

			foto_anuncio3.src = null;
			$("#title3").text(null);
			$("#content3").text(null);
			$("#precio3").text(null);

			foto_anuncio4.src = null;
			$("#title4").text(null);
			$("#content4").text(null);
			$("#precio4").text(null);

			foto_anuncio5.src = null;
			$("#title5").text(null);
			$("#content5").text(null);
			$("#precio5").text(null);

			foto_anuncio6.src = null;
			$("#title6").text(null);
			$("#content6").text(null);
			$("#precio6").text(null);

			foto_anuncio7.src = null;
			$("#title7").text(null);
			$("#content7").text(null);
			$("#precio7").text(null);

			foto_anuncio8.src = null;
			$("#title8").text(null);
			$("#content8").text(null);
			$("#precio8").text(null);

			foto_anuncio9.src = null;
			$("#title9").text(null);
			$("#content9").text(null);
			$("#precio9").text(null);

			foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
			$("#title1").text(anuncios[0].subject);
			$("#content1").text(anuncios[0].content);
			$("#precio1").text(anuncios[0].precio + " \u20ac");
			id1=anuncios[0].anuncioid;

			console.log(id1);

			foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
			$("#title2").text(anuncios[1].subject);
			$("#content2").text(anuncios[1].content);
			$("#precio2").text(anuncios[1].precio + " \u20ac");
			id2=anuncios[1].anuncioid;

			foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
			$("#title3").text(anuncios[2].subject);
			$("#content3").text(anuncios[2].content);
			$("#precio3").text(anuncios[2].precio + " \u20ac");
			id3=anuncios[2].anuncioid;

			foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
			$("#title4").text(anuncios[3].subject);
			$("#content4").text(anuncios[3].content);
			$("#precio4").text(anuncios[3].precio + " \u20ac");
			id4=anuncios[3].anuncioid;

			foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
			$("#title5").text(anuncios[4].subject);
			$("#content5").text(anuncios[4].content);
			$("#precio5").text(anuncios[4].precio + " \u20ac");
			id5=anuncios[4].anuncioid;

			foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
			$("#title6").text(anuncios[5].subject);
			$("#content6").text(anuncios[5].content);
			$("#precio6").text(anuncios[5].precio + " \u20ac");
			id6=anuncios[5].anuncioid;

			foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
			$("#title7").text(anuncios[6].subject);
			$("#content7").text(anuncios[6].content);
			$("#precio7").text(anuncios[6].precio + " \u20ac");
			id7=anuncios[6].anuncioid;

			foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
			$("#title8").text(anuncios[7].subject);
			$("#content8").text(anuncios[7].content);
			$("#precio8").text(anuncios[7].precio + " \u20ac");
			id8=anuncios[7].anuncioid;

			foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
			$("#title9").text(anuncios[8].subject);
			$("#content9").text(anuncios[8].content);
			$("#precio9").text(anuncios[8].precio + " \u20ac");
			id9=anuncios[8].anuncioid;

		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});

	}

	else if (atributo1 != "all") {

		var url = API_BASE_URL
				+ "/anuncios/atributos?offset=0&length=9&atributo1="
				+ atributo1;

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
			var response = JSON.parse(jqxhr.responseText);
			var anuncios = response.anuncios;
			var links = response.links;

			next = links[0].uri;
			prev = links[1].uri;

			console.log("El proximo next es:" + next);

			foto_anuncio1.src = null;
			$("#title1").text(null);
			$("#content1").text(null);
			$("#precio1").text(null);

			foto_anuncio2.src = null;
			$("#title2").text(null);
			$("#content2").text(null);
			$("#precio2").text(null);

			foto_anuncio3.src = null;
			$("#title3").text(null);
			$("#content3").text(null);
			$("#precio3").text(null);

			foto_anuncio4.src = null;
			$("#title4").text(null);
			$("#content4").text(null);
			$("#precio4").text(null);

			foto_anuncio5.src = null;
			$("#title5").text(null);
			$("#content5").text(null);
			$("#precio5").text(null);

			foto_anuncio6.src = null;
			$("#title6").text(null);
			$("#content6").text(null);
			$("#precio6").text(null);

			foto_anuncio7.src = null;
			$("#title7").text(null);
			$("#content7").text(null);
			$("#precio7").text(null);

			foto_anuncio8.src = null;
			$("#title8").text(null);
			$("#content8").text(null);
			$("#precio8").text(null);

			foto_anuncio9.src = null;
			$("#title9").text(null);
			$("#content9").text(null);
			$("#precio9").text(null);

			foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
			$("#title1").text(anuncios[0].subject);
			$("#content1").text(anuncios[0].content);
			$("#precio1").text(anuncios[0].precio + " \u20ac");
			id1=anuncios[0].anuncioid;

			console.log(id1);

			foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
			$("#title2").text(anuncios[1].subject);
			$("#content2").text(anuncios[1].content);
			$("#precio2").text(anuncios[1].precio + " \u20ac");
			id2=anuncios[1].anuncioid;

			foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
			$("#title3").text(anuncios[2].subject);
			$("#content3").text(anuncios[2].content);
			$("#precio3").text(anuncios[2].precio + " \u20ac");
			id3=anuncios[2].anuncioid;

			foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
			$("#title4").text(anuncios[3].subject);
			$("#content4").text(anuncios[3].content);
			$("#precio4").text(anuncios[3].precio + " \u20ac");
			id4=anuncios[3].anuncioid;

			foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
			$("#title5").text(anuncios[4].subject);
			$("#content5").text(anuncios[4].content);
			$("#precio5").text(anuncios[4].precio + " \u20ac");
			id5=anuncios[4].anuncioid;

			foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
			$("#title6").text(anuncios[5].subject);
			$("#content6").text(anuncios[5].content);
			$("#precio6").text(anuncios[5].precio + " \u20ac");
			id6=anuncios[5].anuncioid;

			foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
			$("#title7").text(anuncios[6].subject);
			$("#content7").text(anuncios[6].content);
			$("#precio7").text(anuncios[6].precio + " \u20ac");
			id7=anuncios[6].anuncioid;

			foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
			$("#title8").text(anuncios[7].subject);
			$("#content8").text(anuncios[7].content);
			$("#precio8").text(anuncios[7].precio + " \u20ac");
			id8=anuncios[7].anuncioid;

			foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
			$("#title9").text(anuncios[8].subject);
			$("#content9").text(anuncios[8].content);
			$("#precio9").text(anuncios[8].precio + " \u20ac");
			id9=anuncios[8].anuncioid;
			
		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});

	}

	else if (atributo1 == "all") {

		var url = API_BASE_URL + "/anuncios?offset=0&length=9";

		$.ajax({
			url : url,
			type : 'GET',
			crossDomain : true,
			dataType : 'json'

		}).done(function(data, status, jqxhr) {
			var response = JSON.parse(jqxhr.responseText);
			var anuncios = response.anuncios;
			var links = response.links;

			next = links[0].uri;
			prev = links[1].uri;

			foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
			$("#title1").text(anuncios[0].subject);
			$("#content1").text(anuncios[0].content);
			$("#precio1").text(anuncios[0].precio + " \u20ac");
			id1=anuncios[0].anuncioid;

			console.log(id1);

			foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
			$("#title2").text(anuncios[1].subject);
			$("#content2").text(anuncios[1].content);
			$("#precio2").text(anuncios[1].precio + " \u20ac");
			id2=anuncios[1].anuncioid;

			foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
			$("#title3").text(anuncios[2].subject);
			$("#content3").text(anuncios[2].content);
			$("#precio3").text(anuncios[2].precio + " \u20ac");
			id3=anuncios[2].anuncioid;

			foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
			$("#title4").text(anuncios[3].subject);
			$("#content4").text(anuncios[3].content);
			$("#precio4").text(anuncios[3].precio + " \u20ac");
			id4=anuncios[3].anuncioid;

			foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
			$("#title5").text(anuncios[4].subject);
			$("#content5").text(anuncios[4].content);
			$("#precio5").text(anuncios[4].precio + " \u20ac");
			id5=anuncios[4].anuncioid;

			foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
			$("#title6").text(anuncios[5].subject);
			$("#content6").text(anuncios[5].content);
			$("#precio6").text(anuncios[5].precio + " \u20ac");
			id6=anuncios[5].anuncioid;

			foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
			$("#title7").text(anuncios[6].subject);
			$("#content7").text(anuncios[6].content);
			$("#precio7").text(anuncios[6].precio + " \u20ac");
			id7=anuncios[6].anuncioid;

			foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
			$("#title8").text(anuncios[7].subject);
			$("#content8").text(anuncios[7].content);
			$("#precio8").text(anuncios[7].precio + " \u20ac");
			id8=anuncios[7].anuncioid;

			foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
			$("#title9").text(anuncios[8].subject);
			$("#content9").text(anuncios[8].content);
			$("#precio9").text(anuncios[8].precio + " \u20ac");
			id9=anuncios[8].anuncioid;

		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});

	}

}

// function getAnuncios() {
//
// var url = API_BASE_URL + "/anuncios?offset=0&length=9";
//
// $.ajax({
// url : url,
// type : 'GET',
// crossDomain : true,
// dataType : 'json'
//
// }).done(function(data, status, jqxhr) {
// var response = JSON.parse(jqxhr.responseText);
// var anuncios = response.anuncios;
// var links = response.links;
//
// next = links[0].uri;
// prev = links[1].uri;
//
// console.log("Pag principal, next:"+next);
//
// foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
// $("#title1").text(anuncios[0].subject);
// $("#content1").text(anuncios[0].content);
// $("#precio1").text(anuncios[0].precio + " \u20ac");
//
// foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
// $("#title2").text(anuncios[1].subject);
// $("#content2").text(anuncios[1].content);
// $("#precio2").text(anuncios[1].precio + " \u20ac");
//
// foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
// $("#title3").text(anuncios[2].subject);
// $("#content3").text(anuncios[2].content);
// $("#precio3").text(anuncios[2].precio + " \u20ac");
//
// foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
// $("#title4").text(anuncios[3].subject);
// $("#content4").text(anuncios[3].content);
// $("#precio4").text(anuncios[3].precio + " \u20ac");
//
// foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
// $("#title5").text(anuncios[4].subject);
// $("#content5").text(anuncios[4].content);
// $("#precio5").text(anuncios[4].precio + " \u20ac");
//
// foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
// $("#title6").text(anuncios[5].subject);
// $("#content6").text(anuncios[5].content);
// $("#precio6").text(anuncios[5].precio + " \u20ac");
//
// foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
// $("#title7").text(anuncios[6].subject);
// $("#content7").text(anuncios[6].content);
// $("#precio7").text(anuncios[6].precio + " \u20ac");
//
// foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
// $("#title8").text(anuncios[7].subject);
// $("#content8").text(anuncios[7].content);
// $("#precio8").text(anuncios[7].precio + " \u20ac");
//
// foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
// $("#title9").text(anuncios[8].subject);
// $("#content9").text(anuncios[8].content);
// $("#precio9").text(anuncios[8].precio + " \u20ac");
//
// }).fail(function() {
// $("#anuncios_result").text("No hay anuncios");
// });
//
// }

function getAnunciosNext() {

	console.log("prev:" + prev);
	console.log("next:" + next);

	var url = next;

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
		var response = JSON.parse(jqxhr.responseText);
		var anuncios = response.anuncios;
		var links = response.links;

		next = links[0].uri;
		prev = links[1].uri;

		console.log("El proximo next es:" + next);

		foto_anuncio1.src = null;
		$("#title1").text(null);
		$("#content1").text(null);
		$("#precio1").text(null);

		foto_anuncio2.src = null;
		$("#title2").text(null);
		$("#content2").text(null);
		$("#precio2").text(null);

		foto_anuncio3.src = null;
		$("#title3").text(null);
		$("#content3").text(null);
		$("#precio3").text(null);

		foto_anuncio4.src = null;
		$("#title4").text(null);
		$("#content4").text(null);
		$("#precio4").text(null);

		foto_anuncio5.src = null;
		$("#title5").text(null);
		$("#content5").text(null);
		$("#precio5").text(null);

		foto_anuncio6.src = null;
		$("#title6").text(null);
		$("#content6").text(null);
		$("#precio6").text(null);

		foto_anuncio7.src = null;
		$("#title7").text(null);
		$("#content7").text(null);
		$("#precio7").text(null);

		foto_anuncio8.src = null;
		$("#title8").text(null);
		$("#content8").text(null);
		$("#precio8").text(null);

		foto_anuncio9.src = null;
		$("#title9").text(null);
		$("#content9").text(null);
		$("#precio9").text(null);

		foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
		$("#title1").text(anuncios[0].subject);
		$("#content1").text(anuncios[0].content);
		$("#precio1").text(anuncios[0].precio + " \u20ac");
		id1=anuncios[0].anuncioid;

		console.log(id1);

		foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
		$("#title2").text(anuncios[1].subject);
		$("#content2").text(anuncios[1].content);
		$("#precio2").text(anuncios[1].precio + " \u20ac");
		id2=anuncios[1].anuncioid;

		foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
		$("#title3").text(anuncios[2].subject);
		$("#content3").text(anuncios[2].content);
		$("#precio3").text(anuncios[2].precio + " \u20ac");
		id3=anuncios[2].anuncioid;

		foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
		$("#title4").text(anuncios[3].subject);
		$("#content4").text(anuncios[3].content);
		$("#precio4").text(anuncios[3].precio + " \u20ac");
		id4=anuncios[3].anuncioid;

		foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
		$("#title5").text(anuncios[4].subject);
		$("#content5").text(anuncios[4].content);
		$("#precio5").text(anuncios[4].precio + " \u20ac");
		id5=anuncios[4].anuncioid;

		foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
		$("#title6").text(anuncios[5].subject);
		$("#content6").text(anuncios[5].content);
		$("#precio6").text(anuncios[5].precio + " \u20ac");
		id6=anuncios[5].anuncioid;

		foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
		$("#title7").text(anuncios[6].subject);
		$("#content7").text(anuncios[6].content);
		$("#precio7").text(anuncios[6].precio + " \u20ac");
		id7=anuncios[6].anuncioid;

		foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
		$("#title8").text(anuncios[7].subject);
		$("#content8").text(anuncios[7].content);
		$("#precio8").text(anuncios[7].precio + " \u20ac");
		id8=anuncios[7].anuncioid;

		foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
		$("#title9").text(anuncios[8].subject);
		$("#content9").text(anuncios[8].content);
		$("#precio9").text(anuncios[8].precio + " \u20ac");
		id9=anuncios[8].anuncioid;
		

	}).fail(function() {
		$("#anuncios_result").text("No hay anuncios");
	});

}

function getAnunciosPrev() {

	var url = prev;
	console.log("prev:" + prev);
	console.log("next:" + next);

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
		var response = JSON.parse(jqxhr.responseText);
		var anuncios = response.anuncios;
		var links = response.links;

		next = links[0].uri;
		prev = links[1].uri;

		console.log("El proximo prev es:" + next);

		foto_anuncio1.src = null;
		$("#title1").text(null);
		$("#content1").text(null);
		$("#precio1").text(null);

		foto_anuncio2.src = null;
		$("#title2").text(null);
		$("#content2").text(null);
		$("#precio2").text(null);

		foto_anuncio3.src = null;
		$("#title3").text(null);
		$("#content3").text(null);
		$("#precio3").text(null);

		foto_anuncio4.src = null;
		$("#title4").text(null);
		$("#content4").text(null);
		$("#precio4").text(null);

		foto_anuncio5.src = null;
		$("#title5").text(null);
		$("#content5").text(null);
		$("#precio5").text(null);

		foto_anuncio6.src = null;
		$("#title6").text(null);
		$("#content6").text(null);
		$("#precio6").text(null);

		foto_anuncio7.src = null;
		$("#title7").text(null);
		$("#content7").text(null);
		$("#precio7").text(null);

		foto_anuncio8.src = null;
		$("#title8").text(null);
		$("#content8").text(null);
		$("#precio8").text(null);

		foto_anuncio9.src = null;
		$("#title9").text(null);
		$("#content9").text(null);
		$("#precio9").text(null);

		foto_anuncio1.src = anuncios[0].imagenes[0].urlimagen;
		$("#title1").text(anuncios[0].subject);
		$("#content1").text(anuncios[0].content);
		$("#precio1").text(anuncios[0].precio + " \u20ac");
		id1=anuncios[0].anuncioid;

		console.log(id1);

		foto_anuncio2.src = anuncios[1].imagenes[0].urlimagen;
		$("#title2").text(anuncios[1].subject);
		$("#content2").text(anuncios[1].content);
		$("#precio2").text(anuncios[1].precio + " \u20ac");
		id2=anuncios[1].anuncioid;

		foto_anuncio3.src = anuncios[2].imagenes[0].urlimagen;
		$("#title3").text(anuncios[2].subject);
		$("#content3").text(anuncios[2].content);
		$("#precio3").text(anuncios[2].precio + " \u20ac");
		id3=anuncios[2].anuncioid;

		foto_anuncio4.src = anuncios[3].imagenes[0].urlimagen;
		$("#title4").text(anuncios[3].subject);
		$("#content4").text(anuncios[3].content);
		$("#precio4").text(anuncios[3].precio + " \u20ac");
		id4=anuncios[3].anuncioid;

		foto_anuncio5.src = anuncios[4].imagenes[0].urlimagen;
		$("#title5").text(anuncios[4].subject);
		$("#content5").text(anuncios[4].content);
		$("#precio5").text(anuncios[4].precio + " \u20ac");
		id5=anuncios[4].anuncioid;

		foto_anuncio6.src = anuncios[5].imagenes[0].urlimagen;
		$("#title6").text(anuncios[5].subject);
		$("#content6").text(anuncios[5].content);
		$("#precio6").text(anuncios[5].precio + " \u20ac");
		id6=anuncios[5].anuncioid;

		foto_anuncio7.src = anuncios[6].imagenes[0].urlimagen;
		$("#title7").text(anuncios[6].subject);
		$("#content7").text(anuncios[6].content);
		$("#precio7").text(anuncios[6].precio + " \u20ac");
		id7=anuncios[6].anuncioid;

		foto_anuncio8.src = anuncios[7].imagenes[0].urlimagen;
		$("#title8").text(anuncios[7].subject);
		$("#content8").text(anuncios[7].content);
		$("#precio8").text(anuncios[7].precio + " \u20ac");
		id8=anuncios[7].anuncioid;

		foto_anuncio9.src = anuncios[8].imagenes[0].urlimagen;
		$("#title9").text(anuncios[8].subject);
		$("#content9").text(anuncios[8].content);
		$("#precio9").text(anuncios[8].precio + " \u20ac");
		id9=anuncios[8].anuncioid;
		

	}).fail(function() {
		$("#anuncios_result").text("No hay anuncios");
	});

}

function loggedout(){
	$("#logout").hide();
	$("#perfil").hide();
	$("#añadir").hide();
	$("#buscar").hide();
	$("#mensajes").hide();
	
//	perfil
//	añadir
//	buscar
//	mensajes
}
function loggedin(){
	$("#singup").hide();
	$("#signin").hide();
}


function logout(){
	 
//	$.cookie('email', 0);
//	$.cookie('userpass', 0);
//	console.log(cookie('email');
	loggedout();
//	
	$.removeCookie('email');
	$.removeCookie('userpass');
//	
}

function getMensajes() {

	var url = API_BASE_URL + "/mensajes/recibidos?offset=0&length=4";

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

			}).done(
			function(data, status, jqxhr) {
				var response = JSON.parse(jqxhr.responseText);
				var mensajes = response.mensajes;

				$("#mensajes_result").text("");

				$.each(mensajes, function(i, v) {
					var mensaje = v;
					var $grouplist = $('#mensajes_result');
					// $('<li>' + mensaje.anuncioid + '</li>')
					// .appendTo($grouplist);
					// $('<li>' + mensaje.mensajeid + '</li>')
					// .appendTo($grouplist);
					$('<li>Asunto: ' + mensaje.subject + '</li>').appendTo(
							$grouplist);
					$('<li>Contenido: ' + mensaje.content + '</li>').appendTo(
							$grouplist);
					$(
							'<li>Fecha y hora: ' + mensaje.creation_timestamp
									+ '</li>').appendTo($grouplist);
					// $('<li>' + mensaje.emaildestino + '</li>').appendTo(
					// $grouplist);
					$('<li>Origen: ' + mensaje.emailorigen + '</li>').appendTo(
							$grouplist);
					$("<HR>").appendTo($grouplist);
				});

			}).fail(function() {
		$("#mensajes_result").text("No hay mensajes");
	});

}

;
(function($, window, document, undefined) {
	"use strict";

	$.fn.chained = function(parent_selector, options) {

		return this
				.each(function() {

					/*
					 * Save this to child because this changes when scope
					 * changes.
					 */
					var child = this;
					var backup = $(child).clone();

					/* Handles maximum two parents now. */
					$(parent_selector).each(
							function() {
								$(this).bind("change", function() {
									updateChildren();
								});

								/*
								 * Force IE to see something selected on first
								 * page load,
								 */
								/* unless something is already selected */
								if (!$("option:selected", this).length) {
									$("option", this).first().attr("selected",
											"selected");
								}

								/* Force updating the children. */
								updateChildren();
							});

					function updateChildren() {
						var trigger_change = true;
						var currently_selected_value = $("option:selected",
								child).val();

						$(child).html(backup.html());

						/* If multiple parents build classname like foo\bar. */
						var selected = "";
						$(parent_selector).each(
								function() {
									var selectedClass = $("option:selected",
											this).val();
									if (selectedClass) {
										if (selected.length > 0) {
											if (window.Zepto) {
												/*
												 * Zepto class regexp dies with
												 * classes like foo\bar.
												 */
												selected += "\\\\";
											} else {
												selected += "\\";
											}
										}
										selected += selectedClass;
									}
								});

						/* Also check for first parent without subclassing. */
						/*
						 * TODO: This should be dynamic and check for each
						 * parent
						 */
						/* without subclassing. */
						var first;
						if ($.isArray(parent_selector)) {
							first = $(parent_selector[0]).first();
						} else {
							first = $(parent_selector).first();
						}
						var selected_first = $("option:selected", first).val();

						$("option", child)
								.each(
										function() {
											/*
											 * Remove unneeded items but save
											 * the default value.
											 */
											if ($(this).hasClass(selected)
													&& $(this).val() === currently_selected_value) {
												$(this).prop("selected", true);
												trigger_change = false;
											} else if (!$(this).hasClass(
													selected)
													&& !$(this).hasClass(
															selected_first)
													&& $(this).val() !== "") {
												$(this).remove();
											}
										});

						/* If we have only the default value disable select. */
						if (1 === $("option", child).size()
								&& $(child).val() === "") {
							$(child).attr("disabled", "disabled");
						} else {
							$(child).removeAttr("disabled");
						}
						if (trigger_change) {
							$(child).trigger("change");
						}
					}
				});
	};

	/* Alias for those who like to use more English like syntax. */
	$.fn.chainedTo = $.fn.chained;

	/* Default settings for plugin. */
	$.fn.chained.defaults = {};

})(window.jQuery || window.Zepto, window, document);

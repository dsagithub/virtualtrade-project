var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$(document).ready(function() {
	getAnuncios();
	getMensajes();
	$("#atributo_2").chained("#atributo_1");
	$("#atributo_3").chained("#atributo_2");
	$("#atributo_4").chained("#atributo_2");
	
});

$("#button_get_anuncios_atributos").click(function(e) {
	e.preventDefault();
	getAnuncios_Atributos($('#atributo1 :selected').val(),$('#atributo2 :selected').val(),$('#atributo3 :selected').val(),$('#atributo4 :selected').val());
});

function getAnuncios_Atributos(atributo1,atributo2,atributo3,atributo4){
	
	var atributo = new Object();
	
	if(atributo4 != "all"){
		var url = API_BASE_URL +"/anuncios/atributos?offset=0&length=10&atributo1="+atributo1+"&atributo2="+ atributo2 +"&atributo3="+atributo3+"&marca="+atributo4+"";
	
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
				$('<li><img src="' + anuncio.imagenes[0].urlimagen + '"border="1" width="160" height="90"></li>').appendTo($grouplist);				
				$("<HR>").appendTo($grouplist);
			});
			
			
			
			
		}).fail(function() {
			$("#anuncios_result").text("No hay anuncios");
		});

	}

	
	
	else if(atributo3 != "all"){
		
	}

	else if(atributo2 != "all"){
	
	}

	else if(atributo1 != "all"){
	
	}
	
	else if(atributo4 == "all"){
		getAnuncios();
	}
	
	
}


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
			$('<li><img src="' + anuncio.imagenes[0].urlimagen + '"border="1" width="160" height="90"></li>').appendTo($grouplist);				
			$("<HR>").appendTo($grouplist);
		});
		
		
		
		
	}).fail(function() {
		$("#anuncios_result").text("No hay anuncios");
	});

}

function getMensajes() {

	var url = API_BASE_URL + "/mensajes?offset=0&length=4";
	$.ajax({
		url : url,
		type : 'GET',
		crossDomain : true,
		dataType : 'json',
		username : "arnaumail",
		password : "arnau",

	}).done(function(data, status, jqxhr) {
		var response = JSON.parse(jqxhr.responseText);
		var mensajes = response.mensajes;
		
		$("#mensajes_result").text("");

		$.each(mensajes, function(i, v) {
			var mensaje = v;
			var $grouplist = $('#mensajes_result');
			$('<li>' + mensaje.anuncioid + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.mensajeid + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.subject + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.content + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.creation_timestamp + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.emaildestino + '</li>').appendTo($grouplist);
			$('<li>' + mensaje.emailorigen + '</li>').appendTo($grouplist);			
			$("<HR>").appendTo($grouplist);
		});
		
		
		
		
	}).fail(function() {
		$("#mensajes_result").text("No hay mensajes");
	});

}



;(function($, window, document, undefined) {
    "use strict";

    $.fn.chained = function(parent_selector, options) {

        return this.each(function() {

            /* Save this to child because this changes when scope changes. */
            var child   = this;
            var backup = $(child).clone();

            /* Handles maximum two parents now. */
            $(parent_selector).each(function() {
                $(this).bind("change", function() {
                    updateChildren();
                });

                /* Force IE to see something selected on first page load, */
                /* unless something is already selected */
                if (!$("option:selected", this).length) {
                    $("option", this).first().attr("selected", "selected");
                }

                /* Force updating the children. */
                updateChildren();
            });

            function updateChildren() {
                var trigger_change = true;
                var currently_selected_value = $("option:selected", child).val();

                $(child).html(backup.html());

                /* If multiple parents build classname like foo\bar. */
                var selected = "";
                $(parent_selector).each(function() {
                    var selectedClass = $("option:selected", this).val();
                    if (selectedClass) {
                        if (selected.length > 0) {
                            if (window.Zepto) {
                                /* Zepto class regexp dies with classes like foo\bar. */
                                selected += "\\\\";
                            } else {
                                selected += "\\";
                            }
                        }
                        selected += selectedClass;
                    }
                });

                /* Also check for first parent without subclassing. */
                /* TODO: This should be dynamic and check for each parent */
                /*       without subclassing. */
                var first;
                if ($.isArray(parent_selector)) {
                    first = $(parent_selector[0]).first();
                } else {
                    first = $(parent_selector).first();
                }
                var selected_first = $("option:selected", first).val();

                $("option", child).each(function() {
                    /* Remove unneeded items but save the default value. */
                    if ($(this).hasClass(selected) && $(this).val() === currently_selected_value) {
                        $(this).prop("selected", true);
                        trigger_change = false;
                    } else if (!$(this).hasClass(selected) && !$(this).hasClass(selected_first) && $(this).val() !== "") {
                        $(this).remove();
                    }
                });

                /* If we have only the default value disable select. */
                if (1 === $("option", child).size() && $(child).val() === "") {
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


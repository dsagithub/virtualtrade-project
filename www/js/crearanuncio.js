var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var idanuncio;

$(document).ready(function() {
	$("#atributo_2").chained("#atributo_1");
	$("#atributo_3").chained("#atributo_2");
	$("#atributo_4").chained("#atributo_2");
});

$("#button_post_anuncio").click(function(e) {
	e.preventDefault();
	create();
});


function createfoto1() {

	var url = API_BASE_URL + '/anuncios/' + idanuncio + '/imagenes';
	var usrmail = ($.cookie('email'));
	var usrpass = ($.cookie('userpass'));

	var object = new Object();

	object.urlimagen = $('#fileupload1').val();
//	$(function () {
//	    $('#fileupload1').fileupload({
//	        dataType: 'json',
//	        done: function (e, data) {
//	            $.each(data.result.files, function (index, file) {
//	                $('<p/>').text(file.name).appendTo(document.body);
//	            });
//	        }
//	    });
//	});
	object.urlimagen = $('#fileupload1').val();
	var data = JSON.stringify(object);

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
				data : data,
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(usrmail + ':' + usrpass));
				}
			}).done(function(data, status, jqxhr) {

				
				if ($('#fileupload2').val() !=null){
				createfoto2();
				}
				else if ($('#fileupload2').val() ==null){
					console.log($('#fileupload2').val());
				//	window.location = "http://localhost/virtualtrade/index.html";
				}
				
		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
}


function createfoto2() {

	var url = API_BASE_URL + '/anuncios/' + idanuncio + '/imagenes';
	var usrmail = ($.cookie('email'));
	var usrpass = ($.cookie('userpass'));
	var object = new Object();
//if ($('#fileupload2').val() !=null){
	object.urlimagen = $('#fileupload2').val();
	var data = JSON.stringify(object);
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
				data : data,
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(usrmail + ':' + usrpass));
				}
			}).done(function(data, status, jqxhr) {
				if ($('#fileupload3').Length ==0){
					console.log("lksjaflkdjfa");
//					window.location = "http://localhost/virtualtrade/index.html";
				}
				
//				if ($('#fileupload3').val() !=null){
//				createfoto3();
//				}
//				else if ($('#fileupload3').HasFile ==true){
//					console.log("lksjaflkdjfa");
////					window.location = "http://localhost/virtualtrade/index.html";
//				}
		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
//	}
}



function createfoto3() {

	var url = API_BASE_URL + '/anuncios/' + idanuncio + '/imagenes';
	var usrmail = ($.cookie('email'));
	var usrpass = ($.cookie('userpass'));
	var object = new Object();
//	if ($('#fileupload3').val() !=null){
	object.urlimagen = $('#fileupload3').val();
	var data = JSON.stringify(object);
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
				data : data,
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(usrmail + ':' + usrpass));
				}
			}).done(function(data, status, jqxhr) {
			
//					window.location = "http://localhost/virtualtrade/index.html";
//				

		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
//	}
}



function create() {

	var usrmail = ($.cookie('email'));
	var usrpass = ($.cookie('userpass'));

	var url = API_BASE_URL + '/anuncios';
	var object = new Object();
	var imagen = new Object();
	object.subject = $("#subject").val();
	object.content = $("#content").val();
	object.precio = $("#precio").val();
	object.atributo1 = $('#atributo_1 :selected').val();
	object.atributo2 = $('#atributo_2 :selected').val();
	object.atributo3 = $('#atributo_3 :selected').val();
	object.marca = $('#atributo_4 :selected').val();
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
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "
							+ btoa(usrmail + ':' + usrpass));
				}
			}).done(function(data, status, jqxhr) {

		var anuncio = JSON.parse(jqxhr.responseText);
		
		
		
		idanuncio=anuncio.anuncioid;
//		console.log(idanuncio);
		createfoto1();

		$("#create_result").text("Anuncio creado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
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
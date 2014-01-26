var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var user = $.cookie('email');
var password = $.cookie('userpass');

$(document).ready(function() {
	getUser();
	console.log("has pulsado el boton");

});

function getUser() {
	var url = API_BASE_URL + "/users/" + user;
	// $("#name").text("");
	// $("#phone").text("");
	// $("#ciudad").text("");
	// $("#calle").text("");
	// $("#numero").text("");
	// $("#piso").text("");
	// $("#puerta").text("");

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

		$("#name").text(user.name);
		$("#phone").text(user.phone);
		$("#ciudad").text(user.ciudad);
		$("#calle").text(user.calle);
		$("#numero").text(user.numero);
		$("#piso").text(user.piso);
		$("#puerta").text(user.puerta);
		console.log(user.name);
		console.log(user.phone);
		console.log(user.ciudad);
		console.log(user.calle);
		console.log(user.numero);
		console.log(user.piso);
		console.log(user.puerta);


	}).fail(function() {
		console.log("error");
	});

}
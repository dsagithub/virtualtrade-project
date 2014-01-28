var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$(document).ready(function() {
	if ($.cookie('loggedin')=='nologueado'){
	  	  $("#logout").hide();
	      $("#perfil").hide();
	      $("#anadirnuevo").hide();
	      $("#buscar").hide();
	      $("#mensajes").hide();
	}

	if ($.cookie('loggedin')=='logueado'){
	    $("#singup").hide();
	    $("#signin").hide();
	}
	
	getUser($.cookie('email'));
	var password = $.cookie('userpass');

	
	
	
});

$("#button_edit_user").click(function(e) {
	e.preventDefault();
	document.location.href = '/virtualtrade/modificarperfil.html';
});



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
        window.location = "http://localhost/virtualtrade/index.html";
}


function getUser(email) {
	// console.log("JSDFJGSDJGSDKGSDK");
	var url = API_BASE_URL + "/users/" + email;
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
							+ btoa('adminmail' + ':' + 'admin'));
				},
			}).done(
			function(data, status, jqxhr) {
				var user = JSON.parse(jqxhr.responseText);
				$(document).ready(
						function() {
							$("#user_result").text("");
							foto.src = user.foto;
							// $("#nom").text(user.name);

							// foto.height=150;
							// foto.width=150;
							//											
							// $("#email").text(user.email);
							// $("#telef").text(user.phone);
							// $("#ciudad").text(user.ciudad);
							// $("#calle").text(user.calle);
							// $("#numero").text(user.numero);
							// $("#piso").text(user.piso);
							// $("#puerta").text(user.puerta);
							//											
							//										

							var $grouplist = $('#user_result');
							$('<li>' + "User Email: " + user.email + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Nombre: " + user.name + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Phone: " + user.phone + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Ciudad: " + user.ciudad + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Calle: " + user.calle + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Numero: " + user.numero + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Piso: " + user.piso + '</li>')
									.appendTo($grouplist);
							$('<li>' + "Puerta: " + user.puerta + '</li>')
									.appendTo($grouplist);
						});

			}).fail(function() {
		$("#user_result").text("User no encontrado");
	});
}

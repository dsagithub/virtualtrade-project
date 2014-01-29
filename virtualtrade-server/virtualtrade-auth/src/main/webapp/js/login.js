$("#login").click(function(e) {
	e.preventDefault();
	var email = $('#email').val();
	var userpass = $('#userpass').val();
	getLogin(email, userpass);
});

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
        window.location = "http://147.83.7.155:8080/virtualtrade/index.html";
}


function getLogin(email, userpass) {
	var url = "http://147.83.7.155:8080/virtualtrade-api/" + "users/" + email;
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
							+ btoa(email + ':' + userpass));
				}
			}).done(function(data, status, jqxhr) {
			var user = JSON.parse(jqxhr.responseText);
			console.log(user.banned);
			if(user.banned==false){
//				$.notify("Logueado!");
				$.cookie('email', email);
				$.cookie('userpass', userpass);
				
				$.cookie('loggedin', "logueado");
				
				window.location = "http://147.83.7.155:8080/virtualtrade/index.html";
			//	console.log(data);
			}
			else{
				window.location = "http://147.83.7.155:8080/virtualtrade/banned.html";
			}
				
		
	}).fail(function(jqXHR, textStatus) {
		$.notify("Incorrecto!");
		console.log(textStatus);
	});
}

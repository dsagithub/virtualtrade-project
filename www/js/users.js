var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

var admin = $.cookie('email');
var userpass = $.cookie('userpass');

$(document).ready(function() {
	
	
	$(button_banned).hide();
	$(button_des_banned).hide();
	  $(button_send_msg).hide();
	  $(subject).hide();
	  $(mensaje).hide();
	  $(subjec).hide();
	  $(cont).hide();
	  $(userStats).hide();
	  $(foto).hide();
	  
	  
	  
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
		
	  
	  
	  
	//  subject
//	getUser($("#email").val());
});



//obté les dades d'un usuari a partir del username
$("#button_get_user").click(function(e) {
	e.preventDefault();
	getUser($("#email").val());
});

$("#button_banned").click(function(e) {
	e.preventDefault();
	BannerUser($("#email").val());
});

$("#button_des_banned").click(function(e) {
	e.preventDefault();
	UnbannerUser($("#email").val());
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


function BannerUser(user_banned){
	
	var url = API_BASE_URL + '/users/ban/' + user_banned;
	var object = new Object();
	object.banned = "true";
	


	var data = JSON.stringify(object);
	$.ajax({
		url : url,
		type : 'PUT',
		dataType : "json",
		crossDomain : true,
		headers : {
			"Accept" : "application/vnd.virtual.api.user+json",
			"Content-Type" : "application/vnd.virtual.api.user+json"
		},
		data : data,
		beforeSend : function(request) {
			request.withCredentials = true;
			request.setRequestHeader("Authorization", "Basic "
					+ btoa($.cookie('email') + ':' + $.cookie('userpass')));
		},
	}).done(function(data, status, jqxhr) {
		console.log("baneo");
		getUser($("#email").val());

		
	}).fail(function(jqXHR, textStatus) {
		$("#update_result").text("Usuario no baneado");
	});
	
}

function UnbannerUser(user_des_banned){
	
	var url = API_BASE_URL + '/users/ban/' + user_des_banned;
	console.log(user_des_banned);
	var object = new Object();
	object.banned = "false";
	


	var data = JSON.stringify(object);
	$.ajax({
		url : url,
		type : 'PUT',
		dataType : "json",
		crossDomain : true,
		headers : {
			"Accept" : "application/vnd.virtual.api.user+json",
			"Content-Type" : "application/vnd.virtual.api.user+json"
		},
		data : data,
		beforeSend : function(request) {
			request.withCredentials = true;
			request.setRequestHeader("Authorization", "Basic "
					+ btoa($.cookie('email') + ':' + $.cookie('userpass')));
		},
	}).done(function(data, status, jqxhr) {
		console.log("des baneo");
		getUser($("#email").val());

		
	}).fail(function(jqXHR, textStatus) {
		$("#update_result").text("Usuario no des baneado");
	});
	
}

//$("#button_message").click(function(e) {
//	e.preventDefault();
//	sendMensaje();
//	//getUser($("#email").val());
//});

//
//function sendMensaje() {
//	
//	$(subjec).show();
//	  $(cont).show();
//	 $(button_send_msg).show();
//	  $(subject).show();
//	  $(mensaje).show();
//}






function getUser(email) {
	var url = API_BASE_URL + "/users/" + email;
	$.ajax({
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
		}
	}).done(function(data, status, jqxhr) {
		var mostrar_estado;
				var user = JSON.parse(jqxhr.responseText);
				$(document).ready(function() {
					$("#user_result").text("");
					foto.src=user.foto;
//					$("#nom").text(user.name);
					
//					foto.height=150;
//					foto.width=150;
//					
//					$("#email").text(user.email);
//					$("#telef").text(user.phone);
//					$("#ciudad").text(user.ciudad);
//					$("#calle").text(user.calle);
//					$("#numero").text(user.numero);
//					$("#piso").text(user.piso);
//					$("#puerta").text(user.puerta);
//					
//					
					if(admin=="adminmail"){
						console.log(admin);
						 $(button_banned).show();
						 $(button_des_banned).show();
						
					}
					
					 $(userStats).show();
				
					 $(foto).show();	
						
					
					var $grouplist = $('#user_result');
					$(
							'<li>' + "User Email: "
									+ user.email
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Nombre: "
									+ user.name
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Phone: "
									+ user.phone
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Ciudad: "
									+ user.ciudad
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Calle: "
									+ user.calle
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Numero: "
									+ user.numero
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Piso: "
									+ user.piso
									+ '</li>')
							.appendTo($grouplist);
					$(
							'<li>' + "Puerta: "
									+ user.puerta
									+ '</li>')
							.appendTo($grouplist);
					if(user.banned==false){
						mostrar_estado="No baneado"
					}
					if(user.banned==true){
						mostrar_estado="Baneado"
					}
					
					$(
							'<li>' + "Estado: "
									+ mostrar_estado
									+ '</li>')
							.appendTo($grouplist);

				

				});		
			
//					
//					$("#user_result").text("");
//									var $grouplist = $('#user_result');
//									$(
//											'<li>' + "User Email: "
//													+ user.email + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Nombre: "
//													+ user.name + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Phone: "
//													+ user.phone + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Ciudad: "
//													+ user.ciudad + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Calle: "
//													+ user.calle + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Número: "
//													+ user.numero + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Piso: "
//													+ user.piso + '</li>')
//											.appendTo($grouplist);
//									$(
//											'<li>' + "Puerta: "
//													+ user.puerta + '</li>')
//											.appendTo($grouplist);
//									
//								
//									
//									$('<li><img src="' + user.foto + '"border="1" width="160" height="90"></li>').appendTo($grouplist)
//									
//								
//								});
			}).fail(function() {
		$("#user_result").text("User no encontrado");
	});
}
















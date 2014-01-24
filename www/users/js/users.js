var API_BASE_URL = "http://localhost:8080/virtualtrade-api";


$(document).ready(function() {
	  $(button_message).hide();
	  $(button_send_msg).hide();
	  $(subject).hide();
	  $(mensaje).hide();
	  $(subjec).hide();
	  $(cont).hide();
	  $(userStats).hide();
	  $(foto).hide();
			
	  
	  
	//  subject
//	getUser($("#email").val());
});



//obté les dades d'un usuari a partir del username
$("#button_get_user").click(function(e) {
	e.preventDefault();
	getUser($("#email").val());
});



$("#button_message").click(function(e) {
	e.preventDefault();
	sendMensaje();
	//getUser($("#email").val());
});


function sendMensaje() {
	
	$(subjec).show();
	  $(cont).show();
	 $(button_send_msg).show();
	  $(subject).show();
	  $(mensaje).show();
}






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
					 $(button_message).show();
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
















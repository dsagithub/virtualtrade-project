var API_BASE_URL = "http://localhost:8080/virtualtrade-api";

$(document).ready(function() {

	getUser($.cookie('email').val());

	// getUser($("#email").val());
});

function getUser(email) {
	var url = API_BASE_URL + "/users/" + email;
	$
			.ajax({
				url : url,
				type : 'GET',
				crossDomain : true,
				dataType : 'json',
				username : "adminmail",
				password : "admin",
			})
			.done(
					function(data, status, jqxhr) {
						var user = JSON.parse(jqxhr.responseText);
						$(document)
								.ready(
										function() {
											$("#user_result").text("");
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
													'<li>' + "Número: "
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

											$(
													'<li><img src="'
															+ user.foto
															+ '"border="1" width="160" height="90"></li>')
													.appendTo($grouplist)

										});
					}).fail(function() {
				$("#user_result").text("User no encontrado");
			});
}

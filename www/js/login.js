$("#login").click(function(e) {
	e.preventDefault();
	var email = $('#email').val();
	var userpass = $('#userpass').val();
	getLogin(email, userpass);
});

function getLogin(email, userpass) {
	var url = "http://localhost:8080/virtualtrade-api/" + "users/" + email;
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

				
				window.location = "http://localhost/virtualtrade/index.html";
			//	console.log(data);
			}
			else{
				window.location = "http://localhost/virtualtrade/banned.html";
			}
				
		
	}).fail(function(jqXHR, textStatus) {
		$.notify("Incorrecto!");
		console.log(textStatus);
	});
}

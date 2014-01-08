var API_BASE_URL = "http://localhost:8080/virtualtrade-api";


$("#button_create").click(function(e) {
	e.preventDefault();
	create();
});
function create() {
	var url = API_BASE_URL + '/user/repos/';
	var objecte = new Object();
	objecte.name = $("#name1").val();
	objecte.description = $("#description1").val();
	
	//objecte.homepage = "https://github.com";
	objecte.private = false;
	objecte.has_issues=true;
	objecte.has_wiki=true;
	objecte.has_downloads=true;
	var data = JSON.stringify(objecte);
	$.ajax(
			{
				url : url,
				type : 'POST',
				dataType : "json",
				crossDomain : true,
				data : data,
				
				beforeSend : function(request) {
					request.withCredentials = true;
					request.setRequestHeader("Authorization", "Basic "+ btoa('username:password'));
				},
			}).done(function(data, status, jqxhr) {
		$("#create_result").text("Agregado correctamente");
	}).fail(function(jqXHR, textStatus) {
		$("#create_result").text("No agregado");
	});
}
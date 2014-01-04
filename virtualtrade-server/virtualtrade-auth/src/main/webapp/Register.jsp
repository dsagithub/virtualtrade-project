<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<title>Registrarse</title>

<script src="https://code.jquery.com/jquery.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
</html>

<link rel="stylesheet" type="text/css" href="css/login.css">

<!-- Latest compiled and minified CSS -->
   <!-- Google fonts -->
    <!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,600' rel='stylesheet' type='text/css'> -->
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
    <!-- Bootstrap styles -->
    <link rel="stylesheet" href="css/boostrap.css">
    <link rel="stylesheet" href="css/boostrap_responsive.css">
    <!-- Font Awesome styles (icons) -->
    <link rel="stylesheet" href="css/font_awesome.css">
    <!-- Main Template styles -->
    <link rel="stylesheet" href="css/styles.css">

    <!-- IE 8 Fallback -->
    <!--[if lt IE 9]>
	<link rel="stylesheet" type="text/css" href="css/ie.css" />
<![endif]-->

    <!-- Your custom styles (blank file) -->
    <link rel="stylesheet" href="css/mystyles.css">
</head>



	
	<div class="container">
		<div class="account-wall">


			<form class="form-signin" action="/virtualtrade-auth/RegisterServlet"
				method="post">
				<h2 class="register-heading">Registrarse</h2>
				<input type="text" class="form-control" name="name"
					placeholder="Nombre" required autofocus> <input type="text"
					class="form-control" name="email" placeholder="Email" required
					> <input type="password" class="form-control"
					name="userpass" placeholder="Password" required> <input
					type="text" class="form-control" name="phone"
					placeholder="Número de Teléfono" required > <input
					type="text" class="form-control" name="ciudad" placeholder="Ciudad"
					required > <input type="text" class="form-control"
					name="calle" placeholder="Calle" required > <input
					type="text" class="form-control" name="numero" placeholder="Número"
					required > <input type="text" class="form-control"
					name="piso" placeholder="Piso" required > <input
					type="text" class="form-control" name="puerta" placeholder="Puerta"
					required >
		<!-- 			<input type="text" class="form-control"
						name="foto" placeholder="Foto" required autofocus> 
			 -->		
					 
					
					 <input id="fileupload" type="file" name="foto" data-url="upload" multiple>
					
					 
		 		
					</label>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Registrarse</button>
			</form>
		</div>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

</html>

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

	<!-- //////////////////////////////////
//////////////MAIN HEADER///////////// 
////////////////////////////////////-->
	<header class="main">
		<div class="container">
			<div class="row">
				<div class="span2">
					<a href="http://localhost/virtualtrade/index.html"> <img
						src="img/logo-small.png" alt="logo" title="logo" class="logo">
					</a>
				</div>
				<div class="span8">
					<!-- MAIN NAVIGATION -->
					<div class="flexnav-menu-button" id="flexnav-menu-button">Menu</div>
					<nav>
						<ul class="nav nav-pills flexnav" id="flexnav"
							data-breakpoint="800">
							<li class="active"><a href="index.html">Home</a>
								<ul>
									<li class="active"><a href="index.html">Slider</a>
										<ul>
											<li class="active"><a href="index.html">Full Width</a></li>
											<li><a href="index-slider-container.html">Container</a>
											</li>
										</ul></li>
									<li><a href="index-hero-image.html">Hero Image</a></li>
									<li><a href="index-no-top.html">No Top Area</a></li>
									<li><a href="index-category-right.html">Category Nav</a>
										<ul>
											<li><a href="index-category-right.html">Side Right</a></li>
											<li><a href="index-category-nav-inline-top.html">Inline
													Top</a></li>
											<li><a href="index-category-nav-main.html">Main Nav</a>
											</li>
										</ul></li>
									<li><a href="index-featured-item.html">Featured Item</a></li>
									<li><a href="index-coupon-4-columns.html">Coupons</a>
										<ul>
											<li><a href="index-coupon-4-columns.html">4 Columns</a>
											</li>
											<li><a href="index-coupon-6-columns.html">6 columns</a>
											</li>
											<li><a href="index-coupon-category-icon.html">Category
													icons</a></li>
											<li><a href="index-coupon-labels.html">Labels</a></li>
											<li><a href="index-coupon-holded.html">Holded</a></li>
											<li><a href="index-coupon-load-more.html">Load More
													Btn</a></li>
										</ul></li>
								</ul></li>

							<li><a href="http://localhost/virtualtrade/perfil.html">Perfil</a></li>
							<li><a
								href="http://localhost/virtualtrade/nuevoanuncio.html">Añadir
									nuevo anuncio</a></li>

							<li><a href="http://localhost/virtualtrade/users/users.html">Buscar
									Usuario</a></li>
							<li><a href="http://localhost/virtualtrade/contact.html">Contactar</a>
							</li>
						</ul>
					</nav>
					<!-- END MAIN NAVIGATION -->
				</div>
				<div class="span2">
					<!-- LOGIN REGISTER LINKS -->
					<ul class="login-register">
						<li><a id="singup" class="popup-text"
							href="http://localhost/virtualtrade/login.html"
							data-effect="mfp-move-from-top"><i class="icon-signin"></i>Sign
								in</a></li>
						<li><a id="nombreusuarioaqui" class="popup-text"
							data-effect="mfp-move-from-top"><i class="icon-signin"></i>Perfil</a></li>

						<li><a id="signin" class="popup-text"
							href="http://localhost:8080/virtualtrade-auth/Register.jsp"
							data-effect="mfp-move-from-top"><i class="icon-edit"></i>Sign
								up</a></li>


						<li><a id="logout" class="popup-text"
							href="http://localhost:8080/virtualtrade-auth/Register.jsp"
							data-effect="mfp-move-from-top"><i class="icon-edit"></i>Log Out
								</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<!-- LOGIN REGISTER LINKS CONTENT -->
	<div id="login-dialog"
		class="mfp-with-anim mfp-hide mfp-dialog clearfix">
		<i class="icon-signin dialog-icon"></i>
		<h3>Member Login</h3>
		<h5>Welcome back, friend. Login to get started</h5>
		<div class="row-fluid">
			<form class="dialog-form">
				<label>E-mail</label> <input type="text"
					placeholder="email@domain.com" class="span12"> <label>Password</label>
				<input type="password" placeholder="My secret password"
					class="span12"> <label class="checkbox"> <input
					type="checkbox">Remember me
				</label> <input type="submit" value="Sign in" class="btn btn-primary">
			</form>
		</div>
		<ul class="dialog-alt-links">
			<li><a class="popup-text" href="#register-dialog"
				data-effect="mfp-zoom-out">Not member yet</a></li>
			<li><a class="popup-text" href="#password-recover-dialog"
				data-effect="mfp-zoom-out">Forgot password</a></li>
		</ul>
	</div>


	<div id="register-dialog"
		class="mfp-with-anim mfp-hide mfp-dialog clearfix">
		<i class="icon-edit dialog-icon"></i>
		<h3>Member Register</h3>
		<h5>Ready to get best offers? Let's get started!</h5>
		<div class="row-fluid">
			<form class="dialog-form">
				<label>E-mail</label> <input type="text"
					placeholder="email@domain.com" class="span12"> <label>Password</label>
				<input type="password" placeholder="My secret password"
					class="span12"> <label>Repeat Password</label> <input
					type="password" placeholder="Type your password again"
					class="span12">
				<div class="row-fluid">
					<div class="span8">
						<label>Your Area</label> <input type="password"
							placeholder="Boston" class="span12">
					</div>
					<div class="span4">
						<label>Postal/Zip</label> <input type="password"
							placeholder="12345" class="span12">
					</div>
				</div>
				<label class="checkbox"> <input type="checkbox">Get
					hot offers via e-mail
				</label> <input type="submit" value="Sign up" class="btn btn-primary">
			</form>
		</div>
		<ul class="dialog-alt-links">
			<li><a class="popup-text" href="#login-dialog"
				data-effect="mfp-zoom-out">Already member</a></li>
		</ul>
	</div>


	<div id="password-recover-dialog"
		class="mfp-with-anim mfp-hide mfp-dialog clearfix">
		<i class="icon-retweet dialog-icon"></i>
		<h3>Password Recovery</h3>
		<h5>Fortgot your password? Don't worry we can deal with it</h5>
		<div class="row-fluid">
			<form class="dialog-form">
				<label>E-mail</label> <input type="text"
					placeholder="email@domain.com" class="span12"> <input
					type="submit" value="Request new password" class="btn btn-primary">
			</form>
		</div>
	</div>
	<!-- END LOGIN REGISTER LINKS CONTENT -->

        
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
                <!--                         <input type="text" class="form-control"
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
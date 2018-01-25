
<!-- container section start -->
<section id="container" class="">


	<header class="header dark-bg">
		<div class="toggle-nav">
			<div class="icon-reorder tooltips"
				data-original-title="Toggle Navigation" data-placement="bottom">
				<i class="icon_menu"></i>
			</div>
		</div>

		<!--logo start-->
		<a href="/Projeto/index.jsp" class="logo">Restaurant<span
			class="lite">Admin</span></a>
		<!--logo end-->

		<div class="nav search-row" id="top_menu">
			<!--  search form start -->
			<ul class="nav top-menu">
				<li>
					<form class="navbar-form">
						<input class="form-control" placeholder="Procurar" type="text">
					</form>
				</li>
			</ul>
			<!--  search form end -->
		</div>

		<div class="top-nav notification-row">
			<!-- notificatoin dropdown start-->
			<ul class="nav pull-right top-menu">

				<!-- user login dropdown start-->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <span class="profile-ava">
							<img alt="" id="target" src="" width="40" height="40">
							<%String usuario = (String) session.getAttribute("user"); %>
					</span> <span class="username"><%= usuario %></span> <b class="caret"></b>
					
				</a>
					<ul class="dropdown-menu extended logout">
						<div class="log-arrow-up"></div>
						<li class="eborder-top"><a href="/Projeto/profile.jsp"><i
								class="icon_profile"></i>Perfil</a></li>
						<li><a href="#"><i class="icon_mail_alt"></i>Email</a></li>
						<li><a href="#"><i class="icon_clock_alt"></i>Cronograma</a>
						</li>
						<li><a href="#"><i class="icon_chat_alt"></i>Gráficos</a></li>
						<li><a href="login?q=logout"><i class="icon_key_alt"></i>Log
								Out</a></li>
					</ul></li>
				<!-- user login dropdown end -->
			</ul>
			<!-- notificatoin dropdown end-->
		</div>
	</header>
	<!--header end-->

	<!--sidebar start-->
	<aside>
		<div id="sidebar" class="nav-collapse ">
			<!-- sidebar menu start-->
			<ul class="sidebar-menu">
				<li class="active"><a class="" href="/Projeto/index.jsp"> <i
						class="icon_house_alt"></i> <span>Home</span>
				</a></li>

				<li class="sub-menu"><a href="javascript:;" class=""> <i
						class="icon_document_alt"></i> <span>Franquias</span> <span
						class="menu-arrow arrow_carrot-right"></span>
				</a>
					<ul class="sub">
						<li><a class="" href="/Projeto/franquias?q=new">Cadastrar</a></li>
						<li><a class="" href="/Projeto/franquias">Franquias</a></li>
					</ul></li>


				<li class="sub-menu"><a href="javascript:;" class=""> <i
						class="icon_document_alt"></i> <span>Franqueados</span> <span
						class="menu-arrow arrow_carrot-right"></span>
				</a>
					<ul class="sub">
						<li><a class="fa fa-user-plus"
							href="/Projeto/franqueado?q=new">Novo</a></li>
						<li><a class="" href="/Projeto/franqueado">Listar</a></li>
					</ul></li>

				<li class="sub-menu"><a href="javascript:;" class=""> <i
						class="icon_document_alt"></i> <span>Clientes</span> <span
						class="menu-arrow arrow_carrot-right"></span>
				</a>
					<ul class="sub">
						<li><a href="/Projeto/clientes?q=new">Inserir</a></li>
						<li><a href="/Projeto/clientes">Listar</a></li>
					</ul></li>

				<li class="sub-menu"><a href="javascript:;" class=""> <i
						class="icon_document_alt"></i> <span>Mesas</span> <span
						class="menu-arrow arrow_carrot-right"></span>
				</a>
					<ul class="sub">
						<li><a href="/Projeto/mesas?q=new">Inserir</a></li>
						<li><a href="/Projeto/mesas">Listar</a></li>
						<li class="sub-menu"><a href="javascript:;" class=""> <i
								class="icon_document_alt"></i> <span>Tipos</span> <span
								class="menu-arrow arrow_carrot-right"></span>
						</a>
							<ul class="sub">
								<li><a href="/Projeto/tipos?q=new">Inserir</a></li>
								<li><a href="/Projeto/tipos">Listar</a></li>
							</ul></li>
					</ul></li>





				<li class="sub-menu"><a href="javascript:;" class=""> <i
						class="icon_document_alt"></i> <span>Reservas</span> <span
						class="menu-arrow arrow_carrot-right"></span>
				</a>
					<ul class="sub">
						<li><a href="/Projeto/reservas?q=new">Inserir</a></li>
						<li><a href="/Projeto/reservas">Listar</a></li>
					</ul></li>
				<li><a class="" href="/Projeto/chart-chartjs.jsp"> <i
						class="icon_piechart"></i> <span>Gráficos</span>
				</a></li>

			</ul>
			<!-- sidebar menu end-->
		</div>
	</aside>
	<!--sidebar end-->
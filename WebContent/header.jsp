<div class="header">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<p id="title-p">Cobrança & Contabilidade</p>
			</div>
			<div class="col-md-8">
				<ul class="nav nav-pills pull-right" id="title-ul">
					<li role="presentation">
						<a href="homepage.jsp" id="title-a">Homepage</a>
					</li>
					<li role="presentation">
						<a href="adicionaCaloteiro.jsp" id="adicionaLink">Cadastro</a>
					</li>
					<li role="presentation">
						<a href="sistema?logica=ListaCaloteiro">Listagem</a>
					</li>
					<li>
						<a id="dropdown-link" href="#">${usuarioLogado.nome} <span
							class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="sistema?logica=LogoutUsuario">Logout</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>

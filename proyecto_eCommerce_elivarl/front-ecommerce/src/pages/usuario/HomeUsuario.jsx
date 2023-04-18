const Home = () => {
    return ( 
        <div class="container">


		<header class="jumbotron my-4">
			<h1 class="display-3">Bienvenido a Spring Ecommerce 2021</h1>
			<p class="lead">Tu tienda de productos en Línea</p>
		</header>

		<div class="row text-center">

			<div class="col-lg-3 col-md-6 mb-4" th:each="producto: ${productos}">
				<div class="card h-100">
					<img class="card-img-top"
						th:src="@{/images/{img} (img=${producto.imagen})} " alt="" />
					<div class="card-body">
						<p class="card-text" th:text="${producto.nombre}"></p>
					</div>
					<div class="card-footer">
						<a th:href="@{/productohome/{id}  (id=${producto.id})  }" class="btn btn-success">Ver
							producto</a>
					</div>
				</div>
			</div>

		</div>
		
	</div>
     );
}
 
export default Home;
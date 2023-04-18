const DetalleCompra = () => {
  return (
    <div class="container">
      <h1 class="mt-4 mb-3">
        Spring eCommerce <small>Detalles</small>
      </h1>

      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a th:href="@{/}">Home</a>
        </li>
        <li class="breadcrumb-item">
          <a th:href="@{/usuario/compras}">Compras</a>
        </li>
        <li class="breadcrumb-item active">Detalle de Compra</li>
      </ol>

      <div class="card mb-4">
        <div class="card-body">
          <div class="row">
            <div class="col-lg-12">
              <table class="table">
                <thead>
                  <tr>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Producto</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Total</th>
                  </tr>
                </thead>
                <tbody>
                  <tr th:each="detalle:${detalles}">
                    <td th:text="${detalle.cantidad}"></td>
                    <td th:text="${detalle.nombre}"></td>
                    <td th:text="${detalle.precio}"></td>
                    <td th:text="${detalle.total}"></td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DetalleCompra;

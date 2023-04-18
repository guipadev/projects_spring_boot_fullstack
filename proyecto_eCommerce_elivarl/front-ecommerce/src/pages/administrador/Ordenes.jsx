const Ordenes = () => {
  return (
      <div class="container">
        <h1 class="mt-4 mb-3">
          Spring eCommerce <small>Ordenes</small>
        </h1>

        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a th:href="@{/}">Home</a>
          </li>
          <li class="breadcrumb-item active">Ordenes</li>
        </ol>

        <div class="card mb-4">
          <div class="card-body">
            <div class="row">
              <div class="col-lg-12">
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">No. de Orden</th>
                      <th scope="col">Fecha</th>
                      <th scope="col">Valor</th>
                      <th scope="col">Acción</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr th:each="orden:${ordenes}">
                      <td th:text="${orden.numero}"></td>
                      <td th:text="${orden.fechaCreacion}"></td>
                      <td th:text="${orden.total}"></td>
                      <td>
                        <a
                          th:href="@{/administrador/detalle/{id} (id=${orden.id}) }"
                          class="btn btn-success"
                        >
                          Ver Detalle
                        </a>
                      </td>
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

export default Ordenes;

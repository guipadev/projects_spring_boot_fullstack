const Usuarios = () => {
  return (
      <div class="container">
        <h1 class="mt-4 mb-3">
          Spring eCommerce <small>Usuarios</small>
        </h1>

        <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a th:href="@{/}">Home</a>
          </li>
          <li class="breadcrumb-item active">Ver Usuarios</li>
        </ol>
        <h2>Usuarios</h2>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Nombre</th>
              <th scope="col">Email</th>
              <th scope="col">Dirección</th>
            </tr>
          </thead>
          <tbody>
            <tr th:each="usuario:${usuarios}">
              <td th:text="${usuario.nombre}"></td>
              <td th:text="${usuario.email}"></td>
              <td th:text="${usuario.direccion}"></td>
            </tr>
          </tbody>
        </table>
      </div>
  );
};

export default Usuarios;

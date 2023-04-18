import Navigation from "../../component/Navigation";
const Registro = () => {
  return (
    <>
      <Navigation />

      <div class="container">
        <div class="card mb-3">
          <div class="row no-gutters">
            <div class="col-md-4"></div>
            <div class="col-md-8">
              <div class="card-body">
                <h2>Registro</h2>
              </div>
            </div>
          </div>
        </div>
        <form th:action="@{/usuario/save}" method="post">
          <div class="form-group">
            <label for="nombres">Nombres:</label>{" "}
            <input
              type="text"
              class="form-control"
              id="nombre"
              name="nombre"
              required
              placeholder="Ingrese sus nombres"
              autocomplete="off"
            />
          </div>

          <div class="form-group">
            <label for="email">Email:</label>{" "}
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              required
              placeholder="Ingrese su email"
              autocomplete="off"
            />
          </div>

          <div class="form-group">
            <label for="direccion">Dirección:</label>{" "}
            <input
              type="text"
              class="form-control"
              id="direccion"
              name="direccion"
              required
              placeholder="Ingrese su dirección"
              autocomplete="off"
            />
          </div>

          <div class="form-group">
            <label for="pwd">Contraseña</label>{" "}
            <input
              type="password"
              class="form-control"
              id="password"
              name="password"
              required
              placeholder="Ingrese su contraseña"
              autocomplete="off"
            />
          </div>
          <div class="col-sm-2">
            <button type="submit" class="btn btn-success">
              Guardar
            </button>
          </div>
        </form>
      </div>
    </>
  );
};

export default Registro;

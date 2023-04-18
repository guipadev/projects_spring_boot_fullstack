const Header = () => {
  return (
    <>
      <header class="p-3 text-bg-dark">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a
              href={`/`}
              class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
            >
              <svg
                class="bi me-2"
                width="40"
                height="32"
                role="img"
                aria-label="Bootstrap"
              >
                <use xlink:href="#bootstrap"></use>
              </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li>
                <a href="#" class="nav-link px-2 text-secondary">
                  Home
                </a>
              </li>
              <li>
                <a href="#" class="nav-link px-2 text-white">
                  Features
                </a>
              </li>
              <li>
                <a href="#" class="nav-link px-2 text-white">
                  Pricing
                </a>
              </li>
              <li>
                <a href="#" class="nav-link px-2 text-white">
                  FAQs
                </a>
              </li>
              <li>
                <a href="#" class="nav-link px-2 text-white">
                  About
                </a>
              </li>
            </ul>

            <form
              class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3"
              role="search"
              data-dashlane-rid="5e7f7f6d8a0ff5ae"
              data-form-type=""
            >
              <input
                type="search"
                class="form-control form-control-dark text-bg-dark"
                placeholder="Search..."
                aria-label="Search"
                data-dashlane-rid="4fce71a1efcc5fbc"
                data-form-type=""
              />
            </form>

            <div class="text-end">
              <button type="button" class="btn btn-outline-light me-2">
                Login
              </button>
              <button type="button" class="btn btn-warning">
                Sign-up
              </button>
            </div>
          </div>
        </div>
      </header>
    </>
  );
};

export default Header;

/*
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
          <a class="navbar-brand" th:href="@{/administrador}">
            Hulk Store
          </a>

          <form class="form-inline my-2 my-lg-0" method="post" action="#">
            <input
              class="form-control mr-sm-2"
              type="search"
              placeholder="Buscar"
              aria-label="Search"
              name="nombre"
              autocomplete="off"
            />
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
              Buscar
            </button>
          </form>

          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item dropdown">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="navbarDropdownMenuLink"
                  role="button"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  {" "}
                  ADMIN
                  {" "}
                </a>

                <div
                  class="dropdown-menu"
                  aria-labelledby="navbarDropdownMenuLink"
                >
                  <a class="dropdown-item" href={`/productos`}>
                    Productos
                  </a>
                  <a class="dropdown-item" href={`/administrador/usuarios`}>
                    Usuarios
                  </a>
                  <a class="dropdown-item" href={`/administrador/ordenes`}>
                    Ordenes
                  </a>
                  <a class="dropdown-item" href={`/usuario/cerrar`}>
                    Salir
                  </a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
*/

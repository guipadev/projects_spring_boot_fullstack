const Create = () => {
  return (
    <div className="container">
      <h1 className="mt-4 mb-3">
        Spring eCommerce <small>Productos</small>
      </h1>

      <ol className="breadcrumb">
        <li className="breadcrumb-item">
          <a href={`/`}>Home</a>
        </li>
        <li className="breadcrumb-item active">Crear Productos</li>
      </ol>

      <h2>Crear Producto</h2>

      <form
        className="form-horizontal"
        th:action="@{/productos/save}"
        method="post"
        enctype="multipart/form-data"
      >
        <div className="form-group">
          <label className="control-label col-sm-2" for="nombre">
            Nombre:
          </label>
          <div className="col-sm-10">
            <input
              type="text"
              className="form-control"
              id="nombre"
              name="nombre"
              placeholder="Ingrese el nombre del producto"
              autocomplete="off"
              required
            />
          </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-2" for="descripcion">
            Descripción:
          </label>
          <div className="col-sm-10">
            <textarea
              className="form-control"
              id="descripcion"
              name="descripcion"
              placeholder="Ingrese la descripcion del producto"
              required
              autocomplete="off"
            >
              {" "}
            </textarea>
          </div>
        </div>

        <div className="form-group">
          <label className="control-label col-sm-2" for="cantidad">
            Cantidad:
          </label>
          <div className="col-sm-10">
            <input
              type="number"
              className="form-control"
              id="cantidad"
              name="cantidad"
              placeholder="Ingrese la cantidad del producto"
              required
              autocomplete="off"
            />
          </div>
        </div>

        <div className="form-group">
          <label className="control-label col-sm-2" for="precio">
            Precio:
          </label>
          <div className="col-sm-10">
            <input
              type="number"
              className="form-control"
              step="any"
              id="precio"
              name="precio"
              placeholder="Ingrese el precio del producto"
              autocomplete="off"
              required
            />
          </div>
        </div>

        <div className="form-group">
          <label className="control-label col-sm-2" for="img">
            Imagen:
          </label>
          <div className="col-sm-10">
            <input type="file" className="form-control-file" id="img" name="img" />
          </div>
        </div>

        <div className="row">
          <div className="col-sm-2">
            <button type="submit" className="btn btn-success">
              <span className="glyphicon glyphicon-saved"></span> Guardar
            </button>
          </div>
        </div>
      </form>
    </div>
  );
};

export default Create;

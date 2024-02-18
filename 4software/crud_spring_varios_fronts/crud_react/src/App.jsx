import { useState, useEffect } from "react";

import "./App.css";
import { PersonaService } from "./services/PersonaService";

import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Panel } from "primereact/panel";
import { Dialog } from "primereact/dialog";
import { Menubar } from "primereact/menubar";
import { InputText } from "primereact/inputtext";

import "primereact/resources/themes/saga-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primeflex/primeflex.css";

function App() {
  const [personas, setPersonas] = useState([]);

  const [visible, setVisible] = useState(false);

  const items = [
    {
      label: "Nuevo",
      icon: "pi pi-fw pi-plus",
      command: () => {
        showSaveDialog();
      },
    },
    {
      label: "Editar",
      icon: "pi pi-fw pi-pencil",
      command: () => alert(true),
    },
    {
      label: "Eliminar",
      icon: "pi pi-fw pi-times",
      command: () => alert("delete"),
    },
  ];

  const persona = {
    id: null,
    nombre: null,
    apellido: null,
    direccion: null,
    telefono: null,
  };

  useEffect(() => {
    const personaService = new PersonaService();

    personaService
      .getAll()
      .then((data) => {
        setPersonas(data);
      })
      .catch((error) => {
        console.error("Error al obtener datos en el componente App:", error);
      });
  }, []);

  const showSaveDialog = () => {
    setVisible;
  };

  return (
    <div style={{ width: "80%", marginTop: "20px", margin: "0 auto" }}>
      <Menubar model={items} />
      <br />
      <Panel header="Personajes Los simpson">
        <DataTable value={personas} paginator rows={5}>
          <Column field="id" header="Id"></Column>
          <Column field="nombre" header="Nombre"></Column>
          <Column field="apellido" header="Apellido"></Column>
          <Column field="direccion" header="Direccion"></Column>
          <Column field="telefono" header="Telefono"></Column>
        </DataTable>
      </Panel>
      <Dialog
        header="Crear registro persona"
        visible={visible}
        style={{ width: "80%" }}
        modal={true}
        onHide={() => setVisible}
      >
        <span className="p-float-label">
          <InputText
            value={this.state.value}
            id="nombre"
            onChange={(e) =>
              this.setState((prevState) => {
                let persona = Object.assign({}, prevState.persona);
                persona.nombre = e.target.value;
                return { persona };
              })
            }
          />
          <label htmlFor="nombre">Nombre</label>
        </span>
      </Dialog>
    </div>
  );
}

export default App;

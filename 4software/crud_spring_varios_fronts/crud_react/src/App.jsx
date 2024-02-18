import { useState, useEffect, useRef } from "react";

import "./App.css";
import { PersonaService } from "./services/PersonaService";

import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Panel } from "primereact/panel";
import { Dialog } from "primereact/dialog";
import { Menubar } from "primereact/menubar";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import { Messages } from "primereact/messages";

import "primereact/resources/themes/saga-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primeflex/primeflex.css";

function App() {
  const [personas, setPersonas] = useState([]);

  const [visible, setVisible] = useState(false);

  const [persona, setPersona] = useState({
    nombre: "",
    apellido: "",
    direccion: "",
    telefono: "",
  });

  const items = [
    {
      label: "Nuevo",
      icon: "pi pi-fw pi-plus",
      command: () => setVisible(true),
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

  const handleChange = (e, field) => {
    setPersona({ ...persona, [field]: e.target.value });
  };

  const msgs = useRef(null);

  const handleSave = () => {
    const personaService = new PersonaService();
    personaService
      .save(persona)
      .then((savedPersona) => {
        console.log("Persona guardada:", savedPersona);

        setVisible(false); // Ocultar el diálogo después de guardar la persona

        setPersona({
          nombre: "",
          apellido: "",
          direccion: "",
          telefono: "",
        });

        setPersonas((prevPersonas) => [...prevPersonas, savedPersona]); // Actualizar la lista de forma reactiva
        msgs.current.show({
          severity: "success",
          summary: "Correcto",
          detail: "Registro de persona correcto!!",
        });
      })
      .catch((error) => {
        console.error("Error al guardar persona:", error);
      });
  };

  return (
    <div style={{ width: "80%", marginTop: "20px", margin: "0 auto" }}>
      <Menubar model={items} />
      <br />
      <Panel header="Personajes Los simpson">
        <DataTable value={personas} paginator rows={5} responsive>
          <Column field="id" header="Id"></Column>
          <Column field="nombre" header="Nombre"></Column>
          <Column field="apellido" header="Apellido"></Column>
          <Column field="direccion" header="Direccion"></Column>
          <Column field="telefono" header="Telefono"></Column>
        </DataTable>
      </Panel>
      <Messages
        ref={msgs}
        style={{
          position: "absolute",
          top: 0,
          left: 0,
          right: 0,
        }}
      />
      <Dialog
        header="Crear registro persona"
        visible={visible}
        style={{ width: "40%" }}
        modal={true}
        onHide={() => setVisible(false)}
      >
        <div
          className="flex flex-column gap-2"
          style={{ marginBottom: "12px" }}
        >
          <label htmlFor="nombre">Nombres</label>
          <InputText
            id="nombre"
            value={persona.nombre}
            onChange={(e) => handleChange(e, "nombre")}
            aria-describedby="nombre-help"
          />
          <small id="nombre-help">Ingrese nombres completos</small>
        </div>
        <div
          className="flex flex-column gap-2"
          style={{ marginBottom: "12px" }}
        >
          <label htmlFor="nombre">Apellidos</label>
          <InputText
            id="apellido"
            value={persona.apellido}
            onChange={(e) => handleChange(e, "apellido")}
            aria-describedby="apellido-help"
          />
          <small id="apellido-help">Ingrese apellidos completos</small>
        </div>
        <div
          className="flex flex-column gap-2"
          style={{ marginBottom: "12px" }}
        >
          <label htmlFor="nombre">Dirección</label>
          <InputText
            id="direccion"
            value={persona.direccion}
            onChange={(e) => handleChange(e, "direccion")}
            aria-describedby="direccion-help"
          />
          <small id="direccion-help">Ingrese dirección</small>
        </div>
        <div className="flex flex-column gap-2">
          <label htmlFor="nombre">Telefono</label>
          <InputText
            id="telefono"
            value={persona.telefono}
            onChange={(e) => handleChange(e, "telefono")}
            aria-describedby="telefono-help"
          />
          <small id="telefono-help">Ingrese número telefonico o celular</small>
        </div>
        <div className="card flex justify-content-center">
          <Button label="Guardar" onClick={handleSave} severity="success" />
        </div>
      </Dialog>
    </div>
  );
}

export default App;

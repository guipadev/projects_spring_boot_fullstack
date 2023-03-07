import React, { useRef } from "react";

import { AvForm, AvField, AvInput, AvGroup } from 'availity-reactstrap-validation'
import { Button, Label } from "reactstrap";

const FormularioTarea = ({ tarea, onSubmit }) => {

    // referenciar el formulario para limpiar
    let form = useRef();

    // Reset el form despues de enviar
    const _onSubmit = (values) => {
        onSubmit(values);
        form.reset();
    }

    return (
        <>
            <h3 className="mb-3">{ tarea ? 'Editar' : 'Nueva'} Tarea</h3>

            <AvForm ref={c => (form = c)} onValidSubmit={(_, values) => _onSubmit(values)}>
                <AvGroup className="mb-3">
                    <AvField name="nombre" label="Nombre" value={tarea ? tarea.nombre : ''} required />
                </AvGroup>
                <AvGroup className="mb-3">
                    <AvInput type="checkbox" name="completado" checked={tarea ? tarea.completado : false} />
                    <Label check for="completado">Completado</Label>
                </AvGroup>
                <div className="text-end">
                    <Button color="primary">Guardar</Button>
                </div>
            </AvForm>
        </>
    );
}

export default FormularioTarea;
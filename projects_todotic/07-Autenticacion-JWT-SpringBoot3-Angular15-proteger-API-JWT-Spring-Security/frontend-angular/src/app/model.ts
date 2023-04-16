export interface Contacto {
    id: number;
    nombre: string;
    fechaNacimiento?: Date;
    celular?: string;
    email?: string;
}

//Estructura credencials para capturar el datos
export interface credentials {
    email: string;
    password: string;
}
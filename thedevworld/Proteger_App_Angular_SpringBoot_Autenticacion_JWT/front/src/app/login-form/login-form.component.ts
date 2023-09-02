import { EventEmitter, Component, Output } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})

// Tener la solicitud de inicio de sesión en el componente principal
// Permite manejar la rta y cambiar del formulario de inicio de sesión al componente de contenido de autenticación
// una vez autenticado
//    -> auth-component
// content-component
//    -> login-component
export class LoginFormComponent {
  // De esta forma el método de envío estará en el componente del contenido, componente principal
  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();

  // variables que contendran nombres de usuario y contraseña
  active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";

  // Método para cambiar a login activo
  onLoginTab(): void {
    this.active = "login";
  }

  // Método para cambiar a registro activo
  onRegisterTab(): void {
    this.active = "register";
  }

  // Método que emitira la var de salida
  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({"login": this.login, "password": this.password});
  }

  // Método envio de formulario de registro
  onSubmitRegister(): void {
    this.onSubmitRegisterEvent.emit({"firstName": this.firstName, "lastName": this.lastName, "login": this.login, "password": this.password});
  }
}

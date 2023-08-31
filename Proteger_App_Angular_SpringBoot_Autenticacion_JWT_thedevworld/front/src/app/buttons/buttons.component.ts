import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-buttons',
  templateUrl: './buttons.component.html',
  styleUrls: ['./buttons.component.css']
})

export class ButtonsComponent {

  // Eventos de salida
  @Output() loginEvent = new EventEmitter();
  @Output() logoutEvent = new EventEmitter();
}

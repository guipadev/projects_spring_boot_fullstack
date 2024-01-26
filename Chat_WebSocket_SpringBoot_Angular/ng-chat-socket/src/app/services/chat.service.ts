import { Injectable } from '@angular/core';
import { Stomp } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { ChatMessage } from '../models/chat-message';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private stompClient: any;

  // Listener cuando se envie rta del servidor socket, en el front estara escuchando y en base a eso, se ejecuta una acción
  private messageSubject: BehaviorSubject<ChatMessage[]> = new BehaviorSubject<
    ChatMessage[]
  >([]);

  constructor() {
    this.initConnectionSocket();
  }

  // Instanciar la conexión
  initConnectionSocket() {
    // Ruta tcp back
    const url = '//localhost:3000/chat-socket';

    // Uso libreria
    const socket = new SockJS(url);

    this.stompClient = Stomp.over(socket);
  }

  // Conexión a sala
  joinRoom(roomId: string) {
    this.stompClient.connect({}, () => {
      // No todos los usuarios conectados pueden enviar msj, solo los conectados a la sala
      // Relacionado en el controller del back
      this.stompClient.subscribe(`/topic/${roomId}`, (messages: any) => {
        const messageContent = JSON.parse(messages.body);
        //console.log(messageContent);

        // Capturo los mjs que tengo en memoria
        const currentMessage = this.messageSubject.getValue();

        // Agregar msjs que vienen del servidor
        currentMessage.push(messageContent);

        // Al subcrito envio msjs
        this.messageSubject.next(currentMessage);
      });
    });
  }

  // Envío msj
  sendMessage(roomId: string, chatMessage: ChatMessage) {
    // La comunicación con el destino en el back quedo configurado /app y posterior /chat del controller
    this.stompClient.send(
      `/app/chat/${roomId}`,
      {},
      JSON.stringify(chatMessage)
    );
  }

  // Retornar lo que tiene el msj
  getMessageSubject() {
    return this.messageSubject.asObservable();
  }
}

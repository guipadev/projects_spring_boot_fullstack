import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { ChatMessage } from 'src/app/models/chat-message';
import { ChatService } from 'src/app/services/chat.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss'],
})
export class ChatComponent implements OnInit {
  // Capturar el msj
  messageInput: string = '';
  // Capturar el id del usuario
  userId: string = '';
  // Capturar todos lo msjs que llegan del servidor
  messageList: any[] = [];

  constructor(
    private chatService: ChatService,
    // Permite capturar parametros desde la URL
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['userId']; // Obtener Id
    this.chatService.joinRoom('ABC'); // Obtener sala
    this.lisenerMessage();
  }

  sendMessage() {
    const chatMessage = {
      message: this.messageInput,
      user: this.userId,
    } as ChatMessage;
    this.chatService.sendMessage('ABC', chatMessage);
    this.messageInput = ''; // Al terminar el msj, limpiar
  }

  lisenerMessage() {
    this.chatService.getMessageSubject().subscribe((message: any) => {
      this.messageList = message.map((item: any) => ({
        ...item,
        message_side: item.user === this.userId ? 'sender' : 'receiver', // validación user que envia msj
      }));
    });
  }
}

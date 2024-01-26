package co.yom.socket.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import co.yom.socket.dto.ChatMessage;

@Controller
public class WebSocketController {

    @MessageMapping("/chat/{roomId}") // Parametro entrada
    @SendTo("/topic/{roomId}") // Redireccionar el msj
    public ChatMessage chat(@DestinationVariable String roomId, ChatMessage message) { // Indicar el room sala a
                                                                                       // ingresar
        System.out.println(message);
        return new ChatMessage(message.getMessage(), message.getUser());
    }
}

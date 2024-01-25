package co.yom.socket.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    /**
     * Permite habilitar Broker para la comunicación
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // path ingresa los msjs
        registry.setApplicationDestinationPrefixes("/app"); // path destino de los msjs
    }

    /**
     * Permite registrar los end point
     * 
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // path a conectarse el front al chat
        registry.addEndpoint("/chat-socket")
                .setAllowedOrigins("http://localhost:4200") // Permiso dirección del front a conectarse
                .withSockJS(); // Conexión mediante libreria withSocketJs utilizada en el front

    }

}

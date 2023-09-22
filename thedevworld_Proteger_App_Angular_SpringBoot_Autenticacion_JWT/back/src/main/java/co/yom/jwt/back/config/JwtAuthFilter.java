package co.yom.jwt.back.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Creamos filtro HTTP para interceptar las llamadas entrantes y validar el JWT
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserAuthenticationProvider userAuthenticationProvider;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Primero se verifica si hay un encabezado de autorización
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {
            String[] authElements = header.split(" ");

            // La primer parte es un Bearer
            if (authElements.length == 2
                    && "Bearer".equals(authElements[0])) {
                try {
                    // El filtro HTTP primero se revisa  el verbo HTTP GET continua
                    if ("GET".equals(request.getMethod())) {
                        SecurityContextHolder.getContext().setAuthentication(
                                // Luego se valida el token, que es la segunda parte
                                userAuthenticationProvider.validateToken(authElements[1]));
                    } else {
                        // Si se trata de un PUT o DELETE, se usa una validación más fuerte
                        // La validación más fuerte comienza como antes
                        SecurityContextHolder.getContext().setAuthentication(
                                userAuthenticationProvider.validateTokenStrongly(authElements[1]));
                    }
                } catch (RuntimeException e) {
                    SecurityContextHolder.clearContext();
                    throw e;
                }
            }
        }
        // Al final continuo la cadena de filtros
        filterChain.doFilter(request, response);
    }
}

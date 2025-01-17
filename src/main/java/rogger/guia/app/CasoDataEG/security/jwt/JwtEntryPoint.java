package rogger.guia.app.CasoDataEG.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import rogger.guia.app.CasoDataEG.util.ClockPe;

import java.io.IOException;

@Component
@Slf4j
public class JwtEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e)
            throws IOException, ServletException {

        log.error("Excepcion en solicitud JWT");

        res.setContentType("application/json");
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.getOutputStream().println("{ \"timestamp\": \"" + ClockPe.getClockNow() + "\"," + "\"status\":" + res.getStatus() + ","
                + "\"error\":\"" + "No autorizado" + "\" ,\"message\":\"" + "Usuario no encontrado" + "\" }");
    }

}
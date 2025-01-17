package rogger.guia.app.CasoDataEG.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import rogger.guia.app.CasoDataEG.security.service.UserDetailsServiceImpl;

import java.io.IOException;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String token = getToken(req);

            if (token != null && jwtProvider.validateToken(token)) {

                String email = jwtProvider.getUserToken(token);

                UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(email);

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);

            }

        } catch (Exception e) {
            logger.error("fallo en el metodo doFilterInternal " + e.getMessage());
        }

        filterChain.doFilter(req, res);

    }

    private String getToken(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer")) {
            return header.replace("Bearer ", "");
        }

        return null;

    }

}

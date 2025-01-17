package rogger.guia.app.CasoDataEG.security.jwt;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rogger.guia.app.CasoDataEG.security.dto.JwtDTO;
import rogger.guia.app.CasoDataEG.security.model.UsuarioPrincipal;

import javax.crypto.SecretKey;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String key;

    @Value("${jwt.expiration}")
    private int expiration;

    private SecretKey getKeySecretPrivate() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public String generateToken(Authentication authentication) {

        UsuarioPrincipal user = (UsuarioPrincipal) authentication.getPrincipal();

        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expiration))
                .signWith(getKeySecretPrivate(), Jwts.SIG.HS512)
                .compact();
    }

    public String refreshToken(JwtDTO dto) throws ParseException {

        JWTClaimsSet claims = getJWTClaimsSet(dto.getToken());
        String user = claims.getSubject();
        List<String> roles = (List<String>) claims.getClaim("roles");

        return Jwts.builder()
                .subject(user)
                .claim("roles", roles)
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expiration))
                .signWith(getKeySecretPrivate(), Jwts.SIG.HS512)
                .compact();
    }

    public String getUserToken(String jws) {
        return getJWTClaimsSet(jws).getSubject();
    }

    public JWTClaimsSet getJWTClaimsSet(String jws) {

        try {
            return JWTParser.parse(jws).getJWTClaimsSet();
        } catch (ParseException e) {
            return null;
        }

    }

    public boolean validateToken(String jws) {

        try {

            return Jwts.parser().verifyWith(getKeySecretPrivate()).build()
                    .parseSignedClaims(jws)
                    .getPayload().getSubject()
                    .equals(getUserToken(jws));

        } catch (MalformedJwtException e) {
            log.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            log.error("token no soportado");
        } catch (ExpiredJwtException e) {
            log.error("token expirado");
        } catch (IllegalArgumentException e) {
            log.error("token vacío");
        } catch (SignatureException e) {
            log.error("firma mal formada");
        }

        return false;

    }

}

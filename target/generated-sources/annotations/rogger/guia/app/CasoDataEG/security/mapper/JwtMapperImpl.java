package rogger.guia.app.CasoDataEG.security.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;
import rogger.guia.app.CasoDataEG.security.dto.JwtDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T17:14:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class JwtMapperImpl implements JwtMapper {

    @Override
    public JwtDTO jwtDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        JwtDTO jwtDTO = new JwtDTO();

        jwtDTO.setId( usuario.getIdUsuario() );

        return jwtDTO;
    }
}

package rogger.guia.app.CasoDataEG.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;
import rogger.guia.app.CasoDataEG.security.dto.JwtDTO;

@Mapper(componentModel = "spring")
public interface JwtMapper {

    @Mapping(target = "id", source = "idUsuario")
    @Mapping(target = "personal", ignore = true)
    @Mapping(target = "token", ignore = true)
    JwtDTO jwtDTO(Usuario usuario);
}

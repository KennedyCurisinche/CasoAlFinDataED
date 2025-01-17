package rogger.guia.app.CasoDataEG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNameUsuario(String username);

}

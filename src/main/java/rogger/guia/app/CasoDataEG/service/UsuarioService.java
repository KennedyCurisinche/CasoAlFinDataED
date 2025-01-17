package rogger.guia.app.CasoDataEG.service;

import rogger.guia.app.CasoDataEG.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findById(Long id);

    Usuario findByNameUsuario(String username);

}

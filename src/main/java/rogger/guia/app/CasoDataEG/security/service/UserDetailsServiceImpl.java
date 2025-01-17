package rogger.guia.app.CasoDataEG.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;
import rogger.guia.app.CasoDataEG.repository.UsuarioRepository;
import rogger.guia.app.CasoDataEG.security.model.UsuarioPrincipal;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByNameUsuario(username);
        return UsuarioPrincipal.build(usuario);
    }

}

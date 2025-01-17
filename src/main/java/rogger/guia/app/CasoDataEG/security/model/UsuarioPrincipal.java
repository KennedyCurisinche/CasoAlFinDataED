package rogger.guia.app.CasoDataEG.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {

    @Serial
    private static final long serialVersionUID = 5439669568069335223L;

    private Usuario usuario;
    private Collection<? extends GrantedAuthority> authorities;

    public static UsuarioPrincipal build(Usuario usuario) {
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombrerol().name()))
                .collect(Collectors.toList());
        return new UsuarioPrincipal(usuario, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.usuario.getPasswordUsuario();
    }

    @Override
    public String getUsername() {
        return this.usuario.getNameUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.usuario.getIsActive();
    }

}

package rogger.guia.app.CasoDataEG.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;
import rogger.guia.app.CasoDataEG.security.dto.JwtDTO;
import rogger.guia.app.CasoDataEG.security.dto.LoginDTO;
import rogger.guia.app.CasoDataEG.security.jwt.JwtProvider;
import rogger.guia.app.CasoDataEG.security.mapper.JwtMapper;
import rogger.guia.app.CasoDataEG.service.UsuarioService;

import java.text.ParseException;

@RestController
@CrossOrigin
@RequestMapping("/auth")
@Slf4j
public class UserAuthController {

    private final UsuarioService usuarioService;

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    private final JwtMapper jwtMapper;

    public UserAuthController(UsuarioService usuarioService, AuthenticationManager authenticationManager, JwtProvider jwtProvider, JwtMapper jwtMapper) {
        this.usuarioService = usuarioService;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.jwtMapper = jwtMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody LoginDTO loginUsuario) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getUsuario(), loginUsuario.getClave()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);
        String username = jwtProvider.getUserToken(jwt);
        Usuario usuario = usuarioService.findByNameUsuario(username);
        JwtDTO jwtDTO = jwtMapper.jwtDTO(usuario);
        jwtDTO.setToken(jwt);
        jwtDTO.setPersonal(usuario.getCliente().getNombreCliente());

        return new ResponseEntity<>(jwtDTO, HttpStatus.OK);
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtDTO> refresh(@RequestBody JwtDTO dto) {
        try {
            String jwt = jwtProvider.refreshToken(dto);
            String username = jwtProvider.getUserToken(jwt);
            Usuario usuario = usuarioService.findByNameUsuario(username);
            JwtDTO refreshTokenJwtDto = jwtMapper.jwtDTO(usuario);
            refreshTokenJwtDto.setToken(jwt);
            refreshTokenJwtDto.setPersonal(usuario.getCliente().getNombreCliente());
            return new ResponseEntity<>(refreshTokenJwtDto, HttpStatus.OK);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

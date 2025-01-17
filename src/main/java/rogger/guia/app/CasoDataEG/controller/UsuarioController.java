package rogger.guia.app.CasoDataEG.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rogger.guia.app.CasoDataEG.model.entity.Usuario;
import rogger.guia.app.CasoDataEG.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    @Secured({"ROLE_ADMIN"})
    public List<Usuario> lista() {
        return usuarioService.findAll();
    }

    @GetMapping("/lista/{id}")
    @Secured({"ROLE_ADMIN"})
    public Usuario porId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

}

package rogger.guia.app.CasoDataEG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rogger.guia.app.CasoDataEG.client.TipoCambioClient;
import rogger.guia.app.CasoDataEG.model.entity.Rol;
import rogger.guia.app.CasoDataEG.repository.RolRepository;

import java.util.List;

@SpringBootTest
public class TestRolRepository {

    @Autowired
    private RolRepository rolRepository;


    @Test
    void listaRol() {

        List<Rol> roles = rolRepository.findAll();

        roles.forEach(r -> System.out.println(r.getNombrerol()));

        Assertions.assertNotNull(roles);

    }

}

package rogger.guia.app.CasoDataEG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rogger.guia.app.CasoDataEG.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

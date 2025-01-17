package rogger.guia.app.CasoDataEG.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rogger.guia.app.CasoDataEG.model.entity.Operacion;

public interface OperacionRepository extends JpaRepository<Operacion, Long> {
}

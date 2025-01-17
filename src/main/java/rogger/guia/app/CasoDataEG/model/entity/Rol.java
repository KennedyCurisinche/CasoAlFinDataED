package rogger.guia.app.CasoDataEG.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import rogger.guia.app.CasoDataEG.security.enums.NombreRol;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Rol implements Serializable {

    @Serial
    private static final long serialVersionUID = -3456910101517029374L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Enumerated(EnumType.STRING)
    private NombreRol nombrerol;

}

package rogger.guia.app.CasoDataEG.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tipoCambio")
public class TipoCambio implements Serializable {

    @Serial
    private static final long serialVersionUID = -2513447811064446749L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoCambio;
    private String monedaTipoCambio;

}

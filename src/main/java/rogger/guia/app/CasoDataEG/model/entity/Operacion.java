package rogger.guia.app.CasoDataEG.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "operacion")
public class Operacion implements Serializable {

    @Serial
    private static final long serialVersionUID = -5105431693011675939L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOperacion;

    private String fechaOperacion;
    private BigDecimal valorVenta;
    private BigDecimal valorCompra;

    private BigDecimal ventaOperacion;

    private BigDecimal obtieneOperacion;

    private Long idmonedatipoorigen;
    private Long idmonedatipocambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente_ope")
    private Cliente cliente;

}

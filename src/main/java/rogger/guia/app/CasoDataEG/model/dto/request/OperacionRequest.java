package rogger.guia.app.CasoDataEG.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacionRequest {

    private Long idcliente;
    private BigDecimal monto;
    private Long idtipoorigen;
    private Long idtipocambio;
}

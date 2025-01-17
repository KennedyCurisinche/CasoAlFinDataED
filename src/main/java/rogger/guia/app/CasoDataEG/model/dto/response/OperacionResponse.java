package rogger.guia.app.CasoDataEG.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperacionResponse {

    private Long idoperacion;
    private String fechaoperacion;
    private String nombrepersona;
    private BigDecimal valorventa;
    private BigDecimal valorcompra;
    private BigDecimal ventalocal;
    private BigDecimal obtieneextranjero;
    private Long idmonedaorigen;
    private String origen;
    private Long idmonedacambio;
    private String cambio;

}

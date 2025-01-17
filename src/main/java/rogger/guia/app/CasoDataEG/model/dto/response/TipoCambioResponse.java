package rogger.guia.app.CasoDataEG.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TipoCambioResponse {

    private String fecha;
    private BigDecimal compra;
    private BigDecimal venta;

}

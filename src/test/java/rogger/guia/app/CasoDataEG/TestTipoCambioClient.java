package rogger.guia.app.CasoDataEG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import rogger.guia.app.CasoDataEG.client.TipoCambioClient;
import rogger.guia.app.CasoDataEG.model.dto.response.TipoCambioResponse;

public class TestTipoCambioClient {

    private static TipoCambioClient tipoCambioClient;

    @BeforeAll
    static void beforeAll() {
        tipoCambioClient = new TipoCambioClient(WebClient.builder());
    }

    @Test
    void testGetTextTipoCambio() {

        TipoCambioResponse tipoCambioResponse = tipoCambioClient.getTextTipoCambio();

        Assertions.assertNotNull(tipoCambioResponse);

        System.out.println("Fecha Consulta: " + tipoCambioResponse.getFecha());
        System.out.println("Compra: " + tipoCambioResponse.getCompra());
        System.out.println("Venta: " + tipoCambioResponse.getVenta());

        Assertions.assertTrue(tipoCambioResponse.getCompra().toString().startsWith("3"));

    }

}

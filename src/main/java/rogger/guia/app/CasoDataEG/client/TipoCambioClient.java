package rogger.guia.app.CasoDataEG.client;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import rogger.guia.app.CasoDataEG.model.dto.response.TipoCambioResponse;

import java.math.BigDecimal;

@Service
public class TipoCambioClient {

    private final WebClient webClient;

    public TipoCambioClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.sunat.gob.pe").build();
    }

    public TipoCambioResponse getTextTipoCambio() {

        String text = this.webClient.get().uri("/a/txt/tipoCambio.txt")
                .retrieve().bodyToMono(String.class).block();

        String[] array = text.replace('|', ',').split(",");

        return TipoCambioResponse.builder()
                .fecha(array[0])
                .compra(new BigDecimal(array[1]))
                .venta(new BigDecimal(array[2]))
                .build();
    }

}

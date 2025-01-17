package rogger.guia.app.CasoDataEG.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rogger.guia.app.CasoDataEG.client.TipoCambioClient;
import rogger.guia.app.CasoDataEG.mapper.OperacionMapper;
import rogger.guia.app.CasoDataEG.repository.ClienteRepository;
import rogger.guia.app.CasoDataEG.repository.OperacionRepository;
import rogger.guia.app.CasoDataEG.repository.SaldoRepository;
import rogger.guia.app.CasoDataEG.repository.TipoCambioRepository;
import rogger.guia.app.CasoDataEG.service.OperacionService;
import rogger.guia.app.CasoDataEG.service.impl.OperacionServiceImpl;

@Configuration
public class ConfigService {

    @Bean
    public OperacionService operacionService(OperacionRepository operacionRepository, ClienteRepository clienteRepository, SaldoRepository saldoRepository, TipoCambioClient tipoCambioClient, TipoCambioRepository tipoCambioRepository, OperacionMapper operacionMapper) {
        return new OperacionServiceImpl(
                operacionRepository,
                clienteRepository,
                saldoRepository,
                tipoCambioClient,
                tipoCambioRepository,
                operacionMapper
        );
    }

}

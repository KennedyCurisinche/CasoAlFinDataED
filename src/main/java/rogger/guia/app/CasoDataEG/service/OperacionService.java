package rogger.guia.app.CasoDataEG.service;

import rogger.guia.app.CasoDataEG.model.dto.request.OperacionRequest;
import rogger.guia.app.CasoDataEG.model.dto.response.OperacionResponse;

import java.util.List;

public interface OperacionService {

    void realizarCambio(OperacionRequest operacionRequest) throws Exception;
    List<OperacionResponse> listaOperacion();
}

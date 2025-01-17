package rogger.guia.app.CasoDataEG.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rogger.guia.app.CasoDataEG.model.dto.request.OperacionRequest;
import rogger.guia.app.CasoDataEG.model.dto.response.OperacionResponse;
import rogger.guia.app.CasoDataEG.service.OperacionService;

import java.util.List;

@RestController
@RequestMapping("/operacion")
public class OperacionController {

    @Autowired
    private OperacionService operacionService;

    @GetMapping("/listar")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<List<OperacionResponse>> listarOperaciones() {

        try {
            return new ResponseEntity<>(operacionService.listaOperacion(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/realizar")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<HttpStatus> realizarOperacion(@RequestBody OperacionRequest operacionRequest) throws Exception {

        operacionService.realizarCambio(operacionRequest);

        return new ResponseEntity<>(HttpStatus.OK);

    }


}

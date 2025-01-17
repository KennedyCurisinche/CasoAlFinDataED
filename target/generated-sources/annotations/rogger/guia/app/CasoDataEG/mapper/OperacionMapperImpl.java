package rogger.guia.app.CasoDataEG.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import rogger.guia.app.CasoDataEG.model.dto.response.OperacionResponse;
import rogger.guia.app.CasoDataEG.model.entity.Cliente;
import rogger.guia.app.CasoDataEG.model.entity.Operacion;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-17T17:14:22-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class OperacionMapperImpl implements OperacionMapper {

    @Override
    public OperacionResponse entityToResponse(Operacion operacion, String origen, String cambio) {
        if ( operacion == null && origen == null && cambio == null ) {
            return null;
        }

        OperacionResponse operacionResponse = new OperacionResponse();

        if ( operacion != null ) {
            operacionResponse.setIdoperacion( operacion.getIdOperacion() );
            operacionResponse.setFechaoperacion( operacion.getFechaOperacion() );
            operacionResponse.setObtieneextranjero( operacion.getObtieneOperacion() );
            operacionResponse.setValorventa( operacion.getValorVenta() );
            operacionResponse.setValorcompra( operacion.getValorCompra() );
            operacionResponse.setVentalocal( operacion.getVentaOperacion() );
            operacionResponse.setIdmonedacambio( operacion.getIdmonedatipocambio() );
            operacionResponse.setIdmonedaorigen( operacion.getIdmonedatipoorigen() );
            operacionResponse.setNombrepersona( operacionClienteNombreCliente( operacion ) );
        }
        operacionResponse.setOrigen( origen );
        operacionResponse.setCambio( cambio );

        return operacionResponse;
    }

    private String operacionClienteNombreCliente(Operacion operacion) {
        if ( operacion == null ) {
            return null;
        }
        Cliente cliente = operacion.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String nombreCliente = cliente.getNombreCliente();
        if ( nombreCliente == null ) {
            return null;
        }
        return nombreCliente;
    }
}

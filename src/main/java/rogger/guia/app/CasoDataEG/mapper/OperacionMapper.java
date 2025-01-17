package rogger.guia.app.CasoDataEG.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rogger.guia.app.CasoDataEG.model.dto.response.OperacionResponse;
import rogger.guia.app.CasoDataEG.model.entity.Operacion;

@Mapper(componentModel = "spring")
public interface OperacionMapper {

    @Mapping(target = "idoperacion", source = "operacion.idOperacion")
    @Mapping(target = "fechaoperacion", source = "operacion.fechaOperacion")
    @Mapping(target = "obtieneextranjero", source = "operacion.obtieneOperacion")
    @Mapping(target = "valorventa", source = "operacion.valorVenta")
    @Mapping(target = "valorcompra", source = "operacion.valorCompra")
    @Mapping(target = "ventalocal", source = "operacion.ventaOperacion")
    @Mapping(target = "idmonedacambio", source = "operacion.idmonedatipocambio")
    @Mapping(target = "cambio", source = "cambio")
    @Mapping(target = "idmonedaorigen", source = "operacion.idmonedatipoorigen")
    @Mapping(target = "origen", source = "origen")
    @Mapping(target = "nombrepersona", source = "operacion.cliente.nombreCliente")
    OperacionResponse entityToResponse(Operacion operacion, String origen, String cambio);

}

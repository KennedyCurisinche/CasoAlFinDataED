package rogger.guia.app.CasoDataEG.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
	
	private String usuario;
	private String clave;
	
}

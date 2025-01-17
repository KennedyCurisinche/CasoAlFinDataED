package rogger.guia.app.CasoDataEG.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private String usuario;
	private String clave;
	private Boolean estado;
	private Long idautorizado;
	private Set<Long> roles = new HashSet<>();
	
}

package rogger.guia.app.CasoDataEG.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtDTO {
	
	private Long id;
	private String personal;
	private String token;
	
}

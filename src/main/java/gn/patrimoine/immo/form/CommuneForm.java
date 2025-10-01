package gn.patrimoine.immo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommuneForm {

	private Long Id;
	
	private String nomCommune;
	
	private Long departementId;
}

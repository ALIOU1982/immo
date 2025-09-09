package gn.patrimoine.immo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdresseForm {
	
	private Long Id;
	
	private String nomQuartier;
	
	private String LibelleAdresse;
	
	private String CoordGeo;
	
	private Long communeId;

}

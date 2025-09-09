package gn.patrimoine.immo.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValorisationImmoForm {
	

	private Long Id;
	
	private Date dateCreation;
	
	private Date dateMaj;
	
	private Date finValidite;
	
	private Long points;
	
	private Long immobilisationId;

}

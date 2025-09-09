package gn.patrimoine.immo.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImmobilisationForm {
	
private Long Id;
	
	private Long typeId;
	
	private Long categorieId;
	
	private String libelleImmo;
	
	private String descriptionImmo;
	
	private Long surface;
	
	private Integer nbpieces;
	
	private Long prix;
	
	private Date datePublication;
	
	private Date dateValidation;
	
	private Boolean publication;
	
	private Boolean suppression;
	
	private Date dateSuppression;
	
	private byte[] images;
	
	private Long publieParId;
	
	private Long validerParId;
	
	private Long supprimerParId;
	
	private Long adresseId;
	

}

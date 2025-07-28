/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Date;

import gn.patrimoine.immo.entities.Adresse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author user
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImmobilisationDto {
	
	private Long Id;
	private TypeImmoDto typeImmo;
	private CategorieImmoDto categorieImmo;
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
	private PersonneDto publiePar;
	private PersonneDto validerPar;
	private PersonneDto supprimerPar;
	private Adresse adresseImmo;

}

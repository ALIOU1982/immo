/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
public class PersonneDto {
	
	private Long Id;
	private String nom;
	private String prenom;
	private Adresse adresse;
	private String Telephone;
	private String mail;
	private String sexe;
	private Date dateNaissance;
	private String LieuNaissance;	
	private String motDePasse;
	private ProfilDto profil;
	private Set<ImmobilisationDto> publications = new HashSet<>();
	private Set<ImmobilisationDto> validations = new HashSet<>();
	private Set<ImmobilisationDto> suppressions = new HashSet<>();

}

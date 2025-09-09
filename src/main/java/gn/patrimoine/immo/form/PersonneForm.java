package gn.patrimoine.immo.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneForm {
	
private Long Id;
	
	private String nom;
	
	private String prenom;
	
	private Long adresseId;
	
	private String Telephone;
	
	private String mail;
	
	private String sexe;
	
	private Date dateNaissance;
	
	private String LieuNaissance;	
	
	private String motDePasse;
	
	private Long profilId;
}

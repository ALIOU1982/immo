/**
 * 
 */
package gn.patrimoine.immo.iservices;

import java.util.List;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.dto.ProfilDto;
import gn.patrimoine.immo.entities.Personne;
import gn.patrimoine.immo.form.ProfilForm;

/**
 * @author user
 *
 */
public interface IPersonneService {
	
	public PersonneDto mapToDto(Personne personne);
	
	public Personne mapToEntity(PersonneDto personneDto);
	
	public Personne findById(Long Id);
	
	public List<ProfilDto> allProfils();
	
	public ProfilDto findProfil(Long id);
	
	public void sauveProfil(ProfilForm profilForm);
	
	public void supprimerProfil(Long id);
	
	public void updateProfil(ProfilDto profilDto);

}

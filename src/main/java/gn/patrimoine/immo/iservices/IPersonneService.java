/**
 * 
 */
package gn.patrimoine.immo.iservices;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.entities.Personne;

/**
 * @author user
 *
 */
public interface IPersonneService {
	
	public PersonneDto mapToDto(Personne personne);
	
	public Personne mapToEntity(PersonneDto personneDto);
	
	public Personne findById(Long Id);

}

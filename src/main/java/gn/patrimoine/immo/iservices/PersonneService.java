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
public interface PersonneService {
	
	public PersonneDto mapToDto(Personne personne);
	
	public Personne mapToEntity(PersonneDto personneDto);

}

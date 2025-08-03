/**
 * 
 */
package gn.patrimoine.immo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.entities.Personne;
import gn.patrimoine.immo.iservices.IPersonneService;
import gn.patrimoine.immo.repositories.PersonneRepository;

/**
 * @author user
 *
 */

@Service
public class PersonneService implements IPersonneService {
	
	@Autowired
	PersonneRepository personneRepository;
	
	public PersonneDto mapToDto(Personne personne){
		//PersonneDto personneDto = new PersonneDto();
		return  null;
	}
	
	public Personne mapToEntity(PersonneDto personneDto){
		return null;
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IPersonneService#findById(java.lang.Long)
	 */
	@Override
	public Personne findById(Long Id) {
		// TODO Auto-generated method stub
		return personneRepository.findById(Id).get();
	}
	
	

}

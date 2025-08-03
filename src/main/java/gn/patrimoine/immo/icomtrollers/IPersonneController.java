/**
 * 
 */
package gn.patrimoine.immo.icomtrollers;

import org.springframework.http.ResponseEntity;

import gn.patrimoine.immo.dto.PersonneDto;

/**
 * @author user
 *
 */
public interface IPersonneController {
	
	public ResponseEntity<PersonneDto> findById(Long Id);

}

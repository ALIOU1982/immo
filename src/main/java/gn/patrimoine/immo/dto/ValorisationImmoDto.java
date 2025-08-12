/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Date;

import gn.patrimoine.immo.entities.Immobilisation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author user
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValorisationImmoDto {
	
	private Long Id;
	
	private Date dateCreation;
	
	private Date dateMaj;
	
	private Date finValidite;
	
	private Long points;
	
	private Immobilisation immobilisation;
}

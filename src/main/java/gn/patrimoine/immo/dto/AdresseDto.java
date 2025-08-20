/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Set;

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
public class AdresseDto {
	
	private Long Id;
	
	private String nomQuartier;
	
	private String LibelleAdresse;
	
	private String CoordGeo;
	
	private CommuneDto communeDto;
	
	private Set<PersonneDto> personneDtos;
	
	private Set<ImmobilisationDto> immobilisationDtos;

}

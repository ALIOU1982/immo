/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.HashSet;
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
public class CommuneDto {
	
	private Long Id;
	
	private String nomCommune;
	
	private RegionDto regionDto;
	
	private Set<AdresseDto> adresseDtos = new HashSet<>();
}

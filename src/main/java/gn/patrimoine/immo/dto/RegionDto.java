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
public class RegionDto {
	
	private Long id;
	
	private String nomRegion;
	
	private Set<CommuneDto> communeDtos = new HashSet<>();

}

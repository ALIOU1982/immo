/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.List;

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
	
	private DepartementDto departementDto;
	
	private List<AdresseDto> adresseDtos;
}

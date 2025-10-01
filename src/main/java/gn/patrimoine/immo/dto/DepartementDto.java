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
public class DepartementDto {
	
	private Long id;
	
	private String nomDepartement;
	
	private List<CommuneDto> communeDtos;

}

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
public class TypeImmoDto {
	
	private Long Id;
	private String nomTypeImmo;
	private List<ImmobilisationDto> immobilisations;

}

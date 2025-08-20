/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message="Le nom de la région est obligatoire")
	@NotBlank(message="Le nom de la region n'est pas null")
	private String nomRegion;
	
	private Set<CommuneDto> communeDtos;

}

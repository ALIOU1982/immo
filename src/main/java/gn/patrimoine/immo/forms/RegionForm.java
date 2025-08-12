/**
 * 
 */
package gn.patrimoine.immo.forms;

import jakarta.validation.constraints.NotBlank;
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
public class RegionForm {
	
	@NotBlank(message = "Nom de la région est obligatoire")
    private String nomRegion;

}

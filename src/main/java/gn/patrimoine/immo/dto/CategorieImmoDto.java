/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.HashSet;
import java.util.Set;

import gn.patrimoine.immo.entities.Immobilisation;
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
public class CategorieImmoDto {

	private Long Id;
	private String categgorieImmo;
	private Set<Immobilisation> immobilisationCat  = new HashSet<>();
}

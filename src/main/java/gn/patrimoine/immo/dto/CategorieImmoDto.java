/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.List;

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
	private List<Immobilisation> immobilisationCat;
}

/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Set;

import gn.patrimoine.immo.entities.Personne;
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
public class ProfilDto {
	
	private Long Id;
	private String nomProfil;
	private Set<Personne> personnes;
}

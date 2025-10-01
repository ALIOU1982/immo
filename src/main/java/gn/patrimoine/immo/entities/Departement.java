/**
 * 
 */
package gn.patrimoine.immo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
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
@Entity
public class Departement {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=40)
	private String nomDepartement;
	
	@OneToMany(mappedBy="departement", orphanRemoval=true, cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
	private List<Commune> communes;

}

/**
 * 
 */
package gn.patrimoine.immo.entities;

import java.util.HashSet;
import java.util.Set;

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
public class Region {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=40)
	private String nomRegion;
	
	@OneToMany(mappedBy="region", cascade=CascadeType.ALL, orphanRemoval= true, fetch=FetchType.LAZY)
	private Set<Commune> communes = new HashSet<>();

}

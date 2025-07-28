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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author user
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commune {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=40)
	private String nomCommune;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "region_id", nullable=false)
	private Region region;
	
	@OneToMany(mappedBy="commune", cascade=CascadeType.ALL, orphanRemoval= true, fetch=FetchType.LAZY)
	private Set<Adresse> adresses = new HashSet<>();
}

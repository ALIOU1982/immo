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
public class Adresse {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=40)
	private String nomQuartier;
	
	@Column(length=40)
	private String LibelleAdresse;
	
	@Column(length=100, nullable=true)
	private String CoordGeo;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "commune_id", nullable=false)
	private Commune commune;
	
	@OneToMany(mappedBy="adresse", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Personne> personnes = new HashSet<>();
	
	@OneToMany(mappedBy="adresseImmo", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Immobilisation> immobilisations = new HashSet<>();
}

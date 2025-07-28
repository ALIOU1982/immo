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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypeImmo {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=50)
	private String nomTypeImmo;
	
	@OneToMany(mappedBy="typeImmo", cascade=CascadeType.ALL, orphanRemoval= true, fetch=FetchType.LAZY)
	private Set<Immobilisation> immobilisations  = new HashSet<>();
}

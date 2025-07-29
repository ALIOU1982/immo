package gn.patrimoine.immo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Immobilisation {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "typeImmo_id", nullable=false)
	private TypeImmo typeImmo;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "categorieImmo_id", nullable=false)
	private CategorieImmo categorieImmo;
	
	@Column(length=50)
	private String libelleImmo;
	
	@Column(length=1000)
	private String descriptionImmo;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "adresse_id", nullable=false)
	private Adresse adresseImmo;
	
	private Long surface;
	
	private Integer nbpieces;
	
	private Long prix;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date datePublication;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date dateValidation;
	
	//@Column(columnDefinition="BOOLEAN DEFAULT false")
	private Boolean publication;
	
	private Boolean suppression;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date dateSuppression;
	
	private byte[] images;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable=false)
	private Personne publiePar;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "personne_validation_id", nullable=true)
	private Personne validerPar;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "personne_supprime_id", nullable=true)
	private Personne supprimerPar;
}

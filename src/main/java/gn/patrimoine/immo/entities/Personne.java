package gn.patrimoine.immo.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Personne {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Column(length=20)
	private String nom;
	
	@Column(length=40)
	private String prenom;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "adresse_id", nullable=false)
	private Adresse adresse;
	
	@Column(length=30)
	private String Telephone;
	
	@Column(length=40)
	private String mail;
	
	@Column(length=10)
	private String sexe;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat( pattern = "dd/MM/yyyy" )
	private Date dateNaissance;
	
	@Column(length=50)
	private String LieuNaissance;
	
	@Column(nullable=false, length=20)	
	private String motDePasse;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "profil_id", nullable=false)
	private Profil profil;
	
	@OneToMany(mappedBy="publiePar", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Immobilisation> publications = new HashSet<>();
	
	@OneToMany(mappedBy="validerPar", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Immobilisation> validations = new HashSet<>();
	
	@OneToMany(mappedBy="supprimerPar", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Immobilisation> suppressions  = new HashSet<>();

}

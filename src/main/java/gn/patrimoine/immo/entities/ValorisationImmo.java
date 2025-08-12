/**
 * 
 */
package gn.patrimoine.immo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
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

/**
 * @author user
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ValorisationImmo {
	

	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date dateCreation;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date dateMaj;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date finValidite;
	
	private Long points;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "immobilisation_id", nullable=false)
	private Immobilisation immobilisation;

}

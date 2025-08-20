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
public class Messages {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private Boolean sms;
	
	private Boolean mail;
	
	private String messageSMS;
	
	private String  messageMail;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat( pattern = "dd/MM/yyyy HH:mm" )
	private Date dateEnvoi;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "personne_id", nullable=false)
	private Personne envoieA;

}

/**
 * 
 */
package gn.patrimoine.immo.dto;

import java.util.Date;

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
public class MessagesDto {
	
	private Long Id;
	
	private Boolean sms;
	
	private Boolean mail;
	
	private String messageSMS;
	
	private String  messageMail;
	
	private Date dateEnvoi;
	
	private PersonneDto personneDto;
}

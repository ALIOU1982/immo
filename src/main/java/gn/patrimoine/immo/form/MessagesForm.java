package gn.patrimoine.immo.form;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessagesForm {
	
	private Long Id;
	
	private Boolean sms;
	
	private Boolean mail;
	
	private String messageSMS;
	
	private String  messageMail;
	
	private Date dateEnvoi;
	
	private Long personneId;
}

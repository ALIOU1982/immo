package gn.patrimoine.immo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartementForm {
	
	private Long id;
	
	@NotNull(message="Le nom de la région est obligatoire")
	@NotBlank(message="Le nom de la region n'est pas null")
	private String nomDepartement;

}

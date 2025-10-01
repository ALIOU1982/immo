/**
 * 
 */
package gn.patrimoine.immo.icomtrollers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import gn.patrimoine.immo.form.DepartementForm;

/**
 * @author user
 *
 */
public interface IAdresseController {
	
	public String allDepartements(Model model);
	
	public String creerDepartement(Model model);
	
	public String saveDepartement( DepartementForm departementForm, BindingResult bindingResult, Model model);

}

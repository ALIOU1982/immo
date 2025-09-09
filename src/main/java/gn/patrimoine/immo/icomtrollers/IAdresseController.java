/**
 * 
 */
package gn.patrimoine.immo.icomtrollers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import gn.patrimoine.immo.form.RegionForm;

/**
 * @author user
 *
 */
public interface IAdresseController {
	
	public String allRegions(Model model);
	
	public String creerRegion(Model model);
	
	public String saveRegion( RegionForm regionForm, BindingResult bindingResult, Model model);

}

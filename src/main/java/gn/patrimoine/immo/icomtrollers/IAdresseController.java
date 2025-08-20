/**
 * 
 */
package gn.patrimoine.immo.icomtrollers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import gn.patrimoine.immo.dto.RegionDto;

/**
 * @author user
 *
 */
public interface IAdresseController {
	
	public String allRegions(Model model);
	
	public String creerRegion(Model model);
	
	public String saveRegion( RegionDto regionDto, BindingResult bindingResult, Model model);

}

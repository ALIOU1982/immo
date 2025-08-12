/**
 * 
 */
package gn.patrimoine.immo.icomtrollers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import gn.patrimoine.immo.forms.RegionForm;

/**
 * @author user
 *
 */
public interface IRegionController {

	public ModelAndView saveRegion(RegionForm regionForm, BindingResult bindingResult, Model model);
}

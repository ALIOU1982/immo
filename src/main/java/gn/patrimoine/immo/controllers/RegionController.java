/**
 * 
 */
package gn.patrimoine.immo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.forms.RegionForm;
import gn.patrimoine.immo.icomtrollers.IRegionController;
import gn.patrimoine.immo.iservices.IRegionService;
import jakarta.validation.Valid;

/**
 * @author user
 *
 */
@Controller
public class RegionController implements IRegionController{
	
	@Autowired
	private IRegionService regionServiceImpl;
	
	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.icomtrollers.IRegionController#saveRegion(gn.patrimoine.immo.dto.RegionDto)
	 */
	@Override
	@PostMapping("/createRegion2")
	public ModelAndView saveRegion(@Valid @ModelAttribute  RegionForm regionForm, BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		RegionDto regionDto = new RegionDto();
		System.out.println("Test Par ici ");
		regionDto.setNomRegion(regionForm.getNomRegion());
		
		model.addAttribute("regionForm", regionForm);
		
		if (bindingResult.hasErrors()) {
	        return new ModelAndView("regions");
	    }
		
		regionServiceImpl.saveRegion(regionDto);
		
		return new ModelAndView("regions");
	}

}

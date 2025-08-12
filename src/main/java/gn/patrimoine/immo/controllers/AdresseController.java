/**
 * 
 */
package gn.patrimoine.immo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.forms.RegionForm;
import gn.patrimoine.immo.icomtrollers.IAdresseController;
import gn.patrimoine.immo.iservices.IRegionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author user
 *
 */
@Controller
@RequestMapping("/adresse")
@RequiredArgsConstructor
public class AdresseController  implements IAdresseController{
	
	
	@Autowired
	private final IRegionService regionService;
	
	
	@GetMapping("/listeRegions")
	public String allRegions(Model model){
		System.out.println("Toutes les regions");
		model.addAttribute("regions", regionService.allRegions());
		return  "adresse/regions";
	}
	
	@GetMapping("/creeRegion")
	public String creerRegion(Model model){
		model.addAttribute("nRegion", new RegionDto());
		return "adresse/creeRegion";
	}
	
	@PostMapping("/createRegion")
	public String saveRegion(@Valid @ModelAttribute("nRegion")  RegionDto regionDto, BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Regions Test "+regionDto.getNomRegion());
		if (bindingResult.hasErrors()) {
	        return "adresse/creeRegion";
	    }
		System.out.println("Sauve Regions "+regionDto.getNomRegion());
		regionService.saveRegion(regionDto);
		
		return "redirect:/adresse/listeRegions";
	}
	

}

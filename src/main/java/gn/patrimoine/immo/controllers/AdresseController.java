/**
 * 
 */
package gn.patrimoine.immo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.icomtrollers.IAdresseController;
import gn.patrimoine.immo.iservices.IRegionService;
import jakarta.validation.Valid;
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
	
	@DeleteMapping("/supprimeRegion/{id}")
	public String supprimeRegion(@PathVariable("id") String id){
		System.out.println("Supprime Regions Test "+id);
		regionService.supprimerRegion(Long.parseLong(id));
		return "redirect:/adresse/listeRegions";
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

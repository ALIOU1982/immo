/**
 * 
 */
package gn.patrimoine.immo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gn.patrimoine.immo.dto.CommuneDto;
import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.RegionForm;
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
		System.out.println("Toutes les communes");
		model.addAttribute("communes", regionService.allCommunes());
		return  "adresse/regions";
	}
	
	@GetMapping("/creeRegion")
	public String creerRegion(Model model){
		model.addAttribute("nRegion", new RegionForm());
		return "adresse/creeRegion";
	}
	
	@GetMapping("/supprimeRegion/{id}")
	public String supprimeRegion(@PathVariable("id") String id){
		System.out.println("Supprime Regions Test "+id);
		regionService.supprimerRegion(Long.parseLong(id));
		return "redirect:/adresse/listeRegions";
	}
	
	@GetMapping("/supprimeCommune/{id}")
	public String supprimeCommune(@PathVariable("id") String id){
		
		System.out.println("Supprime Commune Test "+id);
		regionService.supprimerCommune(Long.parseLong(id));
		return "redirect:/adresse/listeRegions";
	}
	
	@PostMapping("/createRegion")
	public String saveRegion(@Valid @ModelAttribute("nRegion")  RegionForm regionForm, BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Regions Test "+regionForm.getNomRegion());
		if (bindingResult.hasErrors()) {
	        return "adresse/creeRegion";
	    }
		System.out.println("Sauve Regions "+regionForm.getNomRegion());
		regionService.saveRegion(regionForm);
		
		return "redirect:/adresse/listeRegions";
	}
	
	@PutMapping("/editionRegion/{id}")
	public String editionRegion(@Valid @ModelAttribute("nEditRegion")  RegionForm regionForm, @PathVariable("id") String id) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Regions Test "+regionForm.getNomRegion());
		RegionDto regionDto = regionService.findRegion(Long.parseLong(id));
		regionForm.setId(regionDto.getId());
		System.out.println("Sauve Regions "+regionForm.getNomRegion());
		regionService.updateRegion(Long.parseLong(id), regionForm.getNomRegion());
		
		return "redirect:/adresse/listeRegions";
	}
	
	@PutMapping("/editionCommune/{id}")
	public String editionCommune(@Valid @ModelAttribute("nEditCommune")  CommuneForm communeForm, @PathVariable("id") String id) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Commune Test "+communeForm.getNomCommune());
		//CommuneDto communeDto = regionService.findCommune(Long.parseLong(id));
		//regionForm.setId(regionDto.getId());
		System.out.println("Sauve Regions Controlleur "+communeForm.getNomCommune()+" Id Region "+communeForm.getRegionId()+ " Id "+id);
		CommuneDto communeDto = regionService.findCommune(Long.parseLong(id));
		communeDto.setNomCommune(communeForm.getNomCommune());
		communeDto.setRegionDto(regionService.findRegion(communeForm.getRegionId()));
		regionService.updateCommune(communeDto);
		
		return "redirect:/adresse/listeRegions";
	}
	
	@PostMapping("/createCommune")
	public String saveCommune(@Valid @ModelAttribute("nCommune")  CommuneForm communeForm,  BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Commune Test "+model.getAttribute("nCommune")+" test "+communeForm.getRegionId());
		//RegionDto regionDto = regionService.findRegion(communeForm.getRegionId());
		if (bindingResult.hasErrors()) {
			System.out.println("Erreur "+bindingResult.getAllErrors());
	        return "adresse/creeCommune";
	    }
		System.out.println("Sauve Commune "+communeForm.toString());
		regionService.saveCommune(communeForm);
		
		return "redirect:/adresse/listeRegions";
	}
	
	@GetMapping("/creeCommune")
	public String creeCommune(Model model){
		model.addAttribute("nCommune", new CommuneForm());
		model.addAttribute("regions", regionService.allRegions());
		return "adresse/creeCommune";
	}
	
	@GetMapping("/editeRegion/{id}")
	public String editeRegion(@PathVariable("id") String id, Model model){
		RegionDto region = regionService.findRegion(Long.parseLong(id));
		model.addAttribute("nEditRegion", region);
		model.addAttribute("idRegion", id);
		model.addAttribute("nomRegion", region.getNomRegion());
		System.out.println("Nom Regiin >>>>> "+region.toString()+ " Id "+id);
		return "adresse/editeRegion";
	}
	
	@GetMapping("/editeCommune/{id}")
	public String editeCommune(@PathVariable("id") String id, Model model){
		CommuneDto communeDto = regionService.findCommune(Long.parseLong(id));
		CommuneForm com = new CommuneForm();
		com.setNomCommune(communeDto.getNomCommune());
		com.setRegionId(communeDto.getRegionDto().getId());
		model.addAttribute("nEditCommune", com);
		model.addAttribute("idCommune", id);
		model.addAttribute("nomCommune", communeDto.getNomCommune());
		model.addAttribute("nomRegion", communeDto.getRegionDto().getNomRegion());
		model.addAttribute("regionId", communeDto.getRegionDto().getId());
		model.addAttribute("regions", regionService.allRegions());
		return "adresse/editeCommune";
	}

}

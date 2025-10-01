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
import gn.patrimoine.immo.dto.DepartementDto;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.DepartementForm;
import gn.patrimoine.immo.icomtrollers.IAdresseController;
import gn.patrimoine.immo.iservices.IDepartementService;
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
	private final IDepartementService departementService;
	
	
	@GetMapping("/listeDepartements")
	public String allDepartements(Model model){
		model.addAttribute("departements", departementService.allDepartements());
		System.out.println("Toutes les communes");
		model.addAttribute("communes", departementService.allCommunes());
		return  "adresse/departements";
	}
	
	@GetMapping("/creeDepartement")
	public String creerDepartement(Model model){
		model.addAttribute("nDepartement", new DepartementForm());
		return "adresse/creeDepartement";
	}
	
	@GetMapping("/supprimeDepartement/{id}")
	public String supprimeDepartement(@PathVariable("id") String id){
		departementService.supprimerDepartement(Long.parseLong(id));
		return "redirect:/adresse/listeDepartements";
	}
	
	@GetMapping("/supprimeCommune/{id}")
	public String supprimeCommune(@PathVariable("id") String id){
		
		System.out.println("Supprime Commune Test "+id);
		departementService.supprimerCommune(Long.parseLong(id));
		return "redirect:/adresse/listeDepartements";
	}
	
	@PostMapping("/createDepartement")
	public String saveDepartement(@Valid @ModelAttribute("nDepartement")  DepartementForm departementForm, BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		if (bindingResult.hasErrors()) {
	        return "adresse/creeDepartement";
	    }
		departementService.saveDepartement(departementForm);
		
		return "redirect:/adresse/listeDepartements";
	}
	
	@PutMapping("/editionDepartement/{id}")
	public String editionDepartement(@Valid @ModelAttribute("nEditDepartement")  DepartementForm departementForm, @PathVariable("id") String id) {
		// TODO Auto-generated method stub
		DepartementDto departementDto = departementService.findDepartement(Long.parseLong(id));
		departementForm.setId(departementDto.getId());
		departementService.updateDepartement(Long.parseLong(id), departementForm.getNomDepartement());
		
		return "redirect:/adresse/listeDepartements";
	}
	
	@PutMapping("/editionCommune/{id}")
	public String editionCommune(@Valid @ModelAttribute("nEditCommune")  CommuneForm communeForm, @PathVariable("id") String id) {
		// TODO Auto-generated method stub
		System.out.println("Sauve Commune Test "+communeForm.getNomCommune());
		CommuneDto communeDto = departementService.findCommune(Long.parseLong(id));
		communeDto.setNomCommune(communeForm.getNomCommune());
		communeDto.setDepartementDto(departementService.findDepartement(communeForm.getDepartementId()));
		departementService.updateCommune(communeDto);
		
		return "redirect:/adresse/listeDepartements";
	}
	
	@PostMapping("/createCommune")
	public String saveCommune(@Valid @ModelAttribute("nCommune")  CommuneForm communeForm,  BindingResult bindingResult, Model model) {
		// TODO Auto-generated method stub
		if (bindingResult.hasErrors()) {
			System.out.println("Erreur "+bindingResult.getAllErrors());
	        return "adresse/creeCommune";
	    }
		System.out.println("Sauve Commune "+communeForm.toString());
		departementService.saveCommune(communeForm);
		
		return "redirect:/adresse/listeDepartements";
	}
	
	@GetMapping("/creeCommune")
	public String creeCommune(Model model){
		model.addAttribute("nCommune", new CommuneForm());
		model.addAttribute("departements", departementService.allDepartements());
		return "adresse/creeCommune";
	}
	
	@GetMapping("/editeDepartement/{id}")
	public String editeDepartement(@PathVariable("id") String id, Model model){
		DepartementDto departementDto = departementService.findDepartement(Long.parseLong(id));
		model.addAttribute("nEditDepartement", departementDto);
		model.addAttribute("idDepartement", id);
		model.addAttribute("nomDepartement", departementDto.getNomDepartement());
		return "adresse/editeDepartement";
	}
	
	@GetMapping("/editeCommune/{id}")
	public String editeCommune(@PathVariable("id") String id, Model model){
		CommuneDto communeDto = departementService.findCommune(Long.parseLong(id));
		CommuneForm com = new CommuneForm();
		com.setNomCommune(communeDto.getNomCommune());
		com.setDepartementId(communeDto.getDepartementDto().getId());
		model.addAttribute("nEditCommune", com);
		model.addAttribute("idCommune", id);
		model.addAttribute("nomCommune", communeDto.getNomCommune());
		model.addAttribute("nomDepartement", communeDto.getDepartementDto().getNomDepartement());
		model.addAttribute("departementId", communeDto.getDepartementDto().getId());
		model.addAttribute("departements", departementService.allDepartements());
		return "adresse/editeCommune";
	}
}

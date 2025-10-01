/**
 * 
 */
package gn.patrimoine.immo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.dto.ProfilDto;
import gn.patrimoine.immo.form.ProfilForm;
import gn.patrimoine.immo.icomtrollers.IPersonneController;
import gn.patrimoine.immo.iservices.IPersonneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

/**
 * @author user
 *
 */
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonneController implements IPersonneController{
	
	@Autowired
	IPersonneService personneService;
	
	@Autowired
	ModelMapper modelMapper;
	
	private final String ALL_PROFILS = "redirect:/users/listeProfils";
	
	@GetMapping("/listeProfils")
	public String allProfils(Model model){
		model.addAttribute("profils", personneService.allProfils());
		return  "users/profile";
	}
	
	@GetMapping("/creeProfil")
	public String creeProfil(Model model){
		model.addAttribute("nProfil", new ProfilForm());
		return "users/creeProfile";
	}
	
	@GetMapping("/supprimeProfil/{id}")
	public String supprimerProfil(@PathVariable("id") String id){
		personneService.supprimerProfil(Long.parseLong(id));
		return ALL_PROFILS;
	}
	
	
	@PostMapping("/createProfil")
	public String saveProfil(@Valid @ModelAttribute("nProfil") ProfilForm profilForm , BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
	        return "users/creeProfil";
	    }
		
		personneService.sauveProfil(profilForm);
		return ALL_PROFILS;
	}
	
	@GetMapping("/editeProfil/{id}")
	public String editeProfil(@PathVariable("id") String id, Model model){
		ProfilDto profilDto = personneService.findProfil(Long.parseLong(id));
		model.addAttribute("nEditProfil", profilDto);
		model.addAttribute("idProfil", id);
		model.addAttribute("nomProfil", profilDto.getNomProfil());
		return "users/editeProfil";
	}
	
	@PutMapping("/editionProfil/{id}")
	public String editionProfil(@Valid @ModelAttribute("nEditProfil")  ProfilForm profilForm, @PathVariable("id") String id) {
		// TODO Auto-generated method stub
		ProfilDto profilDto = personneService.findProfil(Long.parseLong(id));
		profilDto.setNomProfil(profilForm.getNomProfil());
		personneService.updateProfil(profilDto);
		
		return ALL_PROFILS;
	}
	
	

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.icomtrollers.IPersonneController#findById(java.lang.Long)
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PersonneDto> findById(@PathVariable Long Id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<PersonneDto>(modelMapper.map(personneService.findById(Id), PersonneDto.class), HttpStatus.OK);
	}
	
	@GetMapping("/home")
	public String  getHome(){
		return "Page d'Accueil";		
	}
	
	@RequestMapping("/index")
	public ModelAndView greeting(@RequestParam(value="nameTest", required=false, defaultValue="World") String nameTest, Model model) {
		System.out.println("Test "+nameTest);
		model.addAttribute("nameTest", nameTest);
		return new ModelAndView("index");
	 }
}

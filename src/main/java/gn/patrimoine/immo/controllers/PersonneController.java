/**
 * 
 */
package gn.patrimoine.immo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.icomtrollers.IPersonneController;
import gn.patrimoine.immo.iservices.IPersonneService;

/**
 * @author user
 *
 */
@RestController
@RequestMapping("/immo/user")
public class PersonneController implements IPersonneController{
	
	@Autowired
	IPersonneService personneService;
	
	@Autowired
	ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.icomtrollers.IPersonneController#findById(java.lang.Long)
	 */
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<PersonneDto> findById(@PathVariable Long Id) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(modelMapper.map(personneService.findById(Id), PersonneDto.class), HttpStatus.OK);
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

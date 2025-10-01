/**
 * 
 */
package gn.patrimoine.immo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gn.patrimoine.immo.dto.PersonneDto;
import gn.patrimoine.immo.dto.ProfilDto;
import gn.patrimoine.immo.entities.Personne;
import gn.patrimoine.immo.entities.Profil;
import gn.patrimoine.immo.form.ProfilForm;
import gn.patrimoine.immo.iservices.IPersonneService;
import gn.patrimoine.immo.repositories.PersonneRepository;
import gn.patrimoine.immo.repositories.ProfilRepository;

/**
 * @author user
 *
 */

@Service
public class PersonneService implements IPersonneService {
	
	@Autowired
	PersonneRepository personneRepository;
	
	@Autowired
	private ProfilRepository profilRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonneDto mapToDto(Personne personne){
		//PersonneDto personneDto = new PersonneDto();
		return  null;
	}
	
	public Personne mapToEntity(PersonneDto personneDto){
		return null;
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IPersonneService#findById(java.lang.Long)
	 */
	public Personne findById(Long Id) {
		// TODO Auto-generated method stub
		return personneRepository.findById(Id).get();
	}

	public List<ProfilDto> allProfils() {
		// TODO Auto-generated method stub
		List<Profil> profils = profilRepository.findAll();
		List<ProfilDto> profilDtos = new ArrayList<ProfilDto>();
		for(Profil prof : profils){
			ProfilDto profilDto = modelMapper.map(prof, ProfilDto.class);
			profilDtos.add(profilDto);
		}
		return profilDtos;
	}

	public void sauveProfil(ProfilForm profilForm) {
		// TODO Auto-generated method stub
		ProfilDto profilDto = new ProfilDto();
		profilDto.setNomProfil(profilForm.getNomProfil());
		profilRepository.save(modelMapper.map(profilDto, Profil.class));
		
	}
	
	public void supprimerProfil(Long id){
		profilRepository.deleteById(id);
	}
	
	public ProfilDto findProfil(Long id){
		return modelMapper.map(profilRepository.findById(id).get(), ProfilDto.class);
	}
	
	public void updateProfil(ProfilDto profilDto){
		profilRepository.save(modelMapper.map(profilDto, Profil.class));
	}

}

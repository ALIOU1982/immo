/**
 * 
 */
package gn.patrimoine.immo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import gn.patrimoine.immo.dto.ProfilDto;
import gn.patrimoine.immo.entities.Profil;
import gn.patrimoine.immo.iservices.IProfilService;
import gn.patrimoine.immo.repositories.ProfilRepository;

/**
 * @author user
 *
 */
public class ProfilService  implements IProfilService{
	
	@Autowired
	private ProfilRepository profilRepository;

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.ProfilService#findById(java.lang.Long)
	 */
	@Override
	public ProfilDto findById(Long id) {
		// TODO Auto-generated method stub
		return mapToDto(profilRepository.findById(id).get()); //modelMapper.map(profilRepository.findById(id).get(), ProfilDto.class);
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.ProfilService#AllProfil()
	 */
	@Override
	public List<ProfilDto> AllProfil() {
		// TODO Auto-generated method stub
		return  null;//profilRepository.findAll().stream().map(profil) , ProfilDto.class);
	}
	


	public Profil mapToEntity(ProfilDto profilDto){
		Profil profil = new Profil();
		profil.setNomProfil(profilDto.getNomProfil());
		profil.setPersonnes(profilDto.getPersonnes());
		return profil;
	}
	
	public ProfilDto mapToDto(Profil profil){
		ProfilDto profilDto = new ProfilDto();
		profilDto.setId(profil.getId());
		profilDto.setNomProfil(profil.getNomProfil());
		profilDto.setPersonnes(profil.getPersonnes());
		return profilDto;
	}

}

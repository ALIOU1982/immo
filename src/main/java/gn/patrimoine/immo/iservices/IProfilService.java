package gn.patrimoine.immo.iservices;

import java.util.List;

import gn.patrimoine.immo.dto.ProfilDto;
import gn.patrimoine.immo.entities.Profil;

public interface IProfilService {
	
	ProfilDto findById(Long id);
	
	List<ProfilDto> AllProfil();
	
	public Profil mapToEntity(ProfilDto profilDto);
	
	public ProfilDto mapToDto(Profil profil);

}

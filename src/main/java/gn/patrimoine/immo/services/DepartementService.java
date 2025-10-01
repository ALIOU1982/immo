/**
 * 
 */
package gn.patrimoine.immo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gn.patrimoine.immo.dto.CommuneDto;
import gn.patrimoine.immo.dto.DepartementDto;
import gn.patrimoine.immo.entities.Commune;
import gn.patrimoine.immo.entities.Departement;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.DepartementForm;
import gn.patrimoine.immo.iservices.IDepartementService;
import gn.patrimoine.immo.repositories.CommuneRepository;
import gn.patrimoine.immo.repositories.DepartementRepository;
import jakarta.transaction.Transactional;

/**
 * @author user
 *
 */
@Service
@Transactional
public class DepartementService implements IDepartementService{
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@Autowired
	private CommuneRepository communeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#saveRegion(gn.patrimoine.immo.entities.Region)
	 */
	public void saveDepartement(DepartementForm departementForm) {
		// TODO Auto-generated method stub
		DepartementDto departementDto = new DepartementDto();
		departementDto.setNomDepartement(departementForm.getNomDepartement());
		departementRepository.save(modelMapper.map(departementDto, Departement.class));
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#findRegion(java.lang.Long)
	 */
	public DepartementDto findDepartement(Long Id) {
		return modelMapper.map(departementRepository.findById(Id).get(), DepartementDto.class);
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#allRegions()
	 */
	public List<DepartementDto> allDepartements() {
		List<Departement> departements = departementRepository.findAll();
		List<DepartementDto>  departementDtos = new ArrayList<DepartementDto>();
		for(Departement dep : departements){
			DepartementDto departementDto = modelMapper.map(dep, DepartementDto.class);
			departementDtos.add(departementDto);
		}
		return  departementDtos;
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#supprimerRegion(java.lang.Long)
	 */
	public void supprimerDepartement(Long id) {
		departementRepository.deleteById(id);
	}
	
	public void supprimerCommune(Long id) {
		// TODO Auto-generated method stub
		communeRepository.deleteById(id);
	}

	public List<CommuneDto> allCommunes() {
		// TODO Auto-generated method stub
		List<Commune> communes = communeRepository.findAll();
		List<CommuneDto> communeDtos = new ArrayList<CommuneDto>();
		for(Commune commune: communes){
			System.out.println("communes "+commune.getNomCommune());
			CommuneDto communeDto = convertEntityToDto(commune);
			System.out.println("communeDto "+communeDto.toString());
			communeDtos.add(communeDto);
		}
		return communeDtos;
	}

	private CommuneDto convertEntityToDto(Commune commune){
		CommuneDto communeDto = new CommuneDto();
		communeDto.setId(commune.getId());
		communeDto.setNomCommune(commune.getNomCommune());
		communeDto.setDepartementDto(modelMapper.map(commune.getDepartement(), DepartementDto.class));
		return communeDto;
	}
	
	private Commune convertDtoToEntity(CommuneDto communeDto){
		Commune commune = new Commune();
		commune.setId(communeDto.getId());
		commune.setNomCommune(communeDto.getNomCommune());
		commune.setDepartement(modelMapper.map(communeDto.getDepartementDto(), Departement.class));
		return commune;
	}
	
	public void saveCommune(CommuneForm communeForm) {
		// TODO Auto-generated method stub
		CommuneDto communeDto = new CommuneDto();
		communeDto.setNomCommune(communeForm.getNomCommune());
		communeDto.setDepartementDto(findDepartement(communeForm.getDepartementId()));
		Commune commune = new Commune();
		commune.setNomCommune(communeDto.getNomCommune());

		System.out.println("Test "+communeDto.toString());
		commune.setDepartement(modelMapper.map(communeDto.getDepartementDto(), Departement.class));
		System.out.println("Test commune "+commune.toString());
		communeRepository.save(commune);
	}

	public void updateDepartement(Long id, String nomDepartement) {
		// TODO Auto-generated method stub
		departementRepository.updateDepartement(id, nomDepartement);		
	}
	
	public void updateCommune(Long id, String nomCommune, Long departementId) {
		// TODO Auto-generated method stub
		Departement departement = departementRepository.findById(departementId).get();
		System.out.println("region "+departement.toString()+" id "+id+" nom "+nomCommune);
		communeRepository.updateCommune(id, nomCommune, departement);		
	}

	public CommuneDto findCommune(Long Id) {
		// TODO Auto-generated method stub
		Commune commune = communeRepository.findById(Id).get();
		CommuneDto communeDto = new CommuneDto();
		communeDto.setId(commune.getId());
		communeDto.setNomCommune(commune.getNomCommune());
		communeDto.setDepartementDto(modelMapper.map(commune.getDepartement(), DepartementDto.class));
		return communeDto;
	}
	
	public void updateCommune(CommuneDto communeDto){
		communeRepository.save(convertDtoToEntity(communeDto));		
	}
}

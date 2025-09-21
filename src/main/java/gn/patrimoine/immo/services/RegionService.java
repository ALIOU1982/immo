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
import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.entities.Commune;
import gn.patrimoine.immo.entities.Region;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.RegionForm;
import gn.patrimoine.immo.iservices.IRegionService;
import gn.patrimoine.immo.repositories.CommuneRepository;
import gn.patrimoine.immo.repositories.RegionRepository;
import jakarta.transaction.Transactional;

/**
 * @author user
 *
 */
@Service
@Transactional
public class RegionService implements IRegionService{
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private CommuneRepository communeRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#saveRegion(gn.patrimoine.immo.entities.Region)
	 */
	public void saveRegion(RegionForm regionForm) {
		// TODO Auto-generated method stub
		RegionDto regionDto = new RegionDto();
		regionDto.setNomRegion(regionForm.getNomRegion());
		regionRepository.save(modelMapper.map(regionDto, Region.class));
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#findRegion(java.lang.Long)
	 */
	public RegionDto findRegion(Long Id) {
		return modelMapper.map(regionRepository.findById(Id).get(), RegionDto.class);
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#allRegions()
	 */
	public List<RegionDto> allRegions() {
		List<Region> regions = regionRepository.findAll();
		List<RegionDto>  regionDtos = new ArrayList<RegionDto>();
		for(Region reg: regions){
			RegionDto regionDto = modelMapper.map(reg, RegionDto.class);
			regionDtos.add(regionDto);
		}
		return  regionDtos;
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#supprimerRegion(java.lang.Long)
	 */
	public void supprimerRegion(Long id) {
		// TODO Auto-generated method stub
		regionRepository.deleteById(id);
	}
	
	public void supprimerCommune(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Service "+id);
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
		communeDto.setRegionDto(modelMapper.map(commune.getRegion(), RegionDto.class));
		return communeDto;
	}
	public void saveCommune(CommuneForm communeForm) {
		// TODO Auto-generated method stub
		CommuneDto communeDto = new CommuneDto();
		communeDto.setNomCommune(communeForm.getNomCommune());
		communeDto.setRegionDto(findRegion(communeForm.getRegionId()));
		Commune commune = new Commune();
		commune.setNomCommune(communeDto.getNomCommune());

		System.out.println("Test "+communeDto.toString());
		System.out.println("Test "+communeDto.getRegionDto().toString());
		commune.setRegion(modelMapper.map(communeDto.getRegionDto(), Region.class));
		System.out.println("Test commune "+commune.toString());
		communeRepository.save(commune);
	}

}

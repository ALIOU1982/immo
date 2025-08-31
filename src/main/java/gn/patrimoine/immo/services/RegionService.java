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
import gn.patrimoine.immo.iservices.IRegionService;
import gn.patrimoine.immo.repositories.CommuneRepository;
import gn.patrimoine.immo.repositories.RegionRepository;

/**
 * @author user
 *
 */
@Service
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
	public void saveRegion(RegionDto regionDto) {
		// TODO Auto-generated method stub
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
		System.out.println("List "+regionDtos.size());
		return  regionDtos;
	}

	/* (non-Javadoc)
	 * @see gn.patrimoine.immo.iservices.IRegionService#supprimerRegion(java.lang.Long)
	 */
	public void supprimerRegion(Long id) {
		// TODO Auto-generated method stub
		regionRepository.deleteById(id);
	}

	public List<CommuneDto> allCommunes() {
		// TODO Auto-generated method stub
		List<Commune> communes = communeRepository.findAll();
		List<CommuneDto> communeDtos = new ArrayList<CommuneDto>();
		
		for(Commune commune: communes){
			CommuneDto communeDto = modelMapper.map(commune, CommuneDto.class);
			/*communeDto.setId(commune.getId());
			communeDto.setNomCommune(commune.getNomCommune());
			communeDto.setRegionDto(modelMapper.map(commune.getRegion(), RegionDto.class));*/
			communeDtos.add(communeDto);
		}
				
		return communeDtos;
	}

	public void saveCommune(CommuneDto communeDto) {
		// TODO Auto-generated method stub
		communeRepository.save(modelMapper.map(communeDto, Commune.class));
	}

}

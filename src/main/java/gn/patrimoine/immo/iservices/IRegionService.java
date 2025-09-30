/**
 * 
 */
package gn.patrimoine.immo.iservices;

import java.util.List;


import gn.patrimoine.immo.dto.CommuneDto;
import gn.patrimoine.immo.dto.RegionDto;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.RegionForm;

/**
 * @author user
 *
 */
public interface IRegionService {
	
	public void saveRegion(RegionForm regionForm);
	
	public RegionDto findRegion(Long Id);
	
	public CommuneDto findCommune(Long Id);
	
	public List<RegionDto> allRegions();
	
	public void supprimerRegion(Long id);
	
	public void supprimerCommune(Long id);
	
	public List<CommuneDto> allCommunes();
	
	public void saveCommune(CommuneForm communeForm);
	
	public void updateRegion(Long id, String nomRegion);
	
	public void updateCommune(Long id, String nomRegion, Long regionId);
	
	public void updateCommune(CommuneDto communeDto);

}

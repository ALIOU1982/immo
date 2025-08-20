/**
 * 
 */
package gn.patrimoine.immo.iservices;

import java.util.List;

import gn.patrimoine.immo.dto.RegionDto;

/**
 * @author user
 *
 */
public interface IRegionService {
	
	public void saveRegion(RegionDto regionDto);
	
	public RegionDto findRegion(Long Id);
	
	public List<RegionDto> allRegions();
	
	public void supprimerRegion(Long id);

}

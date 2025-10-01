/**
 * 
 */
package gn.patrimoine.immo.iservices;

import java.util.List;


import gn.patrimoine.immo.dto.CommuneDto;
import gn.patrimoine.immo.dto.DepartementDto;
import gn.patrimoine.immo.form.CommuneForm;
import gn.patrimoine.immo.form.DepartementForm;

/**
 * @author user
 *
 */
public interface IDepartementService {
	
	public void saveDepartement(DepartementForm departementForm);
	
	public DepartementDto findDepartement(Long Id);
	
	public CommuneDto findCommune(Long Id);
	
	public List<DepartementDto> allDepartements();
	
	public void supprimerDepartement(Long id);
	
	public void supprimerCommune(Long id);
	
	public List<CommuneDto> allCommunes();
	
	public void saveCommune(CommuneForm communeForm);
	
	public void updateDepartement(Long id, String nomDepartement);
	
	public void updateCommune(Long id, String nomDepartement, Long departementId);
	
	public void updateCommune(CommuneDto communeDto);

}

/**
 * 
 */
package gn.patrimoine.immo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gn.patrimoine.immo.entities.Departement;

/**
 * @author user
 *
 */
public interface DepartementRepository extends JpaRepository<Departement, Long>{
	
	@Modifying
	@Query("update Departement r set r.nomDepartement = :nomDepartement where r.id = :id")
	void updateDepartement(@Param(value = "id") Long id, @Param(value = "nomDepartement") String nomDepartement);

}

/**
 * 
 */
package gn.patrimoine.immo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gn.patrimoine.immo.entities.Region;

/**
 * @author user
 *
 */
public interface RegionRepository extends JpaRepository<Region, Long>{
	
	@Modifying
	@Query("update Region r set r.nomRegion = :nomRegion where r.id = :id")
	void updateRegion(@Param(value = "id") Long id, @Param(value = "nomRegion") String nomRegion);

}

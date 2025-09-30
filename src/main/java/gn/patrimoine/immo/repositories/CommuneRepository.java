package gn.patrimoine.immo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gn.patrimoine.immo.entities.Commune;
import gn.patrimoine.immo.entities.Region;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
	
	@Modifying
	@Query("update Commune c set c.region = :region where c.id = :id")
	void updateCommune(@Param(value = "id") Long id, @Param(value = "nomCommune") String nomCommune, @Param(value = "region") Region region);
}

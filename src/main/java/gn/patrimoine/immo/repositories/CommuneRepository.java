package gn.patrimoine.immo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gn.patrimoine.immo.entities.Commune;
import gn.patrimoine.immo.entities.Departement;

public interface CommuneRepository extends JpaRepository<Commune, Long> {
	
	@Modifying
	@Query("update Commune c set c.departement = :departement where c.id = :id")
	void updateCommune(@Param(value = "id") Long id, @Param(value = "nomCommune") String nomCommune, @Param(value = "region") Departement departement);
	
	List<Commune> findByDepartement(Departement departement);
}

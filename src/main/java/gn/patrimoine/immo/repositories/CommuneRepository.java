package gn.patrimoine.immo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import gn.patrimoine.immo.entities.Commune;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

}

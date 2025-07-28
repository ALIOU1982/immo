package gn.patrimoine.immo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gn.patrimoine.immo.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {

}

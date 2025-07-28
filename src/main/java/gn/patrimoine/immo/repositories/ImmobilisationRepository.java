/**
 * 
 */
package gn.patrimoine.immo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gn.patrimoine.immo.entities.Immobilisation;

/**
 * @author user
 *
 */
public interface ImmobilisationRepository extends JpaRepository<Immobilisation, Long> {

}

package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	
	boolean existsByfifajoueurid(Long fifajoueurid);

}

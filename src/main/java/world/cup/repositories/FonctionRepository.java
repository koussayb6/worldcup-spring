package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Fonction;


@Repository
public interface FonctionRepository extends JpaRepository<Fonction, Long> {
	boolean existsBylibelle(String libelle);
}

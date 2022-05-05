package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
	boolean existsByEquipeid(Long equipeid);

}

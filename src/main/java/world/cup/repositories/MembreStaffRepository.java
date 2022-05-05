package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.MembreStaff;

@Repository
public interface MembreStaffRepository extends JpaRepository<MembreStaff, Long> {
	boolean existsBynom(String nom);
}

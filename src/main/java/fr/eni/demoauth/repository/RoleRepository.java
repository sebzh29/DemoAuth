package fr.eni.demoauth.repository;

import fr.eni.demoauth.bo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

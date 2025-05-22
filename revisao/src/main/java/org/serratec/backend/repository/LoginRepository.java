package org.serratec.backend.repository;

import java.util.Optional;

import org.serratec.backend.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginRepository extends JpaRepository<Login, Long> {
	Optional<Login> findByUsername(String username);
	Optional<Login> findByEmail(String email);

}

package org.serratec.backend.service;

import java.util.Optional;

import org.serratec.backend.entity.Login;
import org.serratec.backend.exception.LoginException;
import org.serratec.backend.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Login inserir(Login login) {

		Optional<Login> log = repository.findByUsername(login.getUsername());

		if (!log.isPresent()) {
			login.setPassword(passwordEncoder.encode(login.getPassword()));
			return repository.save(login);
		}

		throw new LoginException("Username já cadastrado!");
	}

}

package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
	Professor findByDNI(String dni);

	Page<Professor> findAll(Pageable pageable);
}

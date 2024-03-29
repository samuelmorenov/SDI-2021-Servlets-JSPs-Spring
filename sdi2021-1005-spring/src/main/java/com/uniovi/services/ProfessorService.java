package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	public List<Professor> getProfessors() {

		List<Professor> professorList = new ArrayList<Professor>();
		professorRepository.findAll().forEach(professorList::add);
		return professorList;
	}

	public Professor getProfessor(Long id) {
		return professorRepository.findById(id).get();
	}

	public Professor getProfessorByDNI(String dni) {
		return professorRepository.findByDNI(dni);
	}

	public void addProfessor(Professor professor) {
		professorRepository.save(professor);
	}

	public void deleteProfessor(Long id) {
		professorRepository.deleteById(id);
	}

	public Page<Professor> getProfessors(Pageable pageable) {
		Page<Professor> professor = professorRepository.findAll(pageable);
		return professor;
	}

}

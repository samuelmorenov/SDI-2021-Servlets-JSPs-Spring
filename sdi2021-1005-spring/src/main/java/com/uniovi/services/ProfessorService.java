package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;

@Service
public class ProfessorService {

	private List<Professor> professorList = new LinkedList<Professor>();

	@PostConstruct
	public void init() {
		professorList.add(new Professor("11111111", "Pedro", "Sanchez", "Matematicas"));
		professorList.add(new Professor("22222222", "Juan", "Rubio", "Fisica"));
	}

	public List<Professor> getProfessors() {
		return professorList;
	}

	public Professor getProfessor(Long DNI) {
		return professorList.stream().filter(professor -> professor.getDNI().equals(DNI.toString())).findFirst().get();
	}

	public void addProfessor(Professor professor) {
		if (professor.getDNI() == null) {
			professor.setDNI(professorList.get(professorList.size() - 1).getDNI() + 1);
		}
		professorList.add(professor);
	}

	public void deleteProfessor(Long DNI) {
		professorList.removeIf(professor -> professor.getDNI().equals(DNI.toString()));
	}

}

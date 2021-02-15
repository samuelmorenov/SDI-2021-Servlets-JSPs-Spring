package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;

@RestController
public class ProfessorsController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping("/professor/list")
	public String getList() {
		return professorService.getProfessors().toString();
	}

	@RequestMapping(value = "/professor/add", method = RequestMethod.POST)
	public String setProfessor(@ModelAttribute Professor professor) {
		professorService.addProfessor(professor);
		return "Ok";
	}

	@RequestMapping("/professor/add")
	public String addProfessor() {
		return "Formulario de para añadir";
	}

	@RequestMapping("/professor/details/{DNI}")
	public String getProfessor(@PathVariable Long DNI) {
		return professorService.getProfessor(DNI).toString();
	}

	@RequestMapping("/professor/delete/{DNI}")
	public String deleteProfessor(@PathVariable Long DNI) {
		professorService.deleteProfessor(DNI);
		return "Ok";
	}

}

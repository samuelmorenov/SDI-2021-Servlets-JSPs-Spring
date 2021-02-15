package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@GeneratedValue
	private Long id;
	private String DNI;
	private String Name;
	private String LastName;
	private String Category;
	
	public Professor() {
		
	}

	public Professor(String dNI, String name, String lastName, String category) {
		super();

		DNI = dNI;
		Name = name;
		LastName = lastName;
		Category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	@Override
	public String toString() {
		return "Professor [DNI=" + DNI + ", Name=" + Name + ", LastName=" + LastName + ", Category=" + Category + "]";
	}

}

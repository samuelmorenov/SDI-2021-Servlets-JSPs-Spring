package com.uniovi.entities;

public class Professor {

	private String DNI;
	private String Name;
	private String LastName;
	private String Category;

	public Professor(String dNI, String name, String lastName, String category) {
		super();

		DNI = dNI;
		Name = name;
		LastName = lastName;
		Category = category;
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

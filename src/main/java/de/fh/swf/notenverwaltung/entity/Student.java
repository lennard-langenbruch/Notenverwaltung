package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	private Student() {}

	public Student(String vorname, String nachname, String matrikelnummer) {
		
		if(vorname == null || nachname == null || matrikelnummer == null) {
			throw new NullPointerException("Student Attribute für nicht null sein");
		}
		this.vorname = vorname;
		this.nachname = nachname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String vorname;
	
	@Column
	private String nachname;
	
	@Column
	private String matrikelnummer;
}

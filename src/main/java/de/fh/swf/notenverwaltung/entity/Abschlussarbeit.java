package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Abschlussarbeit {
	
	private Abschlussarbeit() {}
	
	public Abschlussarbeit(String thema) {
		this.thema = thema;
		this.creditpoints = "30";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String thema;
	
	@Column
	private String beschreibung;

	@Column
	private Boolean bestanden = false;
	
	@Column
	private String creditpoints;
	
	@Column
	private String note1;
	
	@Column
	private String note2;
	
	@ManyToOne
    @JoinColumn(name = "student_id")  // Adjust column name as needed
	@JsonIgnore
    private Student student;
	
	
		
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	
	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public Boolean getBestanden() {
		return bestanden;
	}

	public void setBestanden(Boolean bestanden) {
		this.bestanden = bestanden;
	}

	public String getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(String creditpoints) {
		this.creditpoints = creditpoints;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

}


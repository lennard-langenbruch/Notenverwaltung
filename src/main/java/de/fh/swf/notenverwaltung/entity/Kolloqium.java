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
public class Kolloqium {
	
	private Kolloqium() {}
	
	public Kolloqium(String thema) {
		this.thema = thema; 
		this.creditpoints = "30";
		this.bestanden = false;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String thema;
	
	@Column
	private String beschreibung;

	@Column
	private Boolean bestanden;
	
	@Column
	private String creditpoints;
	
	@Column
	private String note1;
	
	@Column
	private String note2;
	
	@Column
	private String endnote;
	
	@ManyToOne
    @JoinColumn(name = "student_id")  // Adjust column name as needed
	@JsonIgnore
    private Student student;
	
	public String getEndnote() {
		return endnote;
	}

	public void setEndnote(String endnote) {
		this.endnote = endnote;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	// Getter, Setter:
	public String getBeschreibung() {
		return beschreibung;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public Boolean getBestanden() {
		return bestanden;
	}

	public void setBestanden(Boolean bestanden) {
		this.bestanden = bestanden;
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

	public String getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(String creditpoints) {
		this.creditpoints = creditpoints;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	


}

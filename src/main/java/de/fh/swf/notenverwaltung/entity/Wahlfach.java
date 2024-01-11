package de.fh.swf.notenverwaltung.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.fh.swf.notenverwaltung.repository.StudentRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/*
 * Muss gewaehlt werden aus einem Pool
 * Maximal zwei
 * Gibt keine Creditpoints (= 0)
 * Darf nicht in die Gewichtung zählen
 * isWahlfach true zum unterscheiden zu Pflichtfach
 * */
@Entity
public class Wahlfach {
	
	private Wahlfach() {}
	
	public Wahlfach(String fachname) {  
		this.fachname = fachname;
		this.semester = "W";
		this.creditpoints = "0";
	}
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	protected String fachname;
	
	@Column
	protected String semester;
	
	@Column
	protected Boolean bestanden = false;
	
	@Column
	protected String creditpoints;
		
	@Column
	protected String note1 = "";
	
	@Column
	protected String note2 = "";
	
	@Column
	protected String note3 = "";
	
	@Column
	protected String endnote = "";

	@Column
	Boolean isGewaehlt = false;
	
	@ManyToOne
    @JoinColumn(name = "student_wahl")
	@JsonIgnore
    private Student student_wahl;
	
	public Student getStudent_wahl() {
		return student_wahl;
	}

	public void setStudent_wahl(Student student_wahl) {
		this.student_wahl = student_wahl;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFachname() {
		return fachname;
	}

	public void setFachname(String fachname) {
		this.fachname = fachname;
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

//	public void setCreditpoints(String creditpoints) {
//		this.creditpoints = creditpoints;
//	}
	
	public String getSemester() {
		return semester;
	}

//	public void setSemester(String semester) {
//		this.semester = semester;
//	}
	
	public void setNote1(String note1) {
		this.note1 = note1;
	}
	
	public void setNote2(String note2) {
		
		this.note2 = note2;
	}
	
	public void setNote3(String note3) {
		this.note3 = note3;
	}
	
	public String getNote1() {
		return note1;
	}
	
	public String getNote2() {
		return note2;
	}
	
	public String getNote3() {
		return note3;
	}

	public String getEndnote() {
		return endnote;
	}

	public void setEndnote(String endnote) {
		this.endnote = endnote;
	}

	public Boolean getIsGewaehlt() {
		return isGewaehlt;
	}

	public void setIsGewaehlt(Boolean isGewaehlt) {
		this.isGewaehlt = isGewaehlt;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public void setCreditpoints(String creditpoints) {
		this.creditpoints = creditpoints;
	}	
	
	
}
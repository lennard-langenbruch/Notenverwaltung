package de.fh.swf.notenverwaltung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Pflichtfach {
	
	private Pflichtfach() {};
	
	public Pflichtfach(String fachname, String creditpoints, String semester) {
		
		if(fachname == null) {
			throw new NullPointerException("Fachname darf hier nicht null sein");
		}
		
		this.fachname = fachname;
		this.creditpoints = creditpoints;
		this.semester = semester;
		
		if(Integer.valueOf(creditpoints) > 30 || Integer.valueOf(creditpoints) < 0) { 
			this.creditpoints = ""; 
		}
		
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
	protected Boolean creditpointsGranted = false;
		
	@Column
	protected String note1 = "";
	
	@Column
	protected String note2 = "";
	
	@Column
	protected String note3 = "";
	
	@Column
	protected String endnote = "";
	
	// Getter, Setter & Relations
	
	@ManyToOne
    @JoinColumn(name = "student_pflicht")
	@JsonIgnore
    private Student student_pflicht;
	
	

	public Boolean getCreditpointsGranted() {
		return creditpointsGranted;
	}

	public void setCreditpointsGranted(Boolean creditpointsGranted) {
		this.creditpointsGranted = creditpointsGranted;
	}

	public String getEndnote() {
		return endnote;
	}

	public void setEndnote(String endnote) {
		this.endnote = endnote;
	}

	public Student getStudent_pflicht() {
		return student_pflicht;
	}

	public void setStudent_pflicht(Student student_pflicht) {
		this.student_pflicht = student_pflicht;
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

	public void setCreditpoints(String creditpoints) {
		this.creditpoints = creditpoints;
	}
	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}

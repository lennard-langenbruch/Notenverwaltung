package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import de.fh.swf.notenverwaltung.repository.FachRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Pflichtfach {
	
	protected Pflichtfach() {};
	
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

	public void setCreditpoints(String creditpoints) {
		this.creditpoints = creditpoints;
	}
	
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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
	protected Integer gewichtung = 1;
	
	@Column
	protected Boolean isWahlfach = false ;
	
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

}

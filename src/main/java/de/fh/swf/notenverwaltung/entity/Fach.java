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
public class Fach {
	
	private Fach() {};
	
	public Fach(String fachname, Float note) {
				
		if(fachname == null || note == null) {
			throw new NullPointerException("Fachname & Creditpoints dürfen hier nicht null sein");
		}
		
		this.fachname = fachname;
		addNote(note);
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

	public Integer getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(Integer creditpoints) {
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
	protected String semester = "2";
	
	@Column
	protected Boolean bestanden = false;
	
	@Column
	protected Integer creditpoints = 3;
	
	@Column
	protected Float note1 = 0.0f;
	
	@Column
	protected Float note2 = 0.0f;
	
	@Column
	protected Float note3 = 0.0f;
	
	@Column
	protected Integer versuch = 0;
	
	public void setNote1(Float note1) {
		this.note1 = note1;
	}
	
	public void setNote2(Float note2) {
		this.note2 = note2;
	}
	
	public void setNote3(Float note3) {
		this.note3 = note3;
	}
	
	public Float getNote1() {
		return note1;
	}
	
	public Float getNote2() {
		return note2;
	}
	
	public Float getNote3() {
		return note3;
	}

	public void addNote(Float note) {
		
		if(note == null)  {
			throw new NullPointerException("Wert für Note darf nicht null sein");
		}
	
		if( (note < 1.0f) || (note > 4.0f && note != 5.0f) )  {
			throw new IllegalArgumentException("Note muss zwischen 1.0 und 4.0 liegen oder exakt 5.0 sein. Bitte erneut versuchen.");
		}
	
		if(this.versuch == 0) {
			setNote1(note);
			this.versuch++;
		}
		
		if(this.versuch == 1) {
			setNote2(note);
			this.versuch++;
		}
		
		if(this.versuch == 2) {
			setNote3(note);
			this.versuch++;
		}	
	}
}

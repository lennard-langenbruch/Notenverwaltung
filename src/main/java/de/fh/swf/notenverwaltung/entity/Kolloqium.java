package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kolloqium {
	
	private Kolloqium() {}
	
	public Kolloqium(String thema, String creditpoints) {
		this.thema = thema;
		this.creditpoints = creditpoints;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String creditpoints;
	
	@Column
	private String thema;
	
	@Column
	private String beschreibung;
	
	public String getBeschreibung() {
		return beschreibung;
	}

	@Column
	private Boolean bestanden = false;
	
	@Column
	private String note1;
	
	@Column
	private String note2;
	


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


}

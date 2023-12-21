package de.fh.swf.notenverwaltung.entity;

import jakarta.persistence.Entity;

/*
 * Muss gewaehlt werden aus einem Pool
 * Maximal zwei
 * Gibt keine Creditpoints (= 0)
 * Darf nicht in die Gewichtung zählen
 * isWahlfach true zum unterscheiden zu Pflichtfach
 * */
@Entity
public class Wahlfach extends Pflichtfach {
	
	private Wahlfach() {}
	
	public Wahlfach(String fachname) { 
		//super(fachname); 
//		this.semester = "W";
//		this.creditpoints = "0";
//		this.isWahlfach = true;
	}
	
	Boolean isGewaehlt = false;

	public Boolean getGewaehlt() {
		return isGewaehlt;
	}

	public void setGewaehlt(Boolean gewaehlt) {
		this.isGewaehlt = gewaehlt;
	}	
}
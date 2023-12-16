package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Abschlussarbeit {
	
	private Abschlussarbeit() {}
	
	public Abschlussarbeit(String thema, Integer creditpoints) {
		this.thema = thema;
		this.creditpoints = creditpoints;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String thema;
	
	@Column
	private Boolean bestanden = false;
	
	@Column
	private Integer creditpoints;	
}


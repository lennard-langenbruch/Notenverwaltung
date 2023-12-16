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
	
	public Kolloqium(String fachname, Integer creditpoints) {
		this.fachname = fachname;
		this.creditpoints = creditpoints;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String fachname;
	
	@Column
	private Boolean bestanden = false;
	
	@Column
	private Integer creditpoints;
}

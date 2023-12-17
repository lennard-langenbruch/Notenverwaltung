package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Wahlfach extends Fach {
	
	public Wahlfach() {
		super();
		// super(name, note);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}

package de.fh.swf.notenverwaltung.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	private Student() {};
	
	public Student(String vor, String nach) { 
		this.vorname = vor; 
		this.nachname = nach; 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String notendurchschnitt;
	
	@Column
	private String vorname;
	
	@Column
	private String nachname;
	
	@Column
	private String matrikelnummer;
	
	// 180 Pts & erfolgreicher Abschluss	
	@Column
	private Boolean abschluss;
	
	@Column
	private Integer summeCreditpoints = 0;
	
	
	
	// Getter, Setter & Relations	
	@OneToMany(mappedBy = "student_pflicht", fetch = FetchType.LAZY)
    private List<Pflichtfach> pflicht;
	
	@OneToMany(mappedBy = "student_wahl", fetch = FetchType.LAZY)
    private List<Wahlfach> wahl;
	
	@OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private Kolloqium kolloqium;
	
	@OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private Abschlussarbeit abschlussarbeit;
	
	
	
	
	public Abschlussarbeit getAbschlussarbeit() {
		return abschlussarbeit;
	}

	public void setAbschlussarbeit(Abschlussarbeit abschlussarbeit) {
		this.abschlussarbeit = abschlussarbeit;
	}

	public Kolloqium getKolloqium() {
		return kolloqium;
	}

	public void setKolloqium(Kolloqium kolloqium) {
		this.kolloqium = kolloqium;
	}

	public Boolean getAbschluss() {
		return abschluss;
	}

	public void setAbschluss(Boolean abschluss) {
		this.abschluss = abschluss;
	}

	public Integer getSummeCreditpoints() {
		return summeCreditpoints;
	}

	public void setSummeCreditpoints(Integer summeCreditpoints) {
		this.summeCreditpoints = summeCreditpoints;
	}

	public String getNotendurchschnitt() {
		return notendurchschnitt;
	}

	public void setNotendurchschnitt(String notendurchschnitt) {
		this.notendurchschnitt = notendurchschnitt;
	}

	public List<Pflichtfach> getPflicht() {
		return pflicht;
	}

	public void setPflicht(List<Pflichtfach> pflicht) {
		this.pflicht = pflicht;
	}

	public List<Wahlfach> getWahl() {
		return wahl;
	}

	public void setWahl(List<Wahlfach> wahl) {
		this.wahl = wahl;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getMatrikelnummer() {
		return matrikelnummer;
	}

	public void setMatrikelnummer(String matrikelnummer) {
		this.matrikelnummer = matrikelnummer;
	}
	
	public Long getId() { return id; }
	
	public void setId(Long id) {
		this.id = id;
	}

	public void berechnen() {
	    Float summeDerGewichteterNoten = 0.0f;
	    Float summeDerCreditpoints = 0.0f;
	    
	    if (!pflicht.isEmpty() || pflicht != null || summeDerCreditpoints != 0.0f) {
	    
		    for (Pflichtfach fach : pflicht) {
		    	
		    	if(fach.getEndnote() != null && fach.getEndnote() != "") {
	
			    	Float gewichteteNote = Float.valueOf(fach.getEndnote()) * Float.valueOf(fach.getCreditpoints());
			    	
			    	summeDerGewichteterNoten += gewichteteNote;
			    	summeDerCreditpoints += Float.valueOf(fach.getCreditpoints());
		    	}
		    }
		    
		    this.summeCreditpoints = Math.round(summeDerCreditpoints);
		    this.notendurchschnitt = String.valueOf(summeDerGewichteterNoten / summeDerCreditpoints);

	    }
	    
	    if(this.kolloqium != null && this.kolloqium.getBestanden()) {
	    	this.summeCreditpoints = this.summeCreditpoints + Integer.valueOf(this.kolloqium.getCreditpoints());
	    }
	    
	    if(this.abschlussarbeit != null && this.abschlussarbeit.getBestanden()) {
	    	this.summeCreditpoints = this.summeCreditpoints + Integer.valueOf(this.abschlussarbeit.getCreditpoints());
	    }
	};
	
}

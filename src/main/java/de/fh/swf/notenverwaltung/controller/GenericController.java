package de.fh.swf.notenverwaltung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.fh.swf.notenverwaltung.entity.Abschlussarbeit;
import de.fh.swf.notenverwaltung.entity.Fach;
import de.fh.swf.notenverwaltung.entity.Kolloqium;
import de.fh.swf.notenverwaltung.repository.AbschlussarbeitRepository;
import de.fh.swf.notenverwaltung.repository.FachRepository;
import de.fh.swf.notenverwaltung.repository.KolloqiumRepository;
import de.fh.swf.notenverwaltung.repository.StudentRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class GenericController {
	
	@Autowired
	FachRepository fachRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AbschlussarbeitRepository abschlussarbeitRepository;
	
	@Autowired
	KolloqiumRepository kolloqiumRepository;
	
	/* GET Request Body / HTML Formulardaten zu Entität abspeichern*/

	@GetMapping("/create/fach")
	public String createFach(
			@RequestParam("fach") String name, 
			@RequestParam("note") String note) {
		
		Fach check = fachRepository.findOneByFachname(name);
		Float f = Float.valueOf(note);
		
		if(check == null) {
			Fach fach = new Fach(name, f);
			fachRepository.save(fach);
		}
		
		if(check != null) {
			check.addNote(f);
			fachRepository.save(check);
		}
		
		return "redirect:/index.html";
	}
	
	@GetMapping("/create/kolloqium")
	public String createKolloqium(@ModelAttribute Kolloqium kolloqium) {
		
		kolloqiumRepository.save(kolloqium);
		return "redirect:/index.html";
	}
		
	@GetMapping("/create/abschlussarbeit")
	public String createAbschlussarbeit(@ModelAttribute Abschlussarbeit abschlussarbeit) {
		
		abschlussarbeitRepository.save(abschlussarbeit);
		return "redirect:/index.html";
	}
	
	@GetMapping("/delete/fach/{id}")
	public void deleteFach(@PathVariable Long id) {
	    fachRepository.deleteById(id);
	    //reload after fetch in script
	}
	
	
	/* Alle Daten als JSON als HTTP Response */
	
	@GetMapping("/fetch/fach")
	@ResponseBody
	public List<Fach> fetchFach(){
		return fachRepository.findAll();
	}
	
	@GetMapping("/fetch/kolloqium")
	@ResponseBody
	public List<Kolloqium> fetchKolloqium(){
		return kolloqiumRepository.findAll();
	}
	
	@GetMapping("/fetch/abschlussarbeit")
	@ResponseBody
	public List<Abschlussarbeit> fetchAbschlussarbeit(){
		return abschlussarbeitRepository.findAll();
	}
}

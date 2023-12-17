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
			@RequestParam("semester") String semester,
			@RequestParam("fach") String name,
			@RequestParam("note1") String note1,
			@RequestParam("note2") String note2,
			@RequestParam("note3") String note3) {
		
		/*zweistellige fließkommazahl*/
		String regex = "^[0-9]\\.[0-9]";

		/*leer lassen wenn keine gültige/korrekte zahl*/
		if(note1.matches(regex) == false) 
			note1 = "";
		if(note2.matches(regex) == false) 
			note2 = "";
		if(note3.matches(regex) == false) 
			note3 = "";
		
		Fach check = fachRepository.findOneByFachname(name);
		
		if(note1.isEmpty() == false) {
			Float fnote1 = Float.parseFloat(note1);		
			if(( fnote1 > 1.0f && fnote1 < 4.0f) || fnote1 == 5.0f )  {
				note1 = fnote1.toString();
			}
		}
		
		if(note2.isEmpty() == false) {
			Float fnote2 = Float.parseFloat(note2);		
			if( (fnote2> 1.0f && fnote2 < 4.0f) || fnote2 == 5.0f)   {
				note2 = fnote2.toString();
			}
		}
		
		if(note3.isEmpty() == false) {
		Float fnote3 = Float.parseFloat(note3);
			if( (fnote3 > 1.0f && fnote3 < 4.0f) || fnote3 == 5.0f)  {
				note3 = fnote3.toString();
			}
		}
		
		if(check == null) {
			Fach fach = new Fach(name);
			fach.setSemester(semester);
			fach.setNote1(note1);
			fach.setNote2(note2);
			fach.setNote3(note3);
			fachRepository.save(fach);
		}
		
		if(check != null) {
		check.setSemester(semester);
		check.setNote1(note1);
		check.setNote2(note2);
		check.setNote3(note3);
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

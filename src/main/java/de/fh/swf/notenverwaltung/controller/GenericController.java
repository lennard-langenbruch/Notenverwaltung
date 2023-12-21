package de.fh.swf.notenverwaltung.controller;

import java.util.ArrayList;
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
import de.fh.swf.notenverwaltung.entity.Pflichtfach;
import de.fh.swf.notenverwaltung.entity.Kolloqium;
import de.fh.swf.notenverwaltung.repository.AbschlussarbeitRepository;
import de.fh.swf.notenverwaltung.repository.FachRepository;
import de.fh.swf.notenverwaltung.repository.KolloqiumRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class GenericController {
	
	@Autowired
	FachRepository fachRepository;
	
	@Autowired
	AbschlussarbeitRepository abschlussarbeitRepository;
	
	@Autowired
	KolloqiumRepository kolloqiumRepository;
		
	/* GET Request Body / HTML Formulardaten zu Entität abspeichern*/

	@GetMapping("/create/fach")
	public String createFach(
			@RequestParam("semester") String semester,
			@RequestParam("creditpoints") String creditpoints,
			@RequestParam("fach") String name,
			@RequestParam("note1") String note1,
			@RequestParam("note2") String note2,
			@RequestParam("note3") String note3) {
		
		/*zweistellige fließkommazahl*/
		String regex1 = "^[1-3]\\.[0-9]";
		String regex2 = "^[5]\\.[0]";
		String regex3 = "^[4]\\.[0]";

		if (!note1.matches("(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")")) {
		    note1 = "";
		}

		if (!note2.matches("(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")")) {
		    note2 = "";
		}

		if (!note3.matches("(" + regex1 + ")|(" + regex2 + ")|(" + regex3 + ")")) {
		    note3 = "";
		}
		
		Boolean passed = false;
		if(note1.isEmpty() || note1.equals("5.0") ) { note2 = ""; }
		if(note1.isEmpty() || note2.isEmpty() || note1.equals("5.0") || note2.equals("5.0")){ note3 = "";}
				
		if(note1.isEmpty() == false) { // wenn empty dann gar nichts
			Float fnote1 = Float.parseFloat(note1);
			if(( fnote1 >= 1.0f && fnote1 <= 4.0f))  {
				passed = true;
				if(fnote1 == 5.0f )
					note1 = fnote1.toString();
			}
		}
		
		// also wenn das eintritt dann lässt er den inout so wie war
		
		if((note2.isEmpty() == false)) { // wenn nicht empty aber note1 auch nicht empty und note1 aber auch nicht
			Float fnote2 = Float.parseFloat(note2);		
			if( (fnote2 >= 1.0f && fnote2 <= 4.0f))   {
				passed = true;
				if(fnote2 == 5.0f)
					note2 = fnote2.toString();
			}
		}
		
		if((note3.isEmpty() == false)) {
			Float fnote3 = Float.parseFloat(note3);
			if( ((fnote3 >= 1.0f && fnote3 <= 4.0f)))  {
				passed = true;
				if(fnote3 == 5.0f)
					note3 = fnote3.toString();
			}
		}
		
		/*gucken ob fach mit dem namen existiert*/
		Pflichtfach check = fachRepository.findOneByFachname(name);
		
		if(check == null) {
			Pflichtfach fach = new Pflichtfach(name,creditpoints,semester);
			fach.setNote1(note1);
			fach.setNote2(note2);
			fach.setNote3(note3);
			fach.setBestanden(passed);
			fachRepository.save(fach);
		}
		
		if(check != null) {
		check.setSemester(semester);
		check.setCreditpoints(creditpoints);
		check.setNote1(note1);
		check.setNote2(note2);
		check.setNote3(note3);
		check.setBestanden(passed);
		fachRepository.save(check);
		}
				
		return "redirect:/index.html";
	}
	
	@GetMapping("/create/kolloqium")
	public String createKolloqium(
			@RequestParam("creditpoints") String creditpoints,
			@RequestParam("thema") String name,
			@RequestParam("beschreibung") String beschreibung,
			@RequestParam("note1") String note1,
			@RequestParam("note2") String note2) {
		
		Kolloqium k = new Kolloqium(name,creditpoints);
		k.setBeschreibung(beschreibung);
		k.setNote1(note1);
		k.setNote2(note2);

		kolloqiumRepository.save(k);
		
		return "redirect:/kolloqium.html";
	};
	
	@GetMapping("/create/abschlussarbeit")
	public String createAbschlussarbeit(
			@RequestParam("creditpoints") String creditpoints,
			@RequestParam("thema") String name,
			@RequestParam("beschreibung") String beschreibung,
			@RequestParam("note1") String note1,
			@RequestParam("note2") String note2) {
		
		Abschlussarbeit a = new Abschlussarbeit(name,creditpoints);
		a.setBeschreibung(beschreibung);
		a.setNote1(note1);
		a.setNote2(note2);

		abschlussarbeitRepository.save(a);
		
		return "redirect:/abschlussarbeit.html";
	};
	
	@GetMapping("/delete/fach/{id}")
	public void deleteFach(@PathVariable Long id) {
	    fachRepository.deleteById(id);
	    //reload after fetch in script
	}
		
	@GetMapping("/delete/kolloqium/{id}")
	public void deleteKolloqium(@PathVariable Long id) {
		kolloqiumRepository.deleteById(id);
	    //reload after fetch in script
	}
	
	@GetMapping("/delete/abschlussarbeit/{id}")
	public void deleteAbschlussarbeit(@PathVariable Long id) {
		abschlussarbeitRepository.deleteById(id);
	    //reload after fetch in script
	}
	
	
	
	
	/* Alle Daten als JSON als HTTP Response */
	
	@GetMapping("/fetch/fach")
	@ResponseBody
	public List<Pflichtfach> fetchFach(){
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
	
	@GetMapping("/fetch/fach/single/{name}")
	@ResponseBody
	public List<Pflichtfach> fetchSingleFach(@PathVariable String name){
		
		List<Pflichtfach> ret = new ArrayList<>();
		ret.add(this.fachRepository.findOneByFachname(name));
		return ret;
	}
	
}

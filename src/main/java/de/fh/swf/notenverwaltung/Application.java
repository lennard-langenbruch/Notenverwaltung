package de.fh.swf.notenverwaltung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;

import de.fh.swf.notenverwaltung.entity.Student;
import de.fh.swf.notenverwaltung.entity.Wahlfach;
import de.fh.swf.notenverwaltung.repository.StudentRepository;
import de.fh.swf.notenverwaltung.repository.WahlfachRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EntityScan(basePackages = {
        "de.fh.swf.notenverwaltung.entity",
        "de.fh.swf.notenverwaltung.repository"
})
public class Application {

    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    WahlfachRepository wahlfachRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @PostConstruct
    public void init() {
        Student user = new Student("lennard", "langenbruch");
        studentRepository.save(user);
        
        Wahlfach beispiel = new Wahlfach("Machine Learning");
        wahlfachRepository.save(beispiel);
        Wahlfach beispiel2 = new Wahlfach("Skriptsprachen");
        wahlfachRepository.save(beispiel2);
        Wahlfach beispiel3 = new Wahlfach("Datenbanken 3");
        wahlfachRepository.save(beispiel3);
        
    }

    @GetMapping("/")
    public String index() {
        return "index.html";
    }
    

}
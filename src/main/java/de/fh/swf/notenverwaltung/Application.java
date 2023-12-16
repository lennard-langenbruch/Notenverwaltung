package de.fh.swf.notenverwaltung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import de.fh.swf.notenverwaltung.entity.Fach;
import de.fh.swf.notenverwaltung.repository.FachRepository;

@SpringBootApplication
@EntityScan(basePackages = {
"de.fh.swf.notenverwaltung.entity",
"de.fh.swf.notenverwaltung.repository",
"de.fh.swf.notenverwaltung.controller"
})
@Controller
public class Application {
	
	// Unerwartete exceptions fangen
	public static void main(String[] args) {
		try {
		SpringApplication.run(Application.class, args);
		}
		catch(Exception uncaught) { 
			System.out.println("Fatal: uncaught exception in @ Application.java");
			System.out.println(uncaught.getMessage());
		}
	}
	
	// Default: Datei static/index.html nach Start der Anwendung zeigen
    @GetMapping("/")
    public String index() {
    	
        return "index.html";
    }
	
    // Alle origins erlauben
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}

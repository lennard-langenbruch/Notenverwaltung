package de.fh.swf.notenverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fh.swf.notenverwaltung.entity.Pflichtfach;
import de.fh.swf.notenverwaltung.entity.Wahlfach;

public interface WahlfachRepository extends JpaRepository<Wahlfach, Long> {
	Wahlfach findOneByFachname(String fachname);
	
	void deleteById(Long id);
}

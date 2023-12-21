package de.fh.swf.notenverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fh.swf.notenverwaltung.entity.Pflichtfach;

public interface FachRepository extends JpaRepository<Pflichtfach, Long> {

	Pflichtfach findOneByFachname(String fachname);
	
	void deleteById(Long id);
	
}

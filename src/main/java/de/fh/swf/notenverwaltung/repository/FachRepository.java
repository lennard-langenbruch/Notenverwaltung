package de.fh.swf.notenverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fh.swf.notenverwaltung.entity.Fach;

public interface FachRepository extends JpaRepository<Fach, Long> {

	Fach findOneByFachname(String fachname);
	
	void deleteById(Long id);

}

package de.fh.swf.notenverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fh.swf.notenverwaltung.entity.Abschlussarbeit;

public interface AbschlussarbeitRepository extends JpaRepository<Abschlussarbeit, Long>{



	Abschlussarbeit findOneByThema(String name);

}

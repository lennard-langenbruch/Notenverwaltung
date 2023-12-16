package de.fh.swf.notenverwaltung.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.fh.swf.notenverwaltung.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

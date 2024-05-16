package org.cts.lms.repository;

import org.cts.lms.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer>{
	
}

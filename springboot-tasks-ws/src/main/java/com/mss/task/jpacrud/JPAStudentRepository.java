package com.mss.task.jpacrud;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAStudentRepository extends JpaRepository<Student, Integer> {
	List<Student> getByAge(String age);

	List<Student> getByAge(int age);
   // @Query("select r from studenttable r where r.name LIKE")
    @Query("SELECT r FROM studenttable r WHERE r.name LIKE '%?1%'")
	List<Student> getByName(String name);
}

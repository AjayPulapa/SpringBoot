package com.mss.task.jpacrud;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class JPAStudentService {
	@Autowired
	JPAStudentRepository studentRepository;
//Inserting the Data

	public Student insertStudent(Student student) {
		try {
			studentRepository.save(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

//Inserting the Multiple Rows in a Database
	public List<Student> insertMultiple(List<Student> student) {
		return studentRepository.saveAll(student);
	}
//Updating the Data

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
//Getting the Details of the Table

	public List getStudentData(Student student) {
		return studentRepository.findAll();
	}
//Getting the Details By Id

	public Optional<Student> getElementsbyId(Student student) {
		int sid = student.getId();
		return studentRepository.findById(sid);
	}
//Delete By Id

	 @CacheEvict(value = "StudentDemo", allEntries = true)
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "deleted";
	}

	public List<Student> getByAge(int age) {
		return studentRepository.getByAge(age);
	}

	public List<Student> getByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.getByName(name);
	}

}

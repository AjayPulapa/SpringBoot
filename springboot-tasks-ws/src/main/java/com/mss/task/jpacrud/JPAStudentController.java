package com.mss.task.jpacrud;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
@RestController
@RequestMapping("/jpacrud")
public class JPAStudentController {
	@Autowired
	JPAStudentService studentService;

//Insert the Data
	@PostMapping("/student")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}

//Insert the Multiple Records
	@PostMapping("/students")
	public List<Student> insertMultiple(@RequestBody List<Student> student) {
		return studentService.insertMultiple(student);
	}

//Update the records
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

//Getting Data
	@GetMapping("/student")
	public List getStudentData(Student student) {
		return studentService.getStudentData(student);
	}

//Fetch By ID
	@GetMapping("/student/id")
	public Optional<Student> getElementsbyId(@RequestBody Student student) {
		return studentService.getElementsbyId(student);
	}

//Delete the Records
	@DeleteMapping("/student")
	public String deleteStudent(@RequestBody int id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/getByAge/{age}")
	public List<Student> getByAge(@PathVariable int age) {
		return studentService.getByAge(age);
	}
	@GetMapping("/getByName/{name}")
	public List<Student> getByName(@PathVariable String name) {
		return studentService.getByName(name);
	}
}

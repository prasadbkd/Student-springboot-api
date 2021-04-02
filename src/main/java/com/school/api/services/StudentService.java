package com.school.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.api.model.Student;
import com.school.api.repository.StudentDao;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDao dao;
	
	public Student saveStudent(Student student) {
		Student s = dao.save(student);
		if(s!=null)
			return s;
		else
			return null;
	}

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		dao.findAll().forEach(p->students.add(p));
		
			return students;
		
	}

	public Student getStudent(int id) {

		Optional<Student> s = dao.findById(id);
		if(s.isPresent()) {
			Student st = s.get(); 
		System.out.println(st.getFname()+st.getLname());
		return st;
		}
		else 
			return null;
		
	}

	public Student updateStudent(Student student,int id) {
		student.setId(id);
		dao.save(student);
		return student;
	}

	public String deleteStudent(int id) {

		Student s = getStudent(id);
		if(s!=null) {
			dao.deleteById(id);
			return "sucess";}
			else
				return "fail";
		
	}

}

package com.visog.pasupukumkuma.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.pasupukumkuma.dao.master.StudentDao;
import com.visog.pasupukumkuma.model.master.Student;
import com.visog.pasupukumkuma.req.StudentReq;
import com.visog.pasupukumkuma.res.StudentRes;
import com.visog.pasupukumkuma.service.master.StudentService;
import com.visog.pasupukumkuma.utils.DaoUtils;


public class StudentServiceImpl implements StudentService {

	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Inject
	StudentDao dao;
	
	public void saveStudent(StudentReq req) {
		
		Student student=new Student();
		student.setName(req.getName());
		student.setEmail(req.getEmail());
		student.setPassword(req.getPassword());
		
		
		
	}

	
	public void updateStudent(StudentReq req, String studentId) {
	
		Student student = (Student) dao.getByKey(Student.class, studentId);
		student.setName(req.getName());
		student.setEmail(req.getEmail());
		student.setPassword(req.getPassword());
		dao.update(student);
		logger.info("Student updated successfully : " + student.getId());
		
	}

	
	public List<StudentRes> getStudent() {
	
		List<Student> student = dao.getStudents();

		List<StudentRes> studentList = new ArrayList<>();
		StudentRes studentRes = null;

		for (Student student1 : student) {
			studentRes = new StudentRes();
			studentRes.setId(student1.getId());
			studentRes.setName(student1.getName());
			studentRes.setEmail(student1.getEmail());
			studentRes.setPasword(student1.getPassword());
			
			studentList.add(studentRes);
		}

		return studentList;
		
	}

	
	public StudentRes getStudent(String id) {
		
		Student student = (Student) dao.getByKey(Student.class, id);
		StudentRes studentRes = new StudentRes();
		studentRes.setId(student.getId());
		studentRes.setName(student.getName());
		studentRes.setEmail(student.getEmail());
		studentRes.setPasword(student.getPassword());
		return studentRes;
		
	}


	public Boolean deleteStudent(String studentId) {

		return (dao.delete(Student.class, studentId) != 0);
	}

}

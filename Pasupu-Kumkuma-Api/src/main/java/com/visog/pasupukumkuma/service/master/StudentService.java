package com.visog.pasupukumkuma.service.master;

import java.util.List;

import com.visog.pasupukumkuma.req.StudentReq;
import com.visog.pasupukumkuma.res.StudentRes;

public interface StudentService {

public void saveStudent(StudentReq req);
	
	public void updateStudent(StudentReq req, String studentId);
	
	public List<StudentRes> getStudent();
	
	public StudentRes getStudent(String id);
	
	public Boolean deleteStudent(String studentId);
	
}

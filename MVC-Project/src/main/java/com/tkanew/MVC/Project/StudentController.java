package com.tkanew.MVC.Project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@Autowired
	SessionFactory sf;

	@RequestMapping("/")
	public String jspCall() {
		return "student";
	}

	@RequestMapping("/student")
	public Student saveRecord(Student student) {
		Session ss = sf.openSession();
		Transaction tx = ss.beginTransaction();
		ss.save(student);
		tx.commit();
		System.out.println(student);
		return student;
	}

}

package com.example.demo.controller;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.repo.Student;
import com.example.demo.repo.StudentJpa;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	
	StudentController(){}
	
	Map<String,Student> allUsers = new HashMap<>();

	@Autowired
	StudentJpa sjp;
	
	@GetMapping("/students")
	public Collection<Student> getStudentDetails()
	{
		System.out.println("api called from front end");
		sjp.findAll().stream().forEach(System.out::println);
		return sjp.findAll();
	}

	@GetMapping(path="/student/{id}")
	public Optional<Student> getStudentsByID(@PathVariable int id)
	{
		System.out.println("inside getstudnet by id");
		return sjp.findById(id);	
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student studentDetails)
	{
		Boolean ind = false;
		sjp.getMobile().stream().forEach(System.out::println);

		for (String s : sjp.getMobile()) {
			if(s==null)
				continue;
		if(s.equalsIgnoreCase(studentDetails.getMobile()))
		{
			ind = true;
			return "User Exist";
		}
	}
		if(!ind)
		{
			sjp.save(studentDetails);
			return "User Added";
		}
		return null;


    }
	
	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable int id,@RequestBody Student studentDetails)
	{
		Boolean ind = true;
		for(int Studentid:sjp.getID())
		{
			if(studentDetails.getId()==Studentid) {
				ind = false;
				sjp.updateRow(studentDetails.getMail(), studentDetails.getMobile(), studentDetails.getName(),studentDetails.getId());
				return "Updated Successfully";
			}
		}
		if(ind)
		{
			return "User Not Exist or Invalid Student ID";
		}
		return null;

	}	
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		sjp.deleteById(id);
		return "Student record deleted successfully";

	}

}

package com.exampleProject.SrpingBootCrud.controller;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exampleProject.SrpingBootCrud.Repository.StudentRepo;
import com.exampleProject.SrpingBootCrud.entity.Student;

import jakarta.websocket.server.PathParam;

@RestController
public class StudentController {

	@Autowired
	StudentRepo stsRepo;
	@PostMapping("/api/students")
	public Student saveStudent(@RequestBody Student std)  //@RequestBody fill it neccesaary 
	{
		return stsRepo.save(std);
	}
	@GetMapping("/api/getStudent")
	public List<Student> getAll()
	{
		return stsRepo.findAll();
	}
	@GetMapping("/api/getStudent/{id}")
	public Student getStudent(@PathVariable("sid") int sid)
	{
		Optional<Student>std=stsRepo.findById(sid);
		if(std.isPresent())
		{
			return std.get();
		}
		return null;
	}
//	@PutMapping("/api/update/{id}")
//	public Student updateStudent(@PathVariable("id") int id,@RequestBody Student stu)
//	{
//		Optional<Student>std=stsRepo.findById(id);
//		if(std.isPresent())
//		{
//			std.get().setSname("kvr");
//			std.get().setsAddress("Bez");
//			stsRepo.save(stu);
//		}
//		return null;
//	}
	@PutMapping("/api/update/{id}")
	public Student updateStudent(@PathVariable("sid") int sid,@RequestBody Student stu)
	{
		Optional<Student>std=stsRepo.findById(sid);
		if(std.isPresent())
		{
			std.get().setSname(stu.getSname());
			std.get().setsAddress(stu.getsAddress());
			stsRepo.save(stu);
		}
		return null;
	}
	@DeleteMapping("/api/delete/{sid}")
	public Student deleteStudent(@PathVariable("sid") int sid,@RequestBody Student stud)
	{
		Optional<Student>std=stsRepo.findById(sid);
		if(std.isPresent())
		{
			stsRepo.deleteById(sid);
			return stud;
		}
		return null;
	}
}

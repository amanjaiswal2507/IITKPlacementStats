package com.Aman.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.Aman.dao.StudentRepo;
import com.Aman.demo.model.Student;


@Controller
public class StudentController 
{
	@Autowired
	StudentRepo repo;
	
	@RequestMapping("/")
	 public String home()
	 {
		return "home";
		
	 }
	@RequestMapping("/posting")
	 public String home1()
	 {
		return "register.html";
		
	 }
	@GetMapping("/fetching")
	 public ModelAndView home2()
	 {
		ModelAndView mv=new ModelAndView("forfetch.html");
		return mv;
	 }
	@GetMapping("/fetchbyname")
	 public ModelAndView home3()
	 {
		ModelAndView mv=new ModelAndView("getbyname.html");
		return mv;
	 }
	@GetMapping("/addStudent")
	public ModelAndView addStudent(Student student)
	{
		repo.save(student);
		
		ModelAndView mv=new ModelAndView("finalstepofpost.html");
		return mv;
	}
	@GetMapping("/deleting")
	public ModelAndView home7()
	{
		ModelAndView mv=new ModelAndView("fordelete.html");
		return mv;
	}
	@GetMapping("/updating")
	public ModelAndView home8()
	{
		ModelAndView mv=new ModelAndView("updatepage.html");
		return mv;
	}
	@GetMapping("/gallery")
	public ModelAndView home9()
	{
		ModelAndView mv=new ModelAndView("Gallery.html");
		return mv;
	}
	@GetMapping("/developer")
	public ModelAndView home10()
	{
		ModelAndView mv=new ModelAndView("developer.html");
		return mv;
	}
	
	@GetMapping("/getbyname")
	public ModelAndView getbyname(@RequestParam String name)
	{
		ModelAndView mv=new ModelAndView("showStudent.jsp");
		Student student=repo.findById(name).orElse(new Student());
		mv.addObject(student);
		return mv;
	}
	 @GetMapping(path="/Students")
	 @ResponseBody
	 public List<Student> getrestStudents()
	 {
		 return repo.findAll();
	 }
	 
	 @RequestMapping("fetchbyname/Students/{name}")
	 @ResponseBody 
     public Optional<Student> getrestStudent(@PathVariable("name") String name)
    {
			return repo.findById(name);			
     }
	 @PostMapping("/Student")
	 @ResponseBody
	 public Student poststudent(@RequestBody Student alien)
	 {		 
		 repo.save(alien);		 
		 return alien;
	 }
	 
	 @DeleteMapping("/Student/{name}")
	 @ResponseBody
	 public String deleterestStudent(@PathVariable String name)
	 {
		 Student a=repo.getOne(name);
		 repo.delete(a);
		 return "deleted";
	 }
	 
	 @RequestMapping("/deletestudent")
	 public ModelAndView deleteStudent(@RequestParam String name)
	 {
		 Student alien=repo.findById(name).orElse(new Student());
		 repo.delete(alien);
		 ModelAndView mv=new ModelAndView("finalstepofdelete.html");	
		 return mv;
	 }
	 
	@RequestMapping("/updatestudent")
	 public ModelAndView saveaurupdateALien(Student alien)
	 {		
		 repo.save(alien);		 
		 ModelAndView mv=new ModelAndView("finalpageupdate.html");
		 return mv;
	 } 
	 
	 @PutMapping("/Student")
	 @ResponseBody
	 public Student saveorupdateALien(@RequestBody Student alien)
	 {
		
		 repo.save(alien);
		 
		 return alien;
	 } 
	 
}

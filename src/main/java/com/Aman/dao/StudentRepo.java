package com.Aman.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aman.demo.model.Student;




public interface StudentRepo extends JpaRepository<Student,String>
{
		
}

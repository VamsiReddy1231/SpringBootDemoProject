package com.exampleProject.SrpingBootCrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleProject.SrpingBootCrud.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}

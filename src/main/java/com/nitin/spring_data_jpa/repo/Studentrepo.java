package com.nitin.spring_data_jpa.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.nitin.spring_data_jpa.entity.Student;
import java.util.List;


public interface Studentrepo extends  CrudRepository<Student,Integer>{

    List<Student> findByName(String name);

    List<Student> findByMarks(Integer marks);

    List<Student> findByNameAndMarksGreaterThanEqual(String name,Integer marks);

    List<Student>  findByMarksLessThanEqual(Integer marks);

    @Query("from Student")//hql
    List<Student> getAllStudents(); 

    @Query(value = "select * from Student",nativeQuery =true)//sql
    List<Student> getStudents(); 

    @Query("from Student where marks>=100")
    List<Student> getStudentsWithMarksGreaterThan100();

    @Query(" select name from Student where marks<=:x ")
    List<String> getStudentNamesWithMarks(Integer x);
}
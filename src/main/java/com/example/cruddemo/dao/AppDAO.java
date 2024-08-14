package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instruction);
    Instructor findInstructorById(int id);

 void  deleteInstructorById(int id);

 InstructorDetail findInstructorDetailById(int id);

 void deleteInstructorDetailById(int id);
}

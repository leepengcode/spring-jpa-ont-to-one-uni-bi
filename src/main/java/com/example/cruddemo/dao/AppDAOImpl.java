package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instruction) {
        entityManager.persist(instruction);

    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);

    }

    @Override
    @Transactional
    public void  deleteInstructorById(int id) {

        // Retrieve the instruction
       Instructor instructor = entityManager.find(Instructor.class, id);

        // If instruction is not found, throw an exception  else delete it.
        if (instructor == null) {
            throw new NoSuchElementException("Instructor not found with ID: " + id);
        }
        // delete instructor by id
           entityManager.remove(instructor);


    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail detail = entityManager.find(InstructorDetail.class, id);

        // remove the associated like
        detail.getInstructor().setInstructorDetail(null);

        entityManager.remove(detail);


    }


}

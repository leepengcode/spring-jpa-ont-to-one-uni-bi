package com.example.cruddemo;

import com.example.cruddemo.dao.AppDAO;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.NoSuchElementException;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//            createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructorById(appDAO);

//            findInstructorDeletailById(appDAO);
            deleteInstructorDeletailById(appDAO);
        };
    }

    private void deleteInstructorDeletailById(AppDAO appDAO) {
        int id = 4;
        System.out.println("Attempting to delete instructor detail with id " + id);

        appDAO.deleteInstructorDetailById(id);
        System.out.println("Instructor Detail deleted with id " + id);
    }

    private void findInstructorDeletailById(AppDAO appDAO) {
        int id = 3;
        System.out.println("Attempting to find instructor detail with id " + id);

        InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
        System.out.println("Instructor Detail : " + instructorDetail);
        System.out.println("Instructor : " + instructorDetail.getInstructor());
    }

    private void deleteInstructorById(AppDAO appDAO) {
        // Assuming instructor with id 9 exists in the database.
        int id = 2;
        System.out.println("Attempting to delete instructor with id " + id);

        // check if the instructor not found
        try {
            appDAO.deleteInstructorById(id);
            System.out.println("Instructor deleted with id " + id);
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Find instructor " + id );

        Instructor instructor= appDAO.findInstructorById(id);

        System.out.println("Instructor : " + instructor);
        System.out.println("Instructor Detail : " + instructor.getInstructorDetail());



    }


    private void createInstructor(AppDAO appDAO) {

        // create the instructor
        Instructor instructor = new Instructor(
                "Lii", "Peng", "peng@gmail.com" );

        // create the instructor_detail

        InstructorDetail instructorDetails = new InstructorDetail(
                "http://www.peng.com/youtube","Codding"
        );
       /*

        Instructor instructor = new Instructor(
                "Lii", "Suu", "suu@gmail.com" );

        // create the instructor_detail

        InstructorDetail instructorDetails = new InstructorDetail(
                "http://www.peng.com/youtube","Running"
        );

 */
        // associate the object
        instructor.setInstructorDetail(instructorDetails);

        // save the instructor
        //
        // This will save the details of the instructor
        // because of CasCadeType.All
        //
        System.out.println("Saving Instructor : " + instructor);
        appDAO.save(instructor);

        System.out.println("DONE");





    }


}

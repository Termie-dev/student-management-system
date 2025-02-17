package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// JPA (Java Persistence API) makes it easy to use Spring-powered apps that use data access technologies
@Repository
public interface StudentRepository 
        extends JpaRepository<Student, Long> { // Student: Entity class that repo will manage. Long: Type of primary key Id

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);    
}

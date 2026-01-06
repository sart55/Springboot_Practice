package com.spring.example.cruddemo.DAO;

import com.spring.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public Void save(Student theStudent) {
        entityManager.persist(theStudent);
        return null;
    }

    @Override
    public Student retrive(int ID) {
         return entityManager.find(Student.class,ID);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Student update(int ID) {
        Student theStudent = entityManager.find(Student.class,ID);
        theStudent.setFirstName("Sarthak");
        entityManager.merge(theStudent);
        return theStudent;
    }

    @Override
    @Transactional
    public Void remove(int ID) {
        Student stu = entityManager.find(Student.class,ID);
        entityManager.remove(stu);
        return null;
    }

    @Override
    @Transactional
    public Void removeAll(){
        Query st = entityManager.createQuery("DELETE FROM Student");
        int rows = st.executeUpdate();
        return null;
    }


}
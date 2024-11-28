package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager em;

    @Autowired
    public AppDAOImpl(EntityManager e) {
        this.em = e;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.merge(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = em.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();

        for(Course c: courses){
            c.setInstructor(null);
        }

        em.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return em.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = em.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        em.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = em.createQuery(
                "from Course where instructor.id = :data", Course.class
        );
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = em.createQuery(
                "SELECT i FROM Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail WHERE i.id = :data", Instructor.class
        );

        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        em.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        em.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = em.find(Course.class, id);
        em.remove(course);
    }


}

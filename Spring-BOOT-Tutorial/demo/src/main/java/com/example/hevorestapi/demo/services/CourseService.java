package com.example.hevorestapi.demo.services;

import java.util.List;

import com.example.hevorestapi.demo.entities.Course;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long id);

    public Course createCourse(Course course);

    public void deleteCourse(long parseLong);

    public Course updateCourse(long parseLong, Course course);

}

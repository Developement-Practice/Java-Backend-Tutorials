package com.example.hevorestapi.demo;

import java.util.List;

import com.example.hevorestapi.demo.entities.Course;
import com.example.hevorestapi.demo.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired // This means to get the bean called courseService
    private CourseService courseService;

    @GetMapping(value = "/home")
    public String index() {
        return "Welcome to Courses API";
    }

    // Get all courses
    @GetMapping(value = "/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    // Get a course by id
    @GetMapping(value = "/courses/{id}")
    public Course getCourse(@PathVariable("id") String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    // Create a course
    @PostMapping(value = "/courses", consumes = "application/json")
    public Course createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    // Update a course
    @PostMapping(value = "/courses/{id}", consumes = "application/json")
    public Course updateCourse(@PathVariable("id") String courseId, @RequestBody Course course) {
        return this.courseService.updateCourse(Long.parseLong(courseId), course);
    }

    // Delete a course
    @DeleteMapping(value = "/courses/{id}")
    public void deleteCourse(@PathVariable("id") String courseId) {
        this.courseService.deleteCourse(Long.parseLong(courseId));
    }

}

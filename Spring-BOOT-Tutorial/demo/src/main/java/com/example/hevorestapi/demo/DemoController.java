package com.example.hevorestapi.demo;

import java.util.List;

import com.example.hevorestapi.demo.entities.Course;
import com.example.hevorestapi.demo.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired // This means to get the bean called courseService
    private CourseService courseService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
        return "Welcome to Courses API";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }
}

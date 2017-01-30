package com.udemy.converter;

import org.springframework.stereotype.Component;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	//Entity --> Model
	public CourseModel entity2model(Course course){
		CourseModel cm = new CourseModel();
		cm.setName(course.getName());
		cm.setDescription(course.getDescription());
		cm.setPrice(course.getPrice());
		cm.setHours(course.getHours());
		return cm;
	}
	
	//Model --> Entity
	public Course model2entity(CourseModel courseModel){
		Course c = new Course();
		c.setName(courseModel.getName());
		c.setDescription(courseModel.getDescription());
		c.setPrice(courseModel.getPrice());
		c.setHours(courseModel.getHours());
		return c;
	}
}

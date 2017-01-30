package com.udemy.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log log = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	CourseConverter courseConverter;
	
	@Override
	public List<CourseModel> listAllCourses() {
		log.info("listAllCourses");
		List<CourseModel> result = new ArrayList<>();
		 for (Course item : courseJpaRepository.findAll())
			 result.add(courseConverter.entity2model(item));
		 return result;
	}

	@Override
	public CourseModel addCourse(CourseModel course) {
		log.info("addCourse: " + course.toString());
		return courseConverter.entity2model(courseJpaRepository.save(courseConverter.model2entity(course)));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel course) {
		return courseConverter.entity2model(courseJpaRepository.save(courseConverter.model2entity(course)));
	}

}

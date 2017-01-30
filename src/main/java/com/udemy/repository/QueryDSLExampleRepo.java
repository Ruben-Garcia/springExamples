package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find(boolean exist){
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
	
		if (exist){
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		}else{
			Predicate predicate2 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate2);
		}
		
		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();
		Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}

}

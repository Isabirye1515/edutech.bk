package org.edutech;

import java.util.List;

import org.edutech.Student.services.StudentService;
import org.edutech.Student.valueholder.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String driver = context.getEnvironment().getProperty("DB_DRIVER");
        System.out.println("Resolved DB_DRIVER: " + driver);

        Object ds = context.getBean("dataSource");
        System.out.println("DataSource bean loaded: " + ds);
        StudentService studentService = context.getBean( StudentService.class);
        List<Student> students = studentService.getAllStudents();
        students.forEach(s -> System.out.println(s.getFirstName()));
    }
    
}

import model.Student;
import service.report.ReportService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.StudentDAO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // The following code initializes this project using the Spring configuration in applicationContext.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Using the JdbcTemplate to query for a student in the database
        StudentDAO studentDAO = context.getBean(StudentDAO.class);
        Student student = studentDAO.getStudentById(12345);


        System.out.println("Using queryForObject method from JdbcTemplate to query studentID=12345: ");
        if (student != null) {
            System.out.println(student.toString());
        }

        // Using the JdbcTemplate to query for all students in the database
        System.out.println("\n" +
                "Using the query method from JdbcTemplate to query all students: ");
        List<Student> allStudents = studentDAO.getAllStudents();
        for (Object stud : allStudents) {
            System.out.println(stud.toString());
        }

        System.out.println("\n-----Implementation of ReportService----- ");
        ReportService reportService = context.getBean(ReportService.class);
        reportService.printReport(System.out);

    }
}

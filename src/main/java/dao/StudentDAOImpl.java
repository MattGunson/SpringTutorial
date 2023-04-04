package dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import model.Student;

@Component
public class StudentDAOImpl implements StudentDAO {
	private JdbcTemplate jdbcTemplate;

	public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Student getStudentById(int id) {
		try {
		return jdbcTemplate.queryForObject("SELECT * From Students WHERE Students.studentID="+id+";", new BeanPropertyRowMapper<>(Student.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		return jdbcTemplate.query("SELECT * From Students;", new BeanPropertyRowMapper<>(Student.class));
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}

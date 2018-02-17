package ajs.server;

import java.util.UUID;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentMysqlDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public StudentMysqlDao (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public String addStudent(String meno, String priezvisko) throws StudentExists_Exception {
		String uuid = null;
		if (getId(meno, priezvisko) != null) {
			throw new StudentExists_Exception("Student exists.", new StudentExists());
		}
		
		String sqlAdd = "INSERT INTO Student (UUID, meno, priezvisko) VALUES (?,?,?);";
		uuid = UUID.randomUUID().toString();
		Object[] params = {uuid, meno, priezvisko};
		jdbcTemplate.update(sqlAdd, params);	
		return uuid;
	}

	private Object getId(String meno, String priezvisko) {
		String sqlGet = "SELECT UUID FROM Student WHERE meno = ? AND priezvisko = ?;";
		Object[] params = {meno, priezvisko};
		try {
			String uuid = (String) jdbcTemplate.queryForObject(sqlGet, params, String.class);
			return uuid;
		} catch (EmptyResultDataAccessException e) {
			return null;
}
	}	
}

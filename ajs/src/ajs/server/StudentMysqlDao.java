package ajs.server;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentMysqlDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public StudentMysqlDao (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public long addStudent(String meno, String priezvisko) {
		long id = 0;
		String sqlAdd = "INSERT INTO Student (meno, priezvisko) VALUES (?,?);";
		Object[] params = {meno, priezvisko};
		int ok = jdbcTemplate.update(sqlAdd, params);
		if (ok == 1) {
			String sqlGet = "SELECT id FROM Student WHERE meno = ? AND priezvisko = ?;";
			id = jdbcTemplate.queryForLong(sqlGet, params);
		}		
		return id;
	}	
}

package ajs.server;

import org.springframework.jdbc.core.JdbcTemplate;
import com.mysql.cj.jdbc.MysqlDataSource;

public enum Factory {
	INSTANCE;
	
	String url = "jdbc:mysql://localhost:3306/kopr?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
	String username = "java";
	String password = "password";
	
	private StudentMysqlDao studentMysqlDao = null;
	
	private Factory() {
		JdbcTemplate jdbcTemplate = connection();
		studentMysqlDao = new StudentMysqlDao(jdbcTemplate);
	}

	public JdbcTemplate connection() {		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		
		return new JdbcTemplate(dataSource);
	}
	
	
	public StudentMysqlDao getStudentMysqlDao() {
		return studentMysqlDao;
	}
}

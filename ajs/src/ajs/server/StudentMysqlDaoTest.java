package ajs.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

class StudentMysqlDaoTest {

	@Test
	void test() throws StudentExists_Exception {
		 
		JdbcTemplate jdbcTemplate = Factory.INSTANCE.connection();
		String sql = "SELECT COUNT(*) FROM Student";
		
		int before = jdbcTemplate.queryForInt(sql);
		String UUID = Factory.INSTANCE.getStudentMysqlDao().addStudent("Peter", "Petrovsky");		
		int after = jdbcTemplate.queryForInt(sql);
		
		if(before+1 == after) {
			String delete = "DELETE FROM Student WHERE UUID = ?;";
			Object[] params = {UUID};
			jdbcTemplate.update(delete, params);
		}
		assertEquals(before+1, after);
	}

}

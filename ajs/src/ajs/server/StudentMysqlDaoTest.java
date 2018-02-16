package ajs.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

class StudentMysqlDaoTest {

	@Test
	void test() {
		 
		JdbcTemplate jdbcTemplate = Factory.INSTANCE.connection();
		String sql = "SELECT COUNT(*) FROM Student";
		
		int before = jdbcTemplate.queryForInt(sql);
		long id = Factory.INSTANCE.getStudentMysqlDao().addStudent("Anicka", "Mila");		
		int after = jdbcTemplate.queryForInt(sql);
		
		if(before+1 == after) {
			String delete = "DELETE FROM Student WHERE id = ?;";
			Object[] params = {id};
			jdbcTemplate.update(delete, params);
		}
		assertEquals(before+1, after);
	}

}

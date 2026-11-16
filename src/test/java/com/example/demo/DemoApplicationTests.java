package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:ar_ecologico;MODE=MSSQLServer;DB_CLOSE_DELAY=-1",
		"spring.datasource.driver-class-name=org.h2.Driver",
		"spring.datasource.username=sa",
		"spring.datasource.password=",
		"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
		"spring.jpa.hibernate.ddl-auto=update"
})
class DemoApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void createsAllSqlTablesAndForeignKeysFromJpaMappings() {
		Integer tableCount = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES "
						+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME IN "
						+ "('PESSOAS', 'PESSOAS_FISICAS', 'PESSOAS_JURIDICAS', "
						+ "'PRESTADOR_SERVICOS', 'CONTRATOS', 'EQUIPAMENTOS', "
						+ "'CONTRATOS_EQUIPAMENTOS', 'ORDENS_SERVICOS', 'SERVICOS', "
						+ "'SERVICOS_REALIZADOS')",
				Integer.class);
		Integer foreignKeyCount = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS "
						+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND CONSTRAINT_TYPE = 'FOREIGN KEY'",
				Integer.class);
		Integer checkConstraintCount = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS "
						+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND CONSTRAINT_TYPE = 'CHECK'",
				Integer.class);
		Integer uniqueConstraintCount = jdbcTemplate.queryForObject(
				"SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS "
						+ "WHERE TABLE_SCHEMA = 'PUBLIC' AND CONSTRAINT_TYPE = 'UNIQUE'",
				Integer.class);

		assertEquals(10, tableCount);
		assertEquals(13, foreignKeyCount);
		assertEquals(3, checkConstraintCount);
		assertEquals(2, uniqueConstraintCount);
	}
}

# AR_ECOLOGICO

## SQL Server and automatic schema management

Spring Boot connects to SQL Server using `DB_URL`, `DB_USERNAME`, and
`DB_PASSWORD` environment variables. `DB_URL` defaults to
`jdbc:sqlserver://localhost:1433;databaseName=bdtestespring;encrypt=true;trustServerCertificate=true`.
The SQL Server database (`bdtestespring` by default) must already exist and the
configured user must have permission to create and alter tables.

For PowerShell, set the connection values before starting the application:

```powershell
$env:DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=bdtestespring;encrypt=true;trustServerCertificate=true"
$env:DB_USERNAME = "your-sql-server-user"
$env:DB_PASSWORD = "your-sql-server-password"
.\mvnw.cmd spring-boot:run
```

In VS Code, choose **Run and Debug → Run DemoApplication (SQL Server)**. The
launch profile prompts for the SQL Server username and password without saving
them in the workspace.

Hibernate uses `spring.jpa.hibernate.ddl-auto=update` to generate and update
tables, columns, keys, and relationships from the JPA entities without
dropping existing tables. The SQL file is a structural reference and is not
executed by the application. Review a backup and test schema changes against a
non-production database first; Hibernate's `update` mode is not a substitute
for a versioned database migration when making destructive or complex changes.
# MonitorSensors

<h3>Configuration and database init</h3>
1. Set data about database in application.properties file: url, username and password
2. Use schema.sql file from resources for init database with enums data.
3. Run application.

<h3>Information about API</h3>
This REST API has the main features for work with Sensor entity
For check API use SWAGGER UI: http://localhost:8080/swagger-ui/index.html

Admin: admin:admin

User: user:user


<h3>ISSUE</h3>
Have problem with auth in postman, GET calls work without auth and another calls return 401 code.

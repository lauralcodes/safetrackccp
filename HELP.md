# Getting Started

## Configuration via environment variables

This app is configured using environment variables (recommended for secrets).

Required for running with PostgreSQL:
- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

Optional (defaults exist for local dev):
- `ADMIN_USERNAME`, `ADMIN_PASSWORD` (set these to seed an admin user)
- `JWT_SECRET`, `JWT_TTL_SECONDS`

Example (macOS/Linux):
```bash
export SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/ccp_db"
export SPRING_DATASOURCE_USERNAME="ccp_user"
export SPRING_DATASOURCE_PASSWORD="your_password"
export JWT_SECRET="$(openssl rand -base64 32)"
./mvnw spring-boot:run
```

If you don’t have PostgreSQL running locally, you can start the app with an in-memory H2 database:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

Dev profile seeds an admin user by default:
- username: `admin`
- password: `admin123`

## Docker + Koyeb + Neon (overview)

- Create a Neon Postgres database and copy the connection details from Neon (host, database, user, password).
- Do not commit secrets: keep credentials in environment variables (and use Koyeb Secrets for passwords).
- Deploy to Koyeb from GitHub using the repository `Dockerfile`.
- Set these Koyeb environment variables (use Secrets for passwords):
  - `SPRING_DATASOURCE_URL=jdbc:postgresql://<neon-host>/<db>?sslmode=require&channelBinding=require`
  - `SPRING_DATASOURCE_USERNAME=<neon-user>` (do not put `user=` in the JDBC URL)
  - `SPRING_DATASOURCE_PASSWORD=<neon-password>` (do not put `password=` in the JDBC URL)
  - `JWT_SECRET=<at least 32 bytes>` (example: output of `openssl rand -base64 32`)
  - (optional) `ADMIN_USERNAME` + `ADMIN_PASSWORD`
- Koyeb provides `PORT`; the app reads it via `server.port=${PORT:8080}`.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.5/maven-plugin/build-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/4.0.5/reference/web/servlet.html)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

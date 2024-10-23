# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot Docs](https://docs.spring.io/spring-boot/index.html)

#### Frontend

* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Thymeleaf Layout Dialect](https://ultraq.github.io/thymeleaf-layout-dialect/)
* [Tailwindcss](https://tailwindcss.com/docs/installation)
* [HTMX](https://htmx.org/docs/)
* [Alpins.js](https://alpinejs.dev/start-here)
* [Thymeleaf - Module for Java 8 Time API compatibility](https://github.com/thymeleaf/thymeleaf-extras-java8time#installation)

### Running the Application in dev mode

1. start any stopped containers
2. exceute the following commands

```shell
./gradlew -t bootJar
```

```shell
npx tailwindcss -i ./src/main/resources/frontend/input.css -o ./src/main/resources/static/style.css --watch
```

```shell
./gradlew bootRun
```

3. turn on your Livereload browser extension
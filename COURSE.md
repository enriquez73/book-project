# Spring Boot Interview Course

Stack:

- Java 21
- Spring Boot
- Maven
- PostgreSQL
- Spring Data JPA / Hibernate
- Flyway
- MapStruct
- Spring Security
- JUnit 5
- Testcontainers
- Docker
- IntelliJ IDEA Ultimate 2026

Architecture:

- Feature-based
- No Lombok
- Request / Response DTO separation

---

# Lesson 1 - Spring Boot Fundamentals ✅

- [x] SpringApplication.run()
- [x] ApplicationContext
- [x] @SpringBootApplication
- [x] Component Scan
- [x] Auto Configuration
- [x] Bean
- [x] IoC
- [x] Dependency Injection
- [x] Constructor Injection
- [x] @Service
- [x] @RestController
- [x] @RequestMapping
- [x] @GetMapping
- [x] @RequestParam
- [x] @Configuration
- [x] @Bean
- [x] CommandLineRunner

---

# Lesson 2 - Spring Data JPA 🚧

- [x] @GeneratedValue and UUID
- [x] Optional<T>
- [x] findById()
- [x] findByIsbn()
- [x] existsByIsbn()
- [x] save()
- [x] delete()
- [x] Entity lifecycle
- [x] Hibernate Persistence Context
- [x] Dirty Checking
- [x] @Transactional
- [x] Transaction rollback rules
- [x] Transaction propagation basics
- [x] Spring transactional proxy
- [x] Self-invocation problem

---

# Lesson 3 - API & DTO

- [x] BookResponse
- [x] Entity -> Response mapping
- [x] CreateBookRequest
- [x] UpdateBookRequest
- [x] Bean Validation
- [x] MapStruct
- [x] ResponseEntity
- [x] Custom exceptions
- [x] @RestControllerAdvice
- [x] @ExceptionHandler
- [x] HTTP 409 Conflict
- [x] Bean Validation error handling

---

# Lesson 4 - Database
- [x] PostgreSQL
- [ ] Docker Compose
- [x] Flyway
- [x] V1 migration
- [x] flyway_schema_history
- [x] Hibernate ddl-auto=validate
- [x] Database constraints
- [x] UNIQUE constraint
- [x] Application uniqueness check vs DB constraint
- [x] Race condition on uniqueness checks
- [ ] Relationships
- [ ] Author
- [ ] Category

---

# Lesson 5 - Security 🚧

- [x] Spring Security fundamentals
- [x] SecurityFilterChain concept
- [x] Authentication vs Authorization
- [x] SecurityContext / SecurityContextHolder
- [x] Roles vs Authorities
- [x] HTTP 401 vs 403
- [x] Stateless authentication concept
- [x] JWT / Bearer Token concept
- [x] OAuth2 Resource Server concept
- [x] CSRF basics for stateless APIs
- [ ] Spring Security implementation
- [ ] SecurityFilterChain implementation
- [ ] JWT implementation
- [ ] Roles / Authorities mapping
- [ ] Method Security / @PreAuthorize

---

# Lesson 6 - Testing

- [ ] JUnit 5
- [ ] Mockito
- [ ] @SpringBootTest
- [ ] Repository Tests
- [ ] Controller Tests
- [ ] Testcontainers
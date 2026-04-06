# 📏 QuantityMeasurementApp

> A Java application developed using Test-Driven Development (TDD) to progressively design and refine a quantity measurement system. The project emphasizes incremental development, clean object-oriented design, and progressive architectural refactoring to build a flexible and maintainable domain model over time.

### 📖 Overview

- Modular Java project focused on modelling multi-category quantity measurements (length, weight, and volume) with full arithmetic and conversion support.
- Organized around incremental Use Cases evolving from simple equality checks to a scalable, capability-aware measurement architecture.
- Emphasizes clarity, consistency, and maintainable structure as the system grows.

### ✅ Implemented Features

> _Features will be added here as Use Cases are implemented._
- 🧩 **UC1 – Feet Equality :**
  - Implements value-based equality for feet measurements using an overridden `equals()` method.
  - Establishes object equality semantics as the foundation for future unit comparisons.

- 🧩 **UC2 – Inches Equality :**
  - Extends value-based equality comparison to inches measurements using a dedicated `Inches` class.
  - Maintains independent unit validation while reinforcing equality behaviour across measurement types.

- 🧩 **UC3 – Generic Length :**
  - Refactors unit-specific classes into a unified `Length` abstraction using a `LengthUnit` enum.
  - Eliminates duplicated logic by applying the DRY principle while enabling cross-unit equality comparison.

- 🧩 **UC4 – Extended Unit Support :**
  - Adds Yards and Centimeters to the `LengthUnit` enum with appropriate conversion factors.
  - Demonstrates scalability of the generic design by enabling seamless cross-unit equality without introducing new classes.

- 🧩 **UC5 – Unit-to-Unit Conversion :**
  - Introduces explicit conversion operations between supported length units using centralized enum conversion factors.
  - Extends the `Length` API to convert measurements across units while preserving mathematical equivalence and precision.

- 🧩 **UC6 – Length Addition Operation :**
  - Introduces addition between length measurements with automatic unit normalization and conversion.
  - Returns a new immutable `Length` result expressed in the unit of the first operand while preserving mathematical accuracy.

- 🧩 **UC7 – Addition with Target Unit Specification :**
  - Extends length addition to allow explicit specification of the result unit independent of operand units.
  - Enhances API flexibility by enabling arithmetic results to be expressed in any supported unit while preserving immutability and precision.

- 🧩 **UC8 – Standalone Unit Refactor :**
  - Extracts `LengthUnit` into a standalone enum responsible for all unit conversion logic.
  - Improves architectural separation by delegating conversions to units, reducing coupling and enabling scalable support for future measurement categories.

- 🧩 **UC9 – Weight Measurement Support :**
  - Introduces a weight measurement category with `Weight` and `WeightUnit` supporting kilograms, grams, and pounds.
  - Enables equality, conversion, and addition operations for weight while preserving strict separation from length measurements and stabilizing the shared measurement architecture.

- 🧩 **UC10 – Generic Quantity Architecture :**
  - Introduces a generic `Quantity<U extends IMeasurable>` model enabling multiple measurement categories through a shared abstraction.
  - Eliminates category-specific duplication by unifying equality, conversion, and addition logic into a single scalable architecture.

- 🧩 **UC11 – Volume Measurement Support :**
  - Adds a new measurement category using `VolumeUnit` (Litre, Millilitre, Gallon) implemented through the generic `Quantity<U>` architecture.
  - Validates that new measurement types integrate without modifying existing quantity logic, proving true multi-category scalability.

- 🧩 **UC12 – Subtraction and Division Operations :**
  - Introduces subtraction between quantities with automatic cross-unit normalization while preserving immutability.
  - Adds division support producing a dimensionless ratio, enabling comparative analysis across measurements of the same category.

- 🧩 **UC13 – Centralized Arithmetic Logic (DRY Refactor) :**
  - Refactors addition, subtraction, and division to use a centralized arithmetic helper, eliminating duplicated validation and conversion logic.
  - Improves maintainability and scalability while preserving all existing behaviour and public APIs.

- 🧩 **UC14 – Temperature Measurement (Selective Arithmetic Support) :**
  - Introduces temperature measurements using `TemperatureUnit` integrated into the generic `Quantity<U>` architecture.
  - Supports equality comparison and unit conversion across Celsius, Fahrenheit, and Kelvin using non-linear conversion formulas.
  - Refactors `IMeasurable` with default capability validation to allow category-specific operation support.
  - Prevents unsupported arithmetic operations (addition, subtraction, division) through explicit validation and meaningful exceptions.
  - Demonstrates Interface Segregation and capability-based design while preserving backward compatibility for length, weight, and volume.

- 🧩 **UC15 – N-Tier Architecture Refactoring :**
  - Refactors the Quantity Measurement Application from a monolithic design into a structured **N-Tier architecture**.
  - Introduces layered separation including **Controller, Service, Repository, Model, Entity, DTO, Interfaces, and Units** packages.
  - Moves business logic into the **Service layer**, while the **Controller layer** manages application interaction and orchestration.
  - Adds a **Repository layer with a cache-based storage implementation** to record measurement operations.
  - Standardizes data flow using **QuantityDTO for external transfer**, **QuantityModel for internal processing**, and **QuantityMeasurementEntity for persistence**.
  - Improves **modularity, testability, maintainability, and extensibility**, preparing the system for future integration with **REST APIs or database storage**.

- 🧩 **UC16 – Database Integration with JDBC for Quantity Measurement Persistence :**
  - Extends the N-Tier architecture established in UC15 with **persistent relational database storage** using **JDBC (Java Database Connectivity)**.
  - Introduces `QuantityMeasurementDatabaseRepository` as a full JDBC-based replacement for the in-memory `QuantityMeasurementCacheRepository`, enabling long-term data persistence across application restarts.
  - Adds `ApplicationConfig` utility class that loads all database configuration from `application.properties`, supporting environment-specific settings for **development, testing, and production**.
  - Introduces `ConnectionPool` utility class that manages a pool of reusable JDBC connections for efficient resource usage.
  - Extends `IQuantityMeasurementRepository` interface with four new methods: `getMeasurementsByOperation()`, `getMeasurementsByType()`, `getTotalCount()`, and `deleteAll()`.
  - Adds `DatabaseException` to the custom exception hierarchy, with static factory methods for structured database error handling.
  - Adopts **parameterized SQL queries** (`PreparedStatement`) throughout the database repository to prevent SQL injection attacks.
  - Migrates all `System.out.println` logging to **Java's built-in `java.util.logging` (JUL)** framework via SLF4J and Logback.
  - Uses **H2 embedded database** by default with the ability to switch to MySQL or PostgreSQL via `application.properties`.
  - Adds integration tests (`QuantityMeasurementIntegrationTest`) and unit tests for each layer using H2 in-memory database.
  - Demonstrates enterprise-level practices including **connection pooling, transaction awareness, resource cleanup with try-finally, and environment-specific database profiles**.

- 🧩 **UC17 – Spring Boot Integration with REST Services and JPA Persistence :**
  - Migrates the entire application from a standalone JDBC-based design to a **Spring Boot REST service** while preserving all domain models and business logic from UC1–UC16.
  - Introduces `QuantityMeasurementApplication` as the **Spring Boot entry point** with `@SpringBootApplication` and `@OpenAPIDefinition` for application metadata.
  - **Replaces manual JDBC repositories** (`QuantityMeasurementDatabaseRepository`, `QuantityMeasurementCacheRepository`, `ApplicationConfig`, `ConnectionPool`) with **Spring Data JPA** — `QuantityMeasurementRepository` extending `JpaRepository<QuantityMeasurementEntity, Long>`.
  - `QuantityMeasurementRepository` defines derived-query methods: `findByOperation`, `findByThisMeasurementType`, `findByCreatedAtAfter`, `countByOperationAndErrorFalse`, `findByErrorTrue`, and a custom `@Query` method `findSuccessfulByOperation`.
  - **Refactors the package layout** — introduces three distinct packages: `entity` for JPA-mapped database classes (`QuantityMeasurementEntity`), `dto` for API request/response objects (`QuantityDTO`, `QuantityInputDTO`, `QuantityMeasurementDTO`), and `model` for pure domain/business objects (`Quantity`, `QuantityModel`, `OperationType`).
  - **Refactors `QuantityDTO`** to include Bean Validation annotations (`@Data`, `@NotNull`, `@NotEmpty`, `@Pattern`, `@AssertTrue`) enforcing input integrity at the API boundary.
  - Introduces **`QuantityMeasurementDTO`** as a structured API response object with static factory methods: `fromEntity()`, `toEntity()`, `fromEntityList()`, and `toEntityList()` using the Java Stream API for efficient collection mapping.
  - Adds **`QuantityInputDTO`** to encapsulate the two-operand input structure accepted by all POST endpoints.
  - Introduces **`OperationType` enum** with constants `ADD`, `SUBTRACT`, `MULTIPLY`, `DIVIDE`, `COMPARE`, and `CONVERT` for type-safe operation representation throughout the application.
  - **Exposes RESTful API endpoints** through `QuantityMeasurementController` using `@RestController` and `@RequestMapping("/api/v1/quantities")`:
    - `POST /compare`, `/convert`, `/add`, `/subtract`, `/divide` — accept `QuantityInputDTO`, return `QuantityMeasurementDTO`.
    - `GET /history/operation/{operation}`, `/history/type/{measurementType}`, `/history/errored` — return `List<QuantityMeasurementDTO>`.
    - `GET /count/{operation}` — returns operation count.
  - Adds **Swagger/OpenAPI annotations** (`@Operation`, `@Tag`, `@Parameter`) on all controller methods to generate interactive API documentation.
  - Implements **centralized exception handling** via `GlobalExceptionHandler` (`@ControllerAdvice`) with handlers for `MethodArgumentNotValidException`, `QuantityMeasurementException`, and general `Exception` — returning structured JSON error responses with timestamp, status, error type, message, and path.
  - **Removes `DatabaseException`** — exception handling is now managed declaratively through `GlobalExceptionHandler` and Spring's exception translation layer.
  - Adds **`SecurityConfig`** in a dedicated `config` package preparing the system for Spring Security integration; currently permits all requests for development and testing.
  - Supports **environment-based configuration** through `application.properties` (H2, development) and `application-prod.properties` (MySQL, production), replacing the custom `ApplicationConfig` and manual property loading from UC16.
  - **HikariCP** is used as the default connection pool (auto-configured by Spring Boot), replacing the manual `ConnectionPool` implementation from UC16.
  - **Schema is managed by JPA auto-DDL** (`spring.jpa.hibernate.ddl-auto=create-drop` in dev), replacing the explicit `schema.sql` from UC16.
  - Adds **Spring Boot Actuator** for monitoring via `/actuator/health`, `/actuator/info`, and `/actuator/metrics`.
  - Adds comprehensive **Spring Boot testing**:
    - `QuantityMeasurementControllerTest` — controller unit tests using `@WebMvcTest` and `MockMvc`.
    - `QuantityMeasurementApplicationTests` — full-stack integration tests using `@SpringBootTest` and `TestRestTemplate`.
    - `QuantityMeasurementServiceIntegrationTest` — service-layer integration tests using `@SpringBootTest`.
    - `QuantityMeasurementRepositoryTest` — Spring Data JPA repository tests.
  - Demonstrates migration from **JDBC-based persistence (UC16)** to a modern **Spring Boot + JPA enterprise architecture** while maintaining the original measurement logic and full test coverage.

### 🧰 Tech Stack

- **Java 17+** — core language and application development  
- **Maven** — build automation and dependency management  
- **JUnit 5** — unit testing framework supporting TDD workflow

### ▶️ Build / Run

 - Build the project:
  
    ```
    mvn clean install
    ```

- Run tests:
    
    ```
    mvn test
    ```

### 📂 Project Structure

```
  📦 QuantityMeasurementApp
  │
  ├── 📁 src
  │   ├── 📁 main
  │   │   └── 📁 java
  │   │       └── 📁 quantitymeasurement
  │   │           ├── 📄 IMeasurable.java
  │   │           ├── 📄 Quantity.java
  │   │           ├── 📄 LengthUnit.java
  │   │           ├── 📄 WeightUnit.java
  │   │           ├── 📄 VolumeUnit.java
  │   │           ├── 📄 TemperatureUnit.java
  │   │           ├── 📄 SupportsArithmetic.java
  │   │           └── 📄 QuantityMeasurementApp.java
  │   │
  │   └── 📁 test
  │       └── 📁 java
  │           └── 📁 quantitymeasurement
  │               ├── 📄 TestQuantityManagementapp.java
  │
  ├── ⚙️ pom.xml
  ├── 🚫 .gitignore
  ├── 📜 LICENSE
  └── 📘 README.md
```

### ⚙️ Development Approach

 > This project follows an incremental **Test-Driven Development (TDD)** workflow:

- Tests are written first to define expected behaviour.
- Implementation code is developed to satisfy the tests.
- Each Use Case introduces new functionality in small, controlled steps.
- Existing behaviour is preserved through continuous refactoring.
- Design evolves toward clean, maintainable, and well-tested software.
- Later use cases introduce capability-based behavior where different measurement categories support different operations safely.

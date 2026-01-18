<div align="center">

# 🚀 Notes API - Spring Boot Backend

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.x-C71A36.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

**API RESTful para gestión de notas construida con Spring Boot**

[Características](#-características) • [Instalación](#-instalación) • [API Reference](#-api-reference) • [Estructura](#-estructura-del-proyecto)

</div>

---

## 🎯 Descripción

**Notes API** es un backend robusto desarrollado con **Spring Boot 3** que proporciona una API RESTful para la gestión de notas. Utiliza JPA/Hibernate para la persistencia de datos y está diseñado siguiendo las mejores prácticas de arquitectura en capas.

### ¿Por qué este proyecto?

- 🎓 **Aprendizaje**: Implementación práctica de Spring Boot moderno
- 🏗️ **Arquitectura limpia**: Separación clara de responsabilidades
- 📊 **JPA/Hibernate**: ORM moderno para persistencia
- 🔄 **RESTful**: API bien diseñada siguiendo estándares REST
- 🚀 **Production-ready**: Listo para despliegue

---

## ✨ Características

- ✅ **API RESTful** - Endpoints bien definidos y documentados
- ✅ **Spring Data JPA** - Acceso a datos simplificado
- ✅ **H2 Database** - Base de datos en memoria para desarrollo
- ✅ **CORS configurado** - Comunicación segura con frontend
- ✅ **Arquitectura en capas** - Controller → Repository → Entity
- ✅ **Hot Reload** - Desarrollo ágil con Spring DevTools
- ✅ **Maven** - Gestión de dependencias robusta
- ✅ **JSON Serialization** - Conversión automática de objetos

---

## 🛠 Tecnologías

| Tecnología | Versión | Descripción |
|-----------|---------|-------------|
| ![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk) | 21 | Lenguaje de programación |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=spring) | 3.x | Framework backend |
| ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.x-green?logo=spring) | 3.x | Persistencia de datos |
| ![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?logo=apache-maven) | 3.x | Gestión de dependencias |
| ![H2](https://img.shields.io/badge/H2-2.x-blue) | 2.x | Base de datos en memoria |
| ![Hibernate](https://img.shields.io/badge/Hibernate-6.x-59666C?logo=hibernate) | 6.x | ORM Framework |

---

## 🏗 Arquitectura

```
┌─────────────────────────────────────────┐
│         Spring Boot Application         │
│                                         │
│  ┌───────────────────────────────────┐  │
│  │      @RestController              │  │
│  │      NoteController               │  │
│  │  - @GetMapping                    │  │
│  │  - @PostMapping                   │  │
│  │  - @CrossOrigin                   │  │
│  └───────────────────────────────────┘  │
│                 │                       │
│                 ▼                       │
│  ┌───────────────────────────────────┐  │
│  │      @Repository                  │  │
│  │      NoteRepository               │  │
│  │  - extends JpaRepository          │  │
│  │  - CRUD operations                │  │
│  └───────────────────────────────────┘  │
│                 │                       │
│                 ▼                       │
│  ┌───────────────────────────────────┐  │
│  │      @Entity                      │  │
│  │      Note                         │  │
│  │  - @Id @GeneratedValue            │  │
│  │  - Getters/Setters                │  │
│  └───────────────────────────────────┘  │
└─────────────────────────────────────────┘
                 │
          JPA/Hibernate
                 │
                 ▼
        ┌─────────────────┐
        │   H2 Database   │
        │   (In-Memory)   │
        └─────────────────┘
```

---

## 📦 Instalación

### Prerrequisitos

Asegúrate de tener instalado:

- ☕ **Java JDK 21** o superior - [Descargar](https://www.oracle.com/java/technologies/downloads/)
- 🔧 **Maven 3.x** - [Descargar](https://maven.apache.org/download.cgi)

### 🚀 Instalación Rápida

#### 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/notes-api.git
cd notes-api
```

#### 2️⃣ Compilar el proyecto

```bash
mvn clean install
```

#### 3️⃣ Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

### Verificar que funciona

```bash
# Obtener todas las notas
curl http://localhost:8080/api/notes

# Crear una nota
curl -X POST http://localhost:8080/api/notes \
  -H "Content-Type: application/json" \
  -d '{"text":"Mi primera nota"}'
```

---

## 📡 API Reference

### Base URL
```
http://localhost:8080/api/notes
```

### Endpoints

#### 📋 Obtener todas las notas

```http
GET /api/notes
```

**Response:**
```json
[
  {
    "id": 1,
    "text": "Mi primera nota"
  },
  {
    "id": 2,
    "text": "Recordar comprar leche"
  }
]
```

**Status Codes:**
- `200 OK` - Operación exitosa

---

#### ➕ Crear una nota

```http
POST /api/notes
Content-Type: application/json
```

**Request Body:**
```json
{
  "text": "Nueva nota"
}
```

**Response:**
```json
{
  "id": 3,
  "text": "Nueva nota"
}
```

**Status Codes:**
- `200 OK` - Nota creada exitosamente
- `400 Bad Request` - Datos inválidos

---

### Códigos de Estado HTTP

| Código | Descripción |
|--------|-------------|
| `200` | ✅ Operación exitosa |
| `201` | ✅ Recurso creado |
| `400` | ❌ Petición incorrecta |
| `404` | ❌ Recurso no encontrado |
| `500` | ❌ Error del servidor |

---

## 📁 Estructura del Proyecto

```
notes-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/notes_api/
│   │   │   ├── Note.java                 # Entidad JPA
│   │   │   ├── NoteRepository.java       # Repositorio
│   │   │   ├── NoteController.java       # Controlador REST
│   │   │   └── NotesApiApplication.java  # Clase principal
│   │   │
│   │   └── resources/
│   │       ├── application.properties    # Configuración
│   │       └── static/                   # Recursos estáticos
│   │
│   └── test/
│       └── java/com/example/notes_api/
│           └── NotesApiApplicationTests.java
│
├── target/                               # Archivos compilados
├── .mvn/                                 # Maven wrapper
├── mvnw                                  # Maven wrapper (Unix)
├── mvnw.cmd                              # Maven wrapper (Windows)
├── pom.xml                               # Dependencias Maven
└── README.md                             # Este archivo
```

### Componentes Principales

#### 📄 **Note.java** - Entidad JPA

```java
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String text;
    
    // Constructors, Getters, Setters
}
```

**Anotaciones:**
- `@Entity` - Marca la clase como entidad JPA
- `@Id` - Define la clave primaria
- `@GeneratedValue` - Auto-incremento del ID

---

#### 🗄️ **NoteRepository.java** - Repositorio

```java
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // Métodos heredados:
    // - findAll()
    // - save(note)
    // - deleteById(id)
    // - findById(id)
}
```

**Spring Data JPA** proporciona automáticamente:
- CRUD completo
- Paginación
- Ordenamiento
- Queries personalizadas

---

#### 🎮 **NoteController.java** - Controlador REST

```java
@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {
    
    private final NoteRepository repository;
    
    public NoteController(NoteRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Note> getAllNotes() {
        return repository.findAll();
    }
    
    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return repository.save(note);
    }
}
```

**Anotaciones:**
- `@RestController` - Combina @Controller + @ResponseBody
- `@RequestMapping` - Define la ruta base
- `@CrossOrigin` - Habilita CORS para el frontend
- `@GetMapping` - Maneja peticiones GET
- `@PostMapping` - Maneja peticiones POST
- `@RequestBody` - Convierte JSON a objeto Java

---

## 🔧 Configuración

### application.properties

```properties
# Puerto del servidor
server.port=8080

# Configuración H2 Database
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:notesdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Acceder a H2 Console

1. Navega a: `http://localhost:8080/h2-console`
2. JDBC URL: `jdbc:h2:mem:notesdb`
3. Username: `sa`
4. Password: *(vacío)*

---

## 🔄 CORS Configuration

El CORS está configurado para permitir peticiones desde el frontend Angular:

```java
@CrossOrigin(origins = "http://localhost:4200")
```

Para producción, actualiza la URL:

```java
@CrossOrigin(origins = "https://tu-frontend.com")
```

O configura CORS globalmente en una clase de configuración:

```java
@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}
```

---

## 🚀 Build y Despliegue

### Build de Producción

```bash
# Compilar sin ejecutar tests
mvn clean package -DskipTests

# Compilar con tests
mvn clean package
```

El archivo JAR se generará en `target/notes-api-0.0.1-SNAPSHOT.jar`

### Ejecutar JAR

```bash
java -jar target/notes-api-0.0.1-SNAPSHOT.jar
```

### Despliegue en Heroku

```bash
# Crear aplicación
heroku create notes-api-backend

# Configurar buildpack de Java
heroku buildpacks:set heroku/java

# Desplegar
git push heroku main

# Ver logs
heroku logs --tail
```

### Despliegue en Railway

```bash
# Instalar Railway CLI
npm i -g @railway/cli

# Login
railway login

# Inicializar proyecto
railway init

# Desplegar
railway up
```

---

## 📝 Scripts Maven Disponibles

```bash
# Compilar el proyecto
mvn compile

# Ejecutar tests
mvn test

# Empaquetar (crear JAR)
mvn package

# Limpiar archivos compilados
mvn clean

# Instalar en repositorio local
mvn install

# Ejecutar la aplicación
mvn spring-boot:run

# Compilar sin tests
mvn clean install -DskipTests
```

---

## 🧪 Testing

### Ejecutar Tests

```bash
mvn test
```

## 🔍 Características de Spring Boot 3

Este proyecto utiliza las últimas características de Spring Boot:

- ✅ **Java 21** - Última versión LTS de Java
- ✅ **Spring Boot 3.x** - Framework moderno
- ✅ **Jakarta EE** - Nuevo namespace (jakarta.*)
- ✅ **Native Compilation** - Soporte para GraalVM
- ✅ **Observability** - Métricas y trazas mejoradas

---

## 📊 Dependencias (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Starter Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Spring Boot DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
</dependencies>
```

---

## 📚 Recursos de Aprendizaje

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Hibernate ORM](https://hibernate.org/orm/)
- [Maven Guide](https://maven.apache.org/guides/)
- [H2 Database](https://www.h2database.com/)

---

## 🐛 Troubleshooting

### Puerto 8080 en uso

```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Linux/Mac
lsof -i :8080
kill -9 <PID>
```

### Cambiar puerto

En `application.properties`:
```properties
server.port=8081
```

---

## 👨‍💻 Autor

**Oriol Farràs**

- GitHub: [@Oriol-Farras](https://github.com/Oriol-Farras)

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

---

## 🙏 Agradecimientos

- [Spring Team](https://spring.io/)
- [Hibernate Team](https://hibernate.org/)
- [H2 Database](https://www.h2database.com/)

---

<div align="center">

**⭐ Si te ha gustado este proyecto, dale una estrella! ⭐**

Hecho con ❤️ por [Oriol Farràs](https://github.com/Oriol-Farras)

</div>

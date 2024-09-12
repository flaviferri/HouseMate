HouseMate 🏠


Índice

Proyecto 📝


Requisitos previos


Diagramas

Diagrama de flujo

Diagrama de datos

Instalación 🛠️

Requerimientos

Estructura del proyecto

Tecnologías
Uso
Contribución 🤝
Coder 👩‍💻
Proyecto 📝
HouseMate es una aplicación web diseñada para la gestión completa de actividades relacionadas con la administración de casas. Permite a los usuarios gestionar tareas, gastos y compras comunes. La aplicación incluye autenticación de usuarios y permite manejar registros de actividades y propiedades con operaciones CRUD (Crear, Leer, Actualizar, Eliminar).

Requisitos previos
Funcionalidades:

Registro de usuarios con correo electrónico y contraseña.
Inicio de sesión para usuarios autenticados.
Ver, añadir, editar y eliminar tareas, propiedades, y gastos.
Validación de formularios y gestión de errores.
Cambios en la navegación basados en el estado de autenticación del usuario.
Búsqueda por nombre de tarea o ubicación.
Alertas para operaciones CRUD y acceso.
Diagramas
Diagrama de flujo
Para entender la lógica de la aplicación, se ha diseñado un diagrama de flujo.

Ver diagrama de flujo

Diagrama de datos
La base de datos está normalizada a segunda forma, con tablas para usuarios, tareas, propiedades, y categorías.

Ver diagrama de datos

Instalación 🛠️
Requerimientos
Node.js
Visual Studio Code con la extensión Java Pack, IntelliJ o tu IDE de preferencia.
PostgreSQL o una base de datos similar.
Clona los repositorios:
Front-end:


Back-end:

bash
Copiar código
git clone https://github.com/flaviferri/HouseMate-BackEnd

Pasos de instalación:

Crea tu base de datos y conéctala al repositorio del back-end modificando el archivo application.properties con tu url, usuario, y contraseña de PostgreSQL.
Estructura del proyecto
El proyecto se divide en front-end y back-end. La estructura del back-end con Spring Boot y PostgreSQL sigue el patrón MVC de tres capas:

bash

Copiar código
/
├── houseMate-back
│   ├── .mvn/
│   ├── src/
│   │    ├── main/
│   │    │     ├── java/com/houseMate/houseMate/
│   │    │     │      ├── config/
│   │    │     │      │      ├── ApplicationConfig.java
│   │    │     │      │      └── SecurityConfig.java
│   │    │     │      ├── controllers/
│   │    │     │      │      ├── AuthController.java
│   │    │     │      │      ├── AuthResponse.java
│   │    │     │      │      ├── FlatController.java
│   │    │     │      │      ├── LoginRequest.java
│   │    │     │      │      ├── RegisterRequest.java
│   │    │     │      │      ├── TaskController.java
│   │    │     │      │      └── TenatController.java
│   │    │     │      ├── dto/
│   │    │     │      ├── jwt/
│   │    │     │      │      └── JwtAuthenticacionFilter.java
│   │    │     │      ├── models/
│   │    │     │      │      ├── BaseEntity.java
│   │    │     │      │      ├── Category.java
│   │    │     │      │      ├── Flat.java
│   │    │     │      │      ├── Status.java
│   │    │     │      │      ├── Task.java
│   │    │     │      │      └── User.java
│   │    │     │      ├── repositories/
│   │    │     │      │      ├── ICategoryRepository.java
│   │    │     │      │      ├── IFlatRepository.java
│   │    │     │      │      ├── IStatusRepository.java
│   │    │     │      │      ├── ITaskRepository.java
│   │    │     │      │      └── UserRepository.java
│   │    │     │      ├── role/
│   │    │     │      │      └── Role.java
│   │    │     │      ├── services/
│   │    │     │      │      ├── AuthService.java
│   │    │     │      │      ├── FlatService.java
│   │    │     │      │      ├── IFlatService.java
│   │    │     │      │      ├── ITaskService.java
│   │    │     │      │      ├── JwtService.java
│   │    │     │      │      ├── TaskService.java
│   │    │     │      │      └── UserService.java
│   │    │     │      └── HouseMateApplication.java
│   │    └── resources/
│   │          └── application.properties  
│   ├── test/
│   ├── .gitignore
│   ├── mvnw
│   ├── mvnw.cmd
│   └── pom.xml
Tecnologías


Back-end
Java
PostgreSQL
Spring Boot
Spring Security
Sasss
Uso

Compila primero el back-end:

Da al botón de play en tu IDE para iniciar el servidor.

Abre el enlace proporcionado con tu puerto local.
Contribución 🤝

Haz un fork del repositorio.
Crea una nueva rama: git checkout -b feature/nombre-rama.
Haz tus cambios.
Haz push de tu rama: git push origin feature/nombre-rama.
Crea un pull request.
Coder 

La coder que ha trabajado en este proyecto es:

Flavia Ferrigno

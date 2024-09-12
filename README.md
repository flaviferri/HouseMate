
# HouseMate 🏠


HouseMate is a web application designed for the comprehensive management of house administration activities. It allows users to manage tasks, expenses, and common purchases. The application includes user authentication and enables handling of activity and property records with CRUD operations (Create, Read, Update, Delete).para el CSS partiendo de prototipos dados por el cliente, como toda la parte del Back con Java SpringBoot y PostgreSQL.


## Prerequisites
Functionalities:

- User registration with email and password.
- Login for authenticated users.
- View, add, edit, and delete tasks, properties, and expenses.
- Form validation and error management.
- Navigation changes based on user authentication status.
- Search by task name or location.
- Alerts for CRUD operations and access.


## Installation 🛠️

- Node.js
- Visual Studio Code with the Java Pack extension, IntelliJ, or your preferred IDE.
- PostgreSQL or a similar database.


1. Clone the repositories:


```bash

Back:
 git clone https://github.com/flaviferri/HouseMate.git

```


2.Create your database and connect it to the back repo:
```
put the access link, your pgAdmin or your DB username and password in the application.resources file

```




## Project structure



The backend of the project was done with Java SpringBoot, with a 3-layer MVC architecture.

The final structure of the back is as follows:

```plaintext
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

└── README.md

```

## Technologies




**Back**
- [Java](https://www.java.com)
- [PgAdmin](https://www.pgadmin.org/)+ [SQL](https://www.w3schools.com/sql/default.asp)
- [SpringBoot](https://spring.io/projects/spring-boot)



## Use

The program must be started in the back first.

To compile:

```
Press play to compile automatically.

```

Once the back has started, on the front:

```
npm run dev
```

Open the link that appears with your local port.


## Contribution 🤝

1. Fork the repository.
2. Create a new branch: `git checkout -b feature/name`.
3. Make your changes.
4. Push your branch: `git push origin feature/name`.
5. Create a pull request.

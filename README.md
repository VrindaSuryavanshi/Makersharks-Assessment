


# Implemented endpoints for a RESTful API using Spring Boot,MongoDB Atlas
## Steps to Setup

**1. Clone the application**

```bash
https://github.com/VrindaSuryavanshi/Makersharks-Assessment.git
```

**2. Create database using MongoDb Atlas**
```bash
create database user-registration-api-database
create collection user-registration
```

**3. Change mongodb username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change spring.data.mongodb.uri as per your mongodb installation

**4. Build and run the app using maven**

 you can run the app without packaging it using -

```bash
mvn spring-boot:run on cmd
```

The app will start running at <http://localhost:8082>.

## Explore Rest APIs

The app defines following  APIs.
    
(this is public accessible api)

POST  /api/user/register

(below 2 are need username and password to access. storage mechanism => in-memory storage) 

GET 
/getAllUsers

GET
/api/user/fetch/{username}

## Document the API using Swagger :

You can find the Document using Swagger for this application on 
<http://localhost:8082/swagger-ui/index.html>


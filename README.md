# MSA CRUD with JWT

This guide explains how to create a **Jakarta EE MicroProfile CRUD Application** secured with **JWT (JSON Web Token)** authentication. It covers project creation, database configuration, JWT setup, REST Client configuration, and deployment using **Payara Micro**.

---

# Prerequisites

Before starting, make sure you have the following installed:

- Java JDK 17 or later
- Apache Maven
- NetBeans IDE (or IntelliJ/Eclipse)
- Payara Micro
- MySQL Database
- MySQL Connector JAR (`mysql-connector-java-8.0.20.jar`)
- Postman (Optional)
- JWTenizr (`jwtenizr.jar`)

---

# Project Structure

Create the following two projects:

```
MSAResource
MSAClient
```

---

# Step 1: Create the Projects

Create a new **Java Maven Project**.

- Choose **Project Archetype**
- Search for **MicroProfile**
- Select **jakarta-9-microprofile**

---

# Step 2: Create Two Projects

Create the following projects:

- `MSAResource`
- `MSAClient`

---

# Step 3: Update Dependencies

Open the `pom.xml` file of both projects and update the versions.

### Jakarta EE

From:

```xml
<version>9.0.0</version>
```

To:

```xml
<version>10.0.0</version>
```

### MicroProfile

From:

```xml
<version>4.1</version>
```

To:

```xml
<version>6.0</version>
```

---

# Step 4: Replace Packages

Use **Find and Replace** throughout both projects.

Replace:

```java
javax
```

With:

```java
jakarta
```

---

# Step 5: Configure Database

Inside the **MSAResource** project:

- Create `persistence.xml`
- Configure the database connection
- Configure the connection pool

---

# Step 6: Create User Entity

Create an entity class named:

```java
User
```

with the following fields:

```text
id
name
email
phone
```

---

# Step 7: Create CRUD Operations

Create CRUD operations using **EJB**.

Example operations:

- Create User
- Get User
- Update User
- Delete User

---

# Step 8: Create Service Class

Create a service class.

```java
UserService.java
```

This class will contain the business logic for CRUD operations.

---

# Step 9: Apply Authorization

Protect REST APIs using:

```java
@RolesAllowed("chief")
```

---

# Step 10: Configure JWT Authentication

Inside `Bootstrap.java`, add the following annotations:

```java
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"chief","admin"})
```

---

# Step 11: Create Configuration File

Navigate to:

```
src
 └── main
      └── resources
            └── META-INF
```

Create the following file:

```
microprofile-config.properties
```

---

# Step 12: Configure Static JWT

Configure Static JWT authentication.

---

# Step 13: Generate JWT Token

Download:

```
jwtenizr.jar
```

Run the following command:

```bash
java -jar jwtenizr.jar
```

---

# Step 14: Copy JWT Token

Copy the generated JWT token from:

```
token.jwt
```

Also copy the required configuration into:

```
microprofile-config.properties
```

---

# Step 15: Create REST Client

Inside **MSAClient**, create the following interface.

```java
UserClient
```

Configure it as follows:

```java
@RegisterRestClient(
    baseUri = "http://localhost:8085/MSAResource/rest/user"
)
```

---

# Step 16: Attach JWT Token in Every Request

Add the following annotations:

```java
@ClientHeaderParam(
    name = "Authorization",
    value = "{getToken}"
)

@RolesAllowed("chief")
```

Create the following helper method:

```java
default String getToken() {

    Config config = ConfigProvider.getConfig();

    String token =
            "Bearer " +
            config.getValue("jwt", String.class);

    return token;
}
```

This method automatically attaches the JWT token to every REST request.

---

# Step 17: Create Configuration File in Client

Inside:

```
src/main/resources/META-INF
```

Create:

```
microprofile-config.properties
```

---

# Step 18: Paste JWT Token

Inside `microprofile-config.properties`, add:

```properties
jwt=<Token copied from token.jwt>
```

---

# Step 19: Use UserClient in Servlet

Inside the servlet:

- Inject the REST Client
- Call CRUD methods
- Trigger methods based on user events

---

# Step 20: Deploy the Projects

## Deploy MSAResource

```bash
java -jar payara.jar \
--deploy MSAResource/artifact/MSAResource.war \
--port 8085 \
--addlibs mysql-connector-java-8.0.20.jar \
--domainconfig domain.xml
```

---

## Deploy MSAClient

```bash
java -jar payara.jar \
--deploy MSAClient/src/artifact/MSAClient.war \
--port 8086
```

---

# Deployment Order

1. Start MySQL
2. Deploy **MSAResource**
3. Deploy **MSAClient**
4. Open the application in your browser or Postman.
5. Test CRUD APIs using JWT authentication.

---

# Technologies Used

- Jakarta EE 10
- Eclipse MicroProfile 6
- Maven
- EJB
- JPA (Persistence)
- JWT Authentication
- REST Client
- Payara Micro
- MySQL
- Java

---

# Project Flow

```text
Client
   │
   │ HTTP Request
   ▼
MSAClient
   │
   │ REST Client + JWT Token
   ▼
MSAResource
   │
   │ CRUD Operations
   ▼
UserService
   │
   ▼
JPA (Persistence)
   │
   ▼
MySQL Database
```

---

# Author

**Muhammad Shakil Patel**
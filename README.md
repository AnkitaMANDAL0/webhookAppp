# BFH Qualifier Spring Boot Application

**Created by:** Ankita 

**GitHub ID:** [AnkitaMANDAL0]((https://github.com/AnkitaMANDAL0)  
**Email:**ankita1069.be22@chitkarauniversity.edu.in  

## Description

Spring Boot application that implements the BFH qualifier workflow:
1. Sends POST request to generate webhook with user credentials
2. Parses response to extract webhook URL and JWT token
3. Generates placeholder SQL query
4. Sends final POST request to webhook URL with authorization

## Prerequisites

- Java 17+
- Maven 3.6+

### Install (macOS)
```bash
brew install openjdk@17 maven
export JAVA_HOME=/opt/homebrew/opt/openjdk@17
```

## Build & Run

```bash
# Build
mvn clean install

# Run
mvn spring-boot:run

# Create JAR
mvn package

# Run JAR
java -jar target/bfh-qualifier-1.0.0.jar
```

## Project Structure

```
├── pom.xml
├── README.md
└── src/main/
    ├── java/com/bajaj/health/
    │   ├── BfhQualifierApp.java
    │   └── service/WebhookService.java
    └── resources/application.yml
```

## Output

```
Starting BFH Qualifier Application...
Author: Ankita (GitHub: AnkitaMANDAL0)
Email: ankita1069.be22@chitkarauniversity.edu.in

=================================================
BFH Qualifier Application
Created by: Ankita
GitHub ID: AnkitaMANDAL0
Email: ankita1069.be22@chitkarauniversity.edu.in
=================================================

Step 1: Sending POST request to generate webhook...
Step 2: Parsing response to extract webhook URL and access token...
Step 3: Generating placeholder SQL query...
Step 4: Sending final POST request to webhook URL...

=================================================
Workflow completed by: Ankita (AnkitaMANDAL0)
=================================================
```

## Contact

**Email:** ankita1069.be22@chitkarauniversity.edu.in  
**GitHub:** [AnkitaMANDAL0](https://github.com/AnkitaMANDAL0) 

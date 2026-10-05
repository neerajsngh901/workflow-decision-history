# Workflow Decision History

## Description
The **Workflow Decision History** project is a Spring Boot application designed to manage and store decision history for workflows. It provides GraphQL APIs for querying and mutating decision history records.

## Features
- Store decision history with details such as case ID, decision, user ID, remarks, and timestamp.
- Query decision history by case ID.
- GraphQL support for flexible API interactions.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **GraphQL**: API query language.
- **MySQL**: Database for storing decision history.
- **Lombok**: Simplifies Java code with annotations.
- **Maven**: Dependency management.

## Prerequisites
- Java 17 or higher
- Maven 3.8+
- MySQL database

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
    ```
2. CURL FOR processDecisionHistory
    ```bash
    curl --location 'http://localhost:8081/graphql' \--header 'Content-Type: application/json' \--data '{"query":"mutation {\r\n  processDecisionHistory(\r\n        decision: \"INI\"\r\n        userId: \"neeraj\"\r\n        caseId: \"123\"\r\n    \r\n       \r\n    ) {\r\n    decisionId\r\n    decision\r\n    userId\r\n    caseId\r\n    remarks\r\n    dateTime\r\n    \r\n  }\r\n}","variables":{}}'
    ```
3. CURL FOR getDecisionHistoryByCaseId
    ```bash
    curl --location 'http://localhost:8081/graphql' \--header 'Content-Type: application/json' \--data '{"query":" query {\r\n    getDecisionHistory(\r\n        caseId: \"123\"\r\n    ){\r\n    decisionId\r\n    decision\r\n    userId\r\n    caseId\r\n    remarks\r\n    dateTime\r\n    \r\n  }\r\n }","variables":{}}'
   ```
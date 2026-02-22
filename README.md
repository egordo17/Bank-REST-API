A robust Spring Boot RESTful web service designed to manage core banking operations. 
This project simulates a banking environment where users can manage customers, accounts, cards, and track financial transactions.

FeaturesCustomer Management: 
  - Create and retrieve customer profiles.
  - Account Operations: Manage bank accounts, check statuses, and link them to customers.
Card Services: 
  - Issue and manage cards associated with accounts.
Transaction Tracking: 
  - Record and monitor deposits, withdrawals, and transfers.
In-Memory Persistence: 
  - Utilizes a custom fakeDataBase.java to simulate data storage without the need for an external SQL setup.
  
Technology StackFramework: 
  - Spring BootLanguage 
JavaBuild Tool: 
  - Maven
Architecture:
  - Layered (Controller -> Service -> Model/Database)
  
Project Structure: 
  - The project follows a standard Spring Boot package structure, controllers handle incoming HTTP requests (e.g., AccountContoller.java, CustomerController.java) whil
  Services Contain business logic (e.g., TransactionService.java).
  
Models: 
  - Define data structures (e.g., Account.java, Card.java).
Data:
- Managed via fakeDataBase.java.
  
Getting Started
  - PrerequisitesJava 17 or higherMaven 3.6+Installation & RunClone the repository: git clone https://github.com/egordo17/Bank-REST-API.git
  Navigate to the project directory: cd bank-rest-api
  Run the application:./mvnw spring-boot:run
  The API will be accessible at http://localhost:8080.🛣️ API Endpoints (Quick Reference)EntityPrimary EndpointsCustomers/customersAccounts/accountsCards/cardsTransactions/transactions

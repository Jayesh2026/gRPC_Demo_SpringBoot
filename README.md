## Calculator gRPC Demo

This project demonstrates a simple calculator application using gRPC (Google Remote Procedure Call) in a Spring Boot environment. It provides a server-side implementation for addition and a client application to interact with the server.

### Prerequisites
- Java Development Kit (JDK) version 21 or higher
- Apache Maven
- PostgreSQL (for Spring Boot dependencies)
- IDE (such as IntelliJ IDEA or Eclipse)

### Technologies Used
- Spring Boot
- gRPC
- Protocol Buffers
- PostgreSQL (for Spring Boot dependencies)
- Netty (for gRPC communication)
- Lombok (for reducing boilerplate code)

### Setup Instructions
1. Clone the repository to your local machine.
2. Ensure that Java and Gradle are properly installed and configured.
3. Set up PostgreSQL if you plan to use Spring Boot's data dependencies. Update the `application.properties` file with your database configurations.
4. Import the project into your IDE.
5. Run `CalculatorGRpcDemoApplication.java` to start the gRPC server.
6. Run either `HelloClient.java` or `CalculatorClient.java` to interact with the server.

### Project Structure
- `com.demo`: Main package containing the Spring Boot application class.
  - `service`: Contains the implementation of gRPC services (`AllServicesImpl.java`).
  - `client`: Contains client applications to interact with the server (`HelloClient.java`, `CalculatorClient.java`).
- `com.proto`: Contains Protocol Buffers definitions for service requests and responses.
  - `calculator`: Protocol Buffers definitions for calculator service (`calculator.proto`).
  - `hello`: Protocol Buffers definitions for hello service (`hello.proto`).

### How to Use
- Run the server application (`CalculatorGRpcDemoApplication.java`).
- Choose the client application (`HelloClient.java` or `CalculatorClient.java`) to interact with the server.
- Follow the on-screen instructions to input data and receive responses from the server.


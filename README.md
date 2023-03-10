# Inditex - PoT

## Project description

Project for the creation of a REST API microservice as proof of technology for Inditex company
It creates a simple API Rest with only one method in order to obtain product prices of Inditex company based on a date. 


###Main features and technologies used

- Java 11
- Spring / Spring boot
- Hexagonal architecture
- Domain Driven Design
- H2 memory database
- OpenApi v3 documentation 


# Installation

### Prerequisites

- Maven 3.x
- Java 11


To install and test the service, follow the following steps:

1. Clone git repository

    ```bash
    git clone https://github.com/selaca/pot-inditex.git
   ```
2. Compile application
    ```bash
    mvn clean compile
   ```
3. Test application
    ```bash
    mvn test
   ```
4. Run application

    ```bash
    mvn spring-boot:run
   ```

## Usage

In order to test Rest API library, run microservice and access to OpenAPI v3 documentation on following link: 

***http://<server_name>:8082/swagger-ui.html*** 

### Example to use
   ```bash
   curl -X 'POST' \
    'http://localhost:8082/v1/inditex/prices/product-price' \
    -H 'accept: application/json' \
    -H 'Content-Type: application/json' \
    -d '{
      "date": "2020-06-14 10.00.00",
      "productId": 35455,
      "brandId": 1
}'
   ```

**Note**

Date format parameter: ***"yyyy-MM-dd HH.mm.ss"***

## Author
Sergio Lafuente Cabeza



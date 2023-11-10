## bookshop-api
### Java + Spring Boot + PostgreSQL REST api

Made from scratch. I initially coded out 

  - the getters/setters
  - DAO crud functionalities with SQL statements using JDBC to connect with my DB
  - dealt with cors issues
  - lacked any real project structure

Which I eventually refactored after more research by

  - adding Lombok dependency
  - switching to Spring Data JPA
  - taking advantage of Spring Boot Annotations
  - implementing an MVC project pattern
  - used chatGPT to create some JSON test data

## Tested using cURL commands

### GET
`
curl -v ’http://localhost:8080/books
curl -v ’http://localhost:8080/book?id=#
`

### POST
`curl -v -d ‘{JSON}’ -H ‘Content-Type: application/json’ http:/localhost:8080/book/new`

### PUT
`curl -v -d ‘{JSON}’ -H ‘Content-Type: application/json’ -X PUT http://localhost:8080/book?id=#`

### DELETE
`curl -X DELETE http://localhost:8080/book?id=#`

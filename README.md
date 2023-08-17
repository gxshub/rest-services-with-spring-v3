# REST Services with Spring V3

This project contains two standalone services:
__Library Service__
and __Book Service__. The library and book data are own by 
these two services independently.
The __Book Service__ uses the `RestTemplate` 
API to communicate with the __Library Service__.

### Demonstrating Use Cases
_Find all books_:
```shell
curl -X GET http://localhost:8082/books
```
which returns
```json
[{"title":"Introduction to Software Engineering","isbn":"0-684-84328-5"},{"title":"Domain Drive Design","isbn":"93-86954-21-4"}]
```

_Find available libraries for a book with a specific ISBN_:
```shell
curl -X GET http://localhost:8082/books/{0-684-84328-5}/available
```
which returns
```json
[{"libraryName":"Wollongong City Library","postcode":"2500"},{"libraryName":"UOW Library","postcode":"2522"}]
```

### Application Service Layer
An application service is added to the __Book Service__.
This layer interplays between the REST API Layer (`controller`) and 
the Data Access Layer (`repository`).
It also includes a `RestTemplate` client to get data
from the __Library Service__.

### DTO Pattern
DTOs or Data Transfer Objects are objects that carry data 
between processes in order to reduce the number of methods 
calls. They are also views that prevent the exposure of 
domain classes to the external world.


### _TODO_
_Add an Application Service Layer and DTO classes to the **Library Service**._
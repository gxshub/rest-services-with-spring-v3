# REST Services with Spring V3

This project contains two standalone services:
__Library Service__
and __Book Service__. The library and book data are own by 
these two services independently.
The __Book Service__ uses the `RestTemplate` 
API to communicate with the __Library Service__.

### Demonstrating Use Case
_Find available libraries for a book_ with ISBN `0-684-84328-5`:
```shell
curl -X GET http://localhost:8082/books/{0-684-84328-5}/available
```
The return:
```json
[{"libraryName":"Wollongong City Library","postcode":"2500"},{"libraryName":"UOW Library","postcode":"2522"}]
```

### Application Service Layer
An application service is added to the __Book Service__.
This layer interplays between the REST API Layer (`controller`) and 
the Data Access Layer (`repository`).
It also includes a `RestTemplate` client to get data
from the __Library Service__.

_TODO: Add a similar Application Service Layer to the **Library Service**._
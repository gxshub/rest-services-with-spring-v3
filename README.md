# REST Services with Spring V3 (Domain Class Relationships)

### H2 Console
The following two lines are added to `src/main/resources/application.properties` for both services:
```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
```
The console [http://localhost:8082/h2-console/](http://localhost:8082/h2-console/).
To log on, change the value in the `JDBC URL` entry to
`jdbc:h2:mem:testdb`.

_Check the tables there._

### Implementation of Domain Class Relationships in JPA 
An one-to-one association between [`Address`](./library-service/src/main/java/csci318/demo/model/Address.java) 
and [`Library`](./library-service/src/main/java/csci318/demo/model/Library.java) classes in the library service 
is implemented. Moreover, this association is bidirectional
(i.e., you can access `Library` from `Address` and `Address` from `Library`).

#### Sample Rest Requests
Get a library with ID 2500:
```bash
curl -X GET http://localhost:8081/libraries/2500
```

Create an address with ID 99:
```bash
curl -X POST -H "Content-Type:application/json" -d '{"id":99, "location":"41 Burelli St, Wollongong NSW 2500"}' http://localhost:8081/addresses
```

Link the address to the library:
```bash
curl -i -X PUT http://localhost:8081/libraries/2500/address/99
```

Get the library with a given address (ID):
```bash
curl -X GET http://localhost:8081/addresses/99/library
```

### _TODO_
Add a new domain class `Staff` to the library service 
and implement a one-to-many association between `Library`
and `Staff`. Then modify the association to many-to-many.

References: [https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm](https://www.tutorialspoint.com/jpa/jpa_entity_relationships.htm)

# MoviesManager Backend

## Structure of the application

The application core currently consists of 8 packages:

* config - contains SwaggerConfig class, which allows to set some of the properties for Swagger framework,
* controller - contains one REST controller that enables API user to create, remove and display Movie objects and return them in JSON format
* exception - contains custom exceptions, that are used by the classes in the validation package and returned to the REST API consumer,
* model - stores the basic model of the Movie object, that is used throuout the application. 
The Movie class is annotated, to help Swagger correctly generate autoconfiguration. and helper SortDirection class, used by the controller
* repository - contains repository class required by MongoDb Spring implementation,
* services - contains the interface and it's implemenation defining logic executred after call made by the controller
* validator

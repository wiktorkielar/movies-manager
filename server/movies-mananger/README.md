# MoviesManager Backend

## Structure of the application

The application core currently consists of 8 packages:

* **config** - contains SwaggerConfig class, which allows to set some of the properties for Swagger framework,
* **controller** - contains one REST controller that enables API users to create, remove and display Movie objects and return them in JSON format,
* **exception** - contains custom exceptions that are thrown back to the REST API consumer (used by the validation package classes),
* **model** - stores the basic model of the Movie object, that is used throughout the application. 
The Movie class is annotated, to help Swagger correctly generate documentation. Additionally package consists of helper SortDirection enum.
* **repository** - contains repository class required by MongoDb Spring implementation,
* **services** - contains the interface and it's implemenation defining logic used by the controller class
* **validator** - defines the the validation methods that correspond to MoviesController methods

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

## REST API Endpoints

### Get Movies
Returns the list of Movie object based on the sorting direction defined by the user (ascending or descending).
* **URL**

  /api/movies
  
* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `sortDirection=[string]` , where valid values are `ASC` or `DESC`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**  
    
    ```
    [  
          {  
              "id": "323c4551-c510-4c48-9822-423855a785a8",    
              "title": "ThorRagnarok",  
              "rating": 8.1,  
              "director": "Taika Waititi",  
              "actors": [  
                  "Chris Hemsworth",  
                  "Cate Blanchet"  
              ],  
              "mdAt": "2017-11-19T12:54:57.443"  
        }  
    ]  
    ```
 
* **Error Response:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** 
    ```
    {
        "timestamp": "2017-11-20T04:18:20.827+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Missing mandatory 'sortDirection' field.",
        "path": "/api/movies"
    }
    ```

    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T04:20:57.230+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Empty 'sortDirection' field.",
        "path": "/api/movies"
    }
    ```

    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T04:23:55.281+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "'sortDirection' field's value is not in a valid values set (ASC, DESC).",
        "path": "/api/movies"
    }
    ```

* **Sample Call:**

  ```
    curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:8080/api/movies?sortDirection=ASC'
  ```

### Create Movie
Returns a newly created Movie object, with automatically generated timestamp (createdAt field) and UUID (id field). 

* **URL**

  /api/movies
  
* **Method:**

  `POST`
  
*  **URL Params**

   None

* **Data Params**

   **Required:**
 
   `title=[string]` , where:
   
   * Title cannot be missing.   
   * Title cannot be empty.  
   * Title must contain at least 3 characters.  
   * Title must contain no more than 50 characters.  
   * Title must contain only letters.  
   
   `rating=[number]` , where:
   
   * Rating cannot be missing.   
   * Rating must have minimum value of 1.  
   * Rating must have maximum value of 10.    
   
    `director=[string]` , where:
   
   * Director cannot be missing.    
   * Director cannot be empty.  
   * Director can contain both letters and whitespaces.    
   * Director cannot contain whitespaces alone.  
   
   `actors=[Array[string]]` , where:
   
   * Actor cannot be missing.    
   * Actor cannot be empty.  
   * Actor can contain both letters and whitespaces.    
   * Actor cannot contain whitespaces alone.  

* **Success Response:**

  * **Code:** 201 CREATED <br />
    **Content:**  
    
    ```
    {
        "id": "0d91c0c9-e79e-4d35-9aa5-8676edbfc391",
        "title": "ThorRagnarok",
        "rating": 8.1,
        "director": "Taika Waititi",
        "actors": [
            "Chris Hemsworth",
            "Cate Blanchet"
        ],
        "createdAt": "2017-11-20T06:01:54.143"
    } 
    ```
 
* **Error Response, 'title' field related:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** 
    ```
    {
        "timestamp": "2017-11-20T05:03:26.986+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Missing mandatory 'title' field.",
        "path": "/api/movies"
    }
    ```

    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:04:22.477+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Empty 'title' field.",
        "path": "/api/movies"
    }
    ```

    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:05:01.198+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "'title' field's length (2) is lower than minimum expected (3).",
        "path": "/api/movies"
    }
    ```
    
    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:05:01.198+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "'title' field's length (2) is lower than minimum expected (3).",
        "path": "/api/movies"
    }
    ```
    
    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:06:05.460+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "'title' field's length (65) is higher than maximum expected (50).",
        "path": "/api/movies"
    }
   ```
    
    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:07:35.070+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "'title' field's content does not match regex pattern ([a-zA-Z]+).",
        "path": "/api/movies"
    }
    ```
    
* **Error Response, 'rating' field related:**

  * **Code:** 400 BAD REQUEST <br />
    **Content:** 
    ```
    {
        "timestamp": "2017-11-20T05:03:26.986+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Missing mandatory 'title' field.",
        "path": "/api/movies"
    }
    ```

    OR

  * **Code:** 400 BAD REQUEST <br />
    **Content:**
    ```
    {
        "timestamp": "2017-11-20T05:04:22.477+0000",
        "status": 400,
        "error": "Bad Request",
        "message": "Empty 'title' field.",
        "path": "/api/movies"
    }
    ```
    
    
    curl -X GET --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:8080/api/movies?sortDirection=ASC'


# Customer Data Management Application
This is a Spring Boot application that manages customer data. The application allows CRUD operations on customer data, and provides APIs to remove duplicates based on an input column name and to group data by a given input column value.

create Postman API requests for the above CRUD operations, you can follow these steps:

Open Postman and create a new request collection for the Customer API.

Create a new request for the createCustomer API by setting the HTTP method to POST and the URL to http://localhost:8080/customers. In the Body tab, select the raw option and set the content type to JSON. Then, enter the JSON data for the new customer in the request body.

Create a new request for the getAllCustomers API by setting the HTTP method to GET and the URL to http://localhost:8080/customers.

Create a new request for the getCustomerById API by setting the HTTP method to GET and the URL to http://localhost:8080/customers/{id}, where {id} is the ID of the customer you want to retrieve.

Create a new request for the updateCustomer API by setting the HTTP method to PUT and the URL to http://localhost:8080/customers/{id}, where {id} is the ID of the customer you want to update. In the Body tab, select the raw option and set the content type to JSON. Then, enter the updated JSON data for the customer in the request body.

Create a new request for the deleteCustomer API by setting the HTTP method to DELETE and the URL to http://localhost:8080/customers/{id}, where {id} is the ID of the customer you want to delete.

Create a new request for the removeDuplicates API by setting the HTTP method to GET and the URL to http://localhost:8080/customers/removeDuplicates?inputColumn={column_name}, where {column_name} is the name of the column that you want to remove duplicates for.

Create a new request for the groupBy API by setting the HTTP method to GET and the URL to http://localhost:8080/customers/groupBy?inputColumn={column_name}, where {column_name} is the name of the column that you want to group the customers by.

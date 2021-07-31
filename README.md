# AriesCodingExercise
Trying to create a simple SpringBoot Application which will have multiple services to achieve the requirements provided.
Used IntelliJ IDE for coding & Postman for testing.

**Steps to run the Application:**
-> Import the maven project and run.

-> http://localhost:8080/Scheduler/Service/getProducts/
This is a GET method to retrieve all the products which are present (At the start it will contain none).

-> http://localhost:8080/Scheduler/Service/addProducts
This is a POST method to add the products. Sample body:
[{
	"customerId" : "cust1",
	"productName" : "domain",
	"domain" : "x.com",
	"startDate" : "2020-01-01",
	"durationMonths" : "5"
},
{
	"customerId" : "cust1",
	"productName" : "pdomain",
	"domain" : "y.com",
	"startDate" : "2020-03-01",
	"durationMonths" : "10"
	
}]

-> http://localhost:8080/Scheduler/Service/removeProduct?id=cust1&product=domain&domain=y.com
This is DELETE method to remove the product from existing products.

-> http://localhost:8080/Scheduler/Service/getEmailScheduler/
This is main GET method which will fetch all the products in their order of email date.


**Assumptions:**
-> Wrote a simple program as its time bound so I havent used DB/Spring security etc.
-> I havent tested with negative scenarios.


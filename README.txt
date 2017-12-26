
#Heaven HR Api Services
=======================

This a simple rest api service application for managing job offers and
job applications from candidates interested in the job. The software is
straight forward and easy to use.

It has the following directories and description

ASPECT: For event management and notifications.
CONFIG: Springboot configuration
CONTROLLERS: processes incoming requests, handle user input and interactions, and execute appropriate application logic.
DATA: Domain entities and view dtos for data processing
ENUM: Enumerators
REPOSITORIES: For storage
UTILS: For utiliies
VALIDATORS: It contains login for validating user form submissions

HOW TO USE:
===========

To create a new job example:

URL: localhost:8080/job/create-job
Request Method: POST
{
	"jobTitle": "Software",
	"startDate": "25/12/2017"
}

To view all job offers:

URL: localhost:8080/job
Request Method: GET


To View a single job offer:
localhost:8080/job/view/1
Request Method: GET

To Apply for a job offer as a candidate, relatedOffer is the Id of the job offer
localhost:8080/application/apply
Request Method: POST
{
	"relatedOffer":1, 
	"candidateEmail":"john@yahoo.com",
	"resume":"This is a sample"
}

To view all job applications:
localhost:8080/application
Request Method: GET

To view a job applications, pass the Id of the application:
localhost:8080/application/view/1
Request Method: GET


To update application status
localhost:8080/application/update-status
Request Method: PUT
{
        "relatedOffer": 1,
        "candidateEmail": "john@yahoo.com",
        "status": "INVITED"
}

To get the number of application a job offer, pass Id of the job
localhost:8080/application/count/1
Request Method: GET







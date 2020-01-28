Feature: Login Functionality 

@data-driven 
Scenario: Login with valid credentials 

	Given Navigate to Home page 
	When user enters username and pasword 
	Then user logged in successfully 
	
@data-driven 
Scenario: The one where user picks diffrent product through search functionality 
	When Lalitha searches below products in a search box:
		|Head |
		|Travel |
		|Laptop |
	Then product should be added in the cart if available 
	
	
	@user-specific
   Scenario Outline: test login

	Given Navigate to Home page 
	When user enters "<uname>" and "<pwd>"  
	Then user logged in successfully 
	Examples: 
	    | uname   | pwd         |
	    | lalitha | Password123 |
	    | ABC     | XYZ         |
	    
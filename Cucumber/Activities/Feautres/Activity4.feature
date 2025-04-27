@activity4
Feature: Data driven test without examples

@loginTest @loginSuccess
Scenario: Successful login
	Given the user is on the login page
 	When the user enters "admin" and "password"
	And clicks the submit button
	Then get the confirmation message and verify message as "Welcome Back, Admin!"
	
	
Feature: To validate the login functionality in facebook Application

	Scenario: To validate the login with valid username and valid password
		Given The user in facebookpage
		When  The user has to be fill username and password in textbox 
		And The user click the login button
		Then The user navigate to home page

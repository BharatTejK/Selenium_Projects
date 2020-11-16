Feature: To validate the entire process of logging in searching booking and deleting booked

Scenario: To validate the login with invalid credentials #Business Rule
Given connect to the chrome driver and go to the AHA website
When The credentials of a user are entered
And Click the login button
Then User must navigate to the login page


#Scenario: To validate the login with invalid credentials #Business Rule
#Given connect to the chrome driver and go to the AHA website
#When The credentials of a user are entered
#And Click the login button
#Then User must navigate to the login page
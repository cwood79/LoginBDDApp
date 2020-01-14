Feature: Login Action
 
Scenario: Successful Login with Valid Credentials
 Given User is on Home Page
 When User Navigate to LogIn Page
 And User enters UserName and Password
 And User clicks login button
 Then Page Title is GitHub
 
Scenario: Successful LogOut
 When User LogOut from the Application
 Then Page Title is not GitHub
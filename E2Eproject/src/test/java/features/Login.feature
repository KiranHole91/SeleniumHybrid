Feature: Login page Tests

Scenario Outline: Validate user can access Forgot Password after validation error

Given User initializes the browser
And User navigates to "http://www.qaclickacademy.com/" site
And User clicks on Login to securely redirected to login page
When User enters <username> and <password> and clicks login button
Then User validates forgot password is available

Examples:
|username			|password	|
|test1123@gmail.com |test123	|
|test112@gmail.com  |test123	|
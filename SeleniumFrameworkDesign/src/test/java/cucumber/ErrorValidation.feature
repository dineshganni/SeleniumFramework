
@tag
Feature: Login Errorvalidation for Ecommerce Website
  I want to use this template for my feature file

  
  @Errorvalidation
  Scenario Outline: Login Error validation
    Given I landed on Ecommerce Page  
    When logged in with username <name> and password <password>
    Then "Incorrect emails or password." message is dispalyed

   Examples: 
      | name           | password       |   
      | marse@gmail.com| Mars@12389     |  


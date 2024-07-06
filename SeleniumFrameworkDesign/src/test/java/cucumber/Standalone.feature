
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page 

  @regression
  Scenario Outline: Positive Test of Submitting the order
    Given logged in with username <name> and password <password>
    When I add product <productname> to cart
    And Checkout <productname> submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name           | password     | productname              | 
      | marse@gmail.com| Mars@123     | IPHONE 13 PRO            | 
     

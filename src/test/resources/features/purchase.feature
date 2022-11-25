Feature: Purchase Product in Demo Blaze
  @demoblaze
  Scenario: Placing successfully order
    Given The user is on the home page
    When The user add "Samsung galaxy s6" from "Phones"
    And The user add "MacBook air" from "Laptops"
    And The user add "Apple monitor 24" from "Monitors"
    And The user add "Nexus 6" from "Phones"
    And The user navigates the cart
    And The user removes "MacBook air" product
    Then The user verify that cart list size is 3
    And The user clicks place order
    And The user fill the form and clicks purchase button
    Then The user verify that order is successful and able to see "Thank you for your purchase!" message

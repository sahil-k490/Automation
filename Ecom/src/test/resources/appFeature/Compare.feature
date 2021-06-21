Feature: Compare the Price of Item Feature

@accounts
  Scenario: Compare the price of the item from different sites
    Given user is on Home page "Flipkart"
     When user enters items in search box "samsung galaxy a12"
      And user selects the first item from list
      And print the price of that item
      And saves the item in cart in guest mode
      And user go to the cart section
      And print the price of that item in cart
    Given user is on Home page "Amazon"
     When user enters items in search box "samsung galaxy a12"
      And user selects the first item from list
      And print the price of that item
      And saves the item in cart in guest mode
      And user go to the cart section
      And print the price of that item in cart
      And compare both the prices
     Then print the cheapest rate 
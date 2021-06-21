Feature: Flipkart Cart Page Feature

@accounts
  Scenario: Print the price after increasing the item by 1 in cart
    Given user is on Home page "Flipkart"
     When user enters items in search box "samsung a12"
      And user selects the first item from list
      And print the price of that item
      And saves the item in cart in guest mode
      And user go to the cart section
      And increase the quantity by 1
     Then prints the price of that item

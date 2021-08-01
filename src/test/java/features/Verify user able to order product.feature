Feature: Verify user able to order product

  @Test001
  Scenario Outline:
    When Navigate to Estee Lauder home page
    And Navigate to skincare section
    And Open any random product on the page
    And Save product name and price
    And Add product to the card
    Then Verify button title changed to Added To Bag
    And Navigate to the Card
    Then Verify correct product has been added to the card
    And Click Checkout With Credit Card
    And Click Continue Checkout
    And Click Continue As Guest link on Checkout page
    And Enter email address <email> on Checkout page
    And Click Continue As Guest button on Checkout page
    And Enter First Name <firstName> Last Name <lastName> Address <address> Zip <zip> State <state> City <city> Phone <phone>



    Examples:
      |email            |firstName|lastName|address      |zip  |state|city    |phone       |
      |example@gmail.com|John     |Doe     |110 E 59th St|10022|NY   |New York|756 345 0987|
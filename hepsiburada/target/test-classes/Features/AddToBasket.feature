Feature: feature to test add product to the basket with login

  Scenario: Open login page
    Given user is on homepage
    When user selects login option
    Then user is navigated to the login page

  Scenario Outline: Check successful login
    Given user is on login page
    When user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples:
      | username       | password |
      | cansu@mail.com | sifre    |

  Scenario: Check account info on homepage
    Given user is on homepage
    When user checks the username
    Then user sees the correct username

  Scenario Outline: Search for the product
    Given user is on homepage
    When user enters the <product> name in the search bar
    And clicks on search button
    Then user gets search results for the <searched product>

    Examples:
    | product | searched product |
    | samsung m5 televizyon | samsung M5 |

  Scenario: Open product details page
    Given user is on search results page
    When user clicks the product
    Then user reaches the product details page


  Scenario: Add the product to the basket from the first supplier
    Given user is on product details page
    When user selects the first supplier
    And clicks on add to basket
    Then the product is added to the basket for the first supplier

  Scenario: Add the product to the basket from the second supplier
    Given user is on product details page
    When user selects the second supplier for the same product
    And clicks on add to basket
    Then the product is added to the basket for the second supplier

  Scenario: Check the product is in the basket
    Given user is on basket page
    When user selects the second supplier for the same product
    And clicks on add to basket
    Then the product is added to the basket for the second supplier
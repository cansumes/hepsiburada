Feature: add product to the basket from search results with a defined user

  Scenario Outline: Verification of adding searched product to the basket after login
    Given user is on homepage
    And user logins with <username> and <password>
    And user makes a search for a <product>
    And user clicks on a search result
    And user adds the product from the first supplier to the basket
    And user adds the product from the second supplier to the basket
    When user navigates to the basket
    Then user sees two products in the basket from selected suppliers

    Examples:
      | username       | password | product    |
      | cansu@mail.com | 123456    | samsung m5 |
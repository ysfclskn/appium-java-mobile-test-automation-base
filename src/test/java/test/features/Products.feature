Feature: Products Test Suite

  @smoke @verify_products
  Scenario: Verify products is exist
    When login with registered user on login page
    Then verify successful login
    When click product list on homepage
    Then verify products is exist